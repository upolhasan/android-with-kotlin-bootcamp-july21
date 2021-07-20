package dev.goobar.androidstudyguidejuly21

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.widget.Toolbar
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
    bottomNav.setOnItemSelectedListener { menuItem ->
      when (menuItem.itemId) {
        R.id.myNotes -> {
          supportFragmentManager.beginTransaction().replace(R.id.fragmentContainer, MyNotesFragment()).commit()
          true
        }
        R.id.guide -> {
          supportFragmentManager.beginTransaction().replace(R.id.fragmentContainer, StudyGuideFragment()).commit()
          true
        }
        else -> false
      }
    }
    bottomNav.selectedItemId = R.id.myNotes
  }
}