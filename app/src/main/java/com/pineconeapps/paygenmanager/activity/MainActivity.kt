package com.pineconeapps.paygenmanager.activity

import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.view.Menu
import android.view.MenuItem
import com.pineconeapps.paygenmanager.R
import com.pineconeapps.paygenmanager.fragment.CostumerListFragment
import com.pineconeapps.paygenmanager.util.UserInfo
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar_main.*
import org.jetbrains.anko.startActivity

class MainActivity : BaseActivity(), NavigationView.OnNavigationItemSelectedListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        val toggle = ActionBarDrawerToggle(
                this, drawer_layout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()
        nav_view.setNavigationItemSelectedListener(this)

        fragmentManager.inTransaction { add(R.id.container, CostumerListFragment()) }

    }

    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_settings -> return true
            else -> return super.onOptionsItemSelected(item)
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.
        when (item.itemId) {
            R.id.nav_employees -> {
                startActivity<EmployeesActivity>()
            }
            R.id.nav_products -> {
                startActivity<ProductsActivity>()
            }
            R.id.nav_images -> {
                startActivity<ImageActivity>()
            }
            R.id.nav_reports -> {
                startActivity<SalesActivity>()
            }
            R.id.nav_send -> {
                UserInfo.clearData()
                startActivity<SplashActivity>()
                finish()
            }
        }

        drawer_layout.closeDrawer(GravityCompat.START)
        return false
    }
}
