package com.example.meleemanual

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private lateinit var toolbar: Toolbar
    private lateinit var drawer: DrawerLayout
    private lateinit var toggle: ActionBarDrawerToggle
    private lateinit var navigationView: NavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        connectViews()

        //Setup Navigation bar view
        navigationView.setNavigationItemSelectedListener(this)
        //Setup toggle button for NavBar
        setSupportActionBar(toolbar)
        setupToggleBar()

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction().replace(R.id.fragment_container, HomeFragment()).commit()
            navigationView.setCheckedItem(R.id.nav_home)
        }
    }

    private fun connectViews() {
        toolbar = this.findViewById(R.id.toolbar)
        drawer = this.findViewById(R.id.drawer_layout)
        navigationView = this.findViewById(R.id.nav_view)
    }

    private fun setupToggleBar() {
        toggle = ActionBarDrawerToggle(this, drawer, toolbar,
            R.string.navigaation_drawer_open, R.string.navigaation_drawer_close)
        drawer.addDrawerListener(toggle)
        toggle.syncState()
    }

    override fun onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.getItemId()) {
            //If Navigation Item is clicked, Go to corresponding fragment
            R.id.nav_home -> supportFragmentManager.beginTransaction().replace(R.id.fragment_container, HomeFragment()).commit()
            R.id.nav_frame_data -> supportFragmentManager.beginTransaction().replace(R.id.fragment_container, FrameDataFragment()).commit()
            R.id.nav_character_guides -> supportFragmentManager.beginTransaction().replace(R.id.fragment_container, CharacterGuideFragment()).commit()
            R.id.nav_character_communities -> supportFragmentManager.beginTransaction().replace(R.id.fragment_container, CharacterCommunitiesFragment()).commit()
            R.id.nav_submit -> Toast.makeText(this, "Submit A Guide", Toast.LENGTH_SHORT).show()
        }
        drawer.closeDrawer(GravityCompat.START)
        return true;
    }

}