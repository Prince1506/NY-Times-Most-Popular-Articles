package com.mvp_clean.ny_times_articles.dashboard.view.activities

import android.os.Bundle
import android.util.Log
import android.view.Menu
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import com.google.android.material.snackbar.Snackbar
import com.mvp_clean.ny_times_articles.R
import com.mvp_clean.ny_times_articles.core.callback.IRetryCallBack
import com.mvp_clean.ny_times_articles.core.constants.IKeyConstant
import com.mvp_clean.ny_times_articles.core.di.CoreDI
import com.mvp_clean.ny_times_articles.core.view.activities.BaseActivity
import com.mvp_clean.ny_times_articles.dashboard.domain.NyTimesMostViewArticlesViewModel
import com.mvp_clean.ny_times_articles.dashboard.view.INyTimesDashboardView
import com.mvp_clean.ny_times_articles.dashboard.view.fragments.home.NYTimesHomeFragment
import com.mvp_clean.ny_times_articles.dashboard.view.presenter.NyTimesDashboardPresenter
import kotlinx.android.synthetic.main.app_bar_main.*
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
//        val toolbar: Toolbar = findViewById(R.id.toolbar)
//        val fab: FloatingActionButton = findViewById(R.id.fab)

        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }

/*
        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        val navView: NavigationView = findViewById(R.id.nav_view)
        val navController = findNavController(R.id.nav_host_fragment)
        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow
            ), drawer_layout
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        nav_view.setupWithNavController(navController)
*/
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
    }

    override fun showArticles(nyTimesMostViewArticlesViewModels: NyTimesMostViewArticlesViewModel) {
        val bundle = Bundle()
        bundle.putParcelable(IKeyConstant.articleMostViewedList, nyTimesMostViewArticlesViewModels)
        changeFragment(NYTimesHomeFragment(), bundle, false )
    }

    fun changeFragment(fragment: androidx.fragment.app.Fragment,
                       bundle: Bundle?,
                       addToBackStack: Boolean) {

        try {
            if (isNetworkAvailable(this)) {
                if (!isFinishing && !isDestroyed) {
                    val fm = supportFragmentManager
                    val ft = fm.beginTransaction()
                    if (bundle != null) {
                        fragment.arguments = bundle
                    }
                    Log.d("nameclass", fragment.javaClass.simpleName)
                    ft.replace(R.id.nav_host_fragment, fragment, fragment.javaClass.simpleName)
                    if (addToBackStack) {
                        ft.addToBackStack(null)
                    }
                    ft.commitAllowingStateLoss()
                }
            } else {
                startServerApiErrorScreen(IKeyConstant.noInternet)
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }


}