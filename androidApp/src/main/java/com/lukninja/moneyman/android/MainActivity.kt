package com.lukninja.moneyman.android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import androidx.core.view.forEachIndexed
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.navigation.NavigationView
import com.lukninja.moneyman.android.databinding.ActivityMainBinding
import com.lukninja.moneyman.localize.clock
import com.lukninja.moneyman.localize.home
import com.lukninja.moneyman.localize.localizeString
import com.lukninja.moneyman.localize.payment

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private var _binding: ActivityMainBinding? = null
    private val binding: ActivityMainBinding get() = _binding!!

    private lateinit var navController: NavController
    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.navHostFragmentContentMain) as NavHostFragment
        navController = navHostFragment.navController

        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)
        binding.bottomNavigation.setupWithNavController(navController)

        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.homeFragment,
                R.id.clientFragment,
                R.id.moneyFragment
            )
        )

        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
        actionBar?.hide()
        binding.toolbar.setupWithNavController(navController, appBarConfiguration)
        configureDestination()
        setupActionBarWithNavController(
            navController,
            appBarConfiguration
        )

        setupBottomNavigation()

        val graph = navController.navInflater.inflate(R.navigation.nav_graph)
        navController.graph = graph

//        binding.bottomNavigation.visibility = View.GONE
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.navHostFragmentContentMain)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        return true
    }

    private fun configureDestination() {
        navController.addOnDestinationChangedListener { _, destination, _ ->
            val isTopLevelDestination = appBarConfiguration.topLevelDestinations.contains(destination.id)

            if (!isTopLevelDestination) binding.toolbar.setNavigationIcon(R.drawable.ic_back)

//            showToolbarAndBottom(destination.id)

            when (destination.id) {
                R.id.homeFragment -> {
                    setTitleFragment(home.localizeString())
                }
                R.id.clientFragment -> {
                    setTitleFragment(clock.localizeString())
                }
                R.id.moneyFragment -> {
                    setTitleFragment(payment.localizeString())
                }
            }
        }
    }

    private fun setTitleFragment(title: String) {
        if (title.length > 22) {
            binding.toolbar.title = ""
            binding.toolbar.subtitle = title
        } else {
            binding.toolbar.title = title
            binding.toolbar.subtitle = ""
        }
    }

//    private fun showToolbarAndBottom(destination: Int) {
//        if (destination in withoutToolbarScreens) {
//            binding.toolbar.visibility = View.GONE
//            binding.bottomNavigation.visibility = View.GONE
//        } else {
//            binding.toolbar.visibility = View.VISIBLE
//            binding.bottomNavigation.visibility = View.VISIBLE
//        }
//    }

    private fun setupBottomNavigation() {
        binding.bottomNavigation.menu.apply {
            this.forEachIndexed { index, item ->
                setTextBottomNavigation(index, item)
            }
        }
    }

    private fun setTextBottomNavigation(index: Int, item: MenuItem) {
        when (index) {
            0 -> item.title = home.localizeString()
            1 -> item.title = clock.localizeString()
            2 -> item.title = payment.localizeString()
        }
    }
}