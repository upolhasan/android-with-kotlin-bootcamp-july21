package dev.goobar.androidstudyguidejuly21

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.Toolbar
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import dev.goobar.androidstudyguidejuly21.twitter.TwitterActivity

class MainActivity : AppCompatActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    val toolbar: Toolbar = findViewById(R.id.toolbar)
    toolbar.inflateMenu(R.menu.main_toolbar)
    toolbar.setOnMenuItemClickListener { menuItem ->
      when (menuItem.itemId) {
        R.id.menuShowTwitter -> openTwitterActivity()
        R.id.menuShare -> sendShareIntent()
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
}