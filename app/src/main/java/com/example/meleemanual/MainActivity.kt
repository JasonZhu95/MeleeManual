package com.example.meleemanual

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout

class MainActivity : AppCompatActivity() {

    private lateinit var toolbar: Toolbar
    private lateinit var drawer: DrawerLayout
    private lateinit var toggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        connectViews()

        //Setup toggle button for NavBar
        setSupportActionBar(toolbar)
        setupToggleBar()
    }

    private fun connectViews() {
        toolbar = this.findViewById(R.id.toolbar)
        drawer = this.findViewById(R.id.drawer_layout)
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

}