package dev.goobar.androidstudyguidejuly21

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.widget.Toolbar
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    val toolbar: Toolbar = findViewById(R.id.toolbar)
    toolbar.inflateMenu(R.menu.main_toolbar)
    toolbar.setOnMenuItemClickListener { menuItem ->
      val startTwitterIntent = Intent(this, TwitterActivity::class.java)
      startActivity(startTwitterIntent)
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
}