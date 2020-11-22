package com.mvp_clean.ny_times_articles.dashboard.view.activities

import android.os.Bundle
import android.view.Menu
import androidx.appcompat.widget.Toolbar
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.navigation.NavigationView
import com.google.android.material.snackbar.Snackbar
import com.mvp_clean.ny_times_articles.R
import com.mvp_clean.ny_times_articles.core.callback.IRetryCallBack
import com.mvp_clean.ny_times_articles.core.di.CoreDI
import com.mvp_clean.ny_times_articles.core.view.activities.BaseActivity
import com.mvp_clean.ny_times_articles.dashboard.domain.NyTimesMostViewArticlesViewModels
import com.mvp_clean.ny_times_articles.dashboard.view.INyTimesDashboardView
import com.mvp_clean.ny_times_articles.dashboard.view.presenter.NyTimesDashboardPresenter
import javax.inject.Inject

class NyTimesDashboardActivity : BaseActivity(), INyTimesDashboardView, IRetryCallBack {

    private lateinit var appBarConfiguration: AppBarConfiguration
    val previousDate = 1

    var nyTimesDashboardPresenter: NyTimesDashboardPresenter? = null
    @Inject set

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        CoreDI.getDStvComponent()?.inject(this)
        nyTimesDashboardPresenter?.bind(this)
        setupNavigationDrawer()
        nyTimesDashboardPresenter?.getArticles(previousDate)

    }

    private fun setupNavigationDrawer() {
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        val fab: FloatingActionButton = findViewById(R.id.fab)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }

        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        val navView: NavigationView = findViewById(R.id.nav_view)
        val navController = findNavController(R.id.nav_host_fragment)
        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow
            ), drawerLayout
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }

    override fun showRetry() {
        TODO("Not yet implemented")
    }

    override fun showArticles(nyTimesMostViewArticlesViewModels: NyTimesMostViewArticlesViewModels) {
        TODO("Not yet implemented")
    }
}