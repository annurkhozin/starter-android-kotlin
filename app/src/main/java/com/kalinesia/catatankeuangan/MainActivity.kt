package com.kalinesia.catatankeuangan

import android.app.AlertDialog
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.widget.NestedScrollView
import androidx.fragment.app.Fragment
import com.kalinesia.catatankeuangan.com.kalinesia.catatankeuangan.MyPreferences
import com.kalinesia.catatankeuangan.home.HomeFragment
import com.kalinesia.catatankeuangan.more.MoreFragment
import com.kalinesia.catatankeuangan.mutasi.MutasiFragment
import com.kalinesia.catatankeuangan.piutang.PiutangFragment
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.floating_button_plus.view.*
import kotlinx.android.synthetic.main.fragment_piutang.view.*
import java.util.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        checkLanguage()
        checkTheme()
        bottomBar()
        loadMainFragmentNoBack(HomeFragment())

    }

    private fun bottomBar(){
        bottomBar.onItemSelected = {
            when(it){
                0 -> loadMainFragmentNoBack(HomeFragment())
                1 -> loadMainFragmentNoBack(PiutangFragment())
                2 -> loadMainFragmentNoBack(MutasiFragment())
                3 -> loadMainFragmentNoBack(MoreFragment())
            }
        }

        bottomBar.onItemReselected = {
            when(it){
                0 -> loadMainFragmentNoBack(HomeFragment())
                1 -> loadMainFragmentNoBack(PiutangFragment())
                2 -> loadMainFragmentNoBack(MutasiFragment())
                3 -> loadMainFragmentNoBack(MoreFragment())
            }
        }
    }

    fun loadMainFragmentNoBack(fragment: Fragment){
        val manager = supportFragmentManager
        val transaction = manager.beginTransaction()
        transaction.replace(R.id.fragment_main, fragment)
        transaction.commit()
    }

    fun loadMainFragment(fragment: Fragment){
        val manager = supportFragmentManager
        val transaction = manager.beginTransaction()
        transaction.replace(R.id.fragment_main, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }


    fun floatingScrolling(view: View){
        view.nestedScrollView.setOnScrollChangeListener(NestedScrollView.OnScrollChangeListener { _, _, scrollY, _, oldScrollY -> // v, scrollX, scrollY, oldScrollX, oldScrollY
            //  the delay of the extension of the FAB is set for 12 items
            if (scrollY > oldScrollY + 12 && view.extFloatingActionButton.isShown) {
                view.extFloatingActionButton.hide()
            }

            // the delay of the extension of the FAB is set for 12 items
            if (scrollY < oldScrollY - 12 && !view.extFloatingActionButton.isShown) {
                view.extFloatingActionButton.show()
            }

            // if the nestedScrollView is at the first item of the list then the
            // floating action should be in show state
            if (scrollY == 0) {
                view.extFloatingActionButton.show()
            }
        })
    }

    private fun checkTheme(){
        when (MyPreferences(this).darkMode) {
            0 -> {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM)
            }
            1 -> {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            }
            2 -> {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            }

        }
    }

    private fun checkLanguage(){
        when (MyPreferences(this).langMode) {
            0 -> {
                changeLanguage("en")
            }
            1 -> {
                changeLanguage("id")
            }

        }
    }

    @Suppress("DEPRECATION")
    fun changeLanguage(code: String) {
        val config = resources.configuration
        val locale = Locale(code)
        Locale.setDefault(locale)
        config.locale = locale
        resources.updateConfiguration(config, resources.displayMetrics)
    }

}