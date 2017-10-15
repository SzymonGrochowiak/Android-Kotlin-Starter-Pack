package com.szymongrochowiak.androidkotlinstarterpack.ui.main

import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.design.widget.Snackbar
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import com.szymongrochowiak.androidkotlinstarterpack.R
import com.szymongrochowiak.androidkotlinstarterpack.data.model.Berry
import com.szymongrochowiak.androidkotlinstarterpack.ui.common.activities.base.BaseActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar_main.*
import kotlinx.android.synthetic.main.content_main.*
import java.util.*

/**
 * @author Szymon Grochowiak
 */
class MainActivity : BaseActivity<MainView, MainPresenter>(), MainView, NavigationView.OnNavigationItemSelectedListener {

    companion object {
        val BUNDLE_KEY_BERRY_ID = "berry_id"
    }

    private lateinit var mainComponent: MainComponent

    private var berryId = generateBerryId()

    override fun injectDependencies() {
        mainComponent = DaggerMainComponent.builder().applicationComponent(getDaggerApplicationComponent()).build()
    }

    override fun createPresenter() = mainComponent.presenter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        actionButton.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG).setAction("Action", null).show()
        }

        val toggle = ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.navigation_drawer_open,
                R.string.navigation_drawer_close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        navigationView.setNavigationItemSelectedListener(this)

        if (savedInstanceState != null) {
            berryId = savedInstanceState.getLong(BUNDLE_KEY_BERRY_ID)
        }
        getPresenter().queryBerry(berryId)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putLong(BUNDLE_KEY_BERRY_ID, berryId)
        super.onSaveInstanceState(outState)
    }

    override fun onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean = when (item.itemId) {
        R.id.action_settings -> true
        else -> super.onOptionsItemSelected(item)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.nav_camera -> {
            }
            R.id.nav_gallery -> {
            }
            R.id.nav_slideshow -> {
            }
            R.id.nav_manage -> {
            }
            R.id.nav_share -> {
            }
            R.id.nav_send -> {
            }
        }

        drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }

    override fun showLoading() {
        progressBar.visibility = View.VISIBLE
    }

    override fun showContent(berry: Berry) {
        berryTextView.text = berry.name
    }

    override fun showError(errorMessage: String) {
        berryTextView.text = errorMessage
    }

    override fun hideLoading() {
        progressBar.visibility = View.GONE
    }

    private fun generateBerryId() = Random().nextInt(20).toLong()
}
