package dev.goobar.androidstudyguidejuly21

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.snackbar.Snackbar
import dev.goobar.androidstudyguidejuly21.twitter.TwitterActivity

private const val REQUEST_LOCATION_PERMISSIONS = 99

class MainActivity : AppCompatActivity() {

  private lateinit var fusedLocationClient: FusedLocationProviderClient

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    fusedLocationClient = LocationServices.getFusedLocationProviderClient(this)

    val toolbar: Toolbar = findViewById(R.id.toolbar)
    toolbar.inflateMenu(R.menu.main_toolbar)
    toolbar.setOnMenuItemClickListener { menuItem ->
      when (menuItem.itemId) {
        R.id.menuShowTwitter -> openTwitterActivity()
        R.id.menuShare -> sendShareIntent()
        R.id.location -> getLocation()
      }
      true
    }

    val bottomNav: BottomNavigationView = findViewById(R.id.bottomNavigation)
    val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragmentContainer) as NavHostFragment
    val navController = navHostFragment.navController
    val appBarConfiguration = AppBarConfiguration(setOf(R.id.myNotesFragment, R.id.studyGuideFragment))

    bottomNav.setupWithNavController(navController)
    toolbar.setupWithNavController(navController, appBarConfiguration)

    navController.addOnDestinationChangedListener { controller, destination, arguments ->
      val showUiChrome = arguments?.getBoolean("ShowUIChrome", false) == true
      bottomNav.visibility = if(showUiChrome) View.VISIBLE else View.GONE
    }

    // check if fresh start or not
    if (savedInstanceState == null) {
      bottomNav.selectedItemId = R.id.myNotesFragment
    }
  }

  override fun onBackPressed() {
    if(findNavController(R.id.fragmentContainer).popBackStack()) return
    super.onBackPressed()
  }

  override fun onRequestPermissionsResult(
    requestCode: Int,
    permissions: Array<out String>,
    grantResults: IntArray
  ) {
    super.onRequestPermissionsResult(requestCode, permissions, grantResults)
    if (requestCode == REQUEST_LOCATION_PERMISSIONS) {
      if (grantResults.size == 1 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
        getLocation()
      } else {
        Snackbar.make(
          findViewById(android.R.id.content),
          "Location permission denied",
          Snackbar.LENGTH_SHORT,
        ).show()
      }
    }
  }

  private fun openTwitterActivity() {
    startActivity(Intent(this, TwitterActivity::class.java))
  }

  private fun sendShareIntent() {
    val intent = Intent(Intent.ACTION_SEND).apply {
      type = "text/plain"
      putExtra(Intent.EXTRA_SUBJECT, "Android Bootcamp w/ Kotlin")
      putExtra(Intent.EXTRA_TEXT, "I'm learning a lot about Android today!!!")
    }
    startActivity(intent)
  }

  private fun getLastLocation() {
    fusedLocationClient.lastLocation.addOnSuccessListener { location ->
      Toast.makeText(
        this@MainActivity,
        "The last location was lat = ${location.latitude}, long = ${location.longitude}",
        Toast.LENGTH_SHORT
      ).show()
    }
  }

  private fun getLocation() {
    if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
      getLastLocation()
    } else if (shouldShowRequestPermissionRationale(Manifest.permission.ACCESS_FINE_LOCATION)) {
      Snackbar.make(
        findViewById(android.R.id.content),
        "Location permission is required to finish this lab",
        Snackbar.LENGTH_SHORT,
      ).setAction("Accept") {
        ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.ACCESS_FINE_LOCATION), REQUEST_LOCATION_PERMISSIONS)
      }.show()
    } else {
      ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.ACCESS_FINE_LOCATION), REQUEST_LOCATION_PERMISSIONS)
    }
  }
}