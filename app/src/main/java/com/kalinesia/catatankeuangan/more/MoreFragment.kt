package com.kalinesia.catatankeuangan.more

import android.app.AlertDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.app.ActivityCompat.recreate
import com.kalinesia.catatankeuangan.MainActivity
import com.kalinesia.catatankeuangan.R
import com.kalinesia.catatankeuangan.com.kalinesia.catatankeuangan.MyPreferences
import kotlinx.android.synthetic.main.fragment_more.view.*
import java.util.*

class MoreFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_more, container, false)
        initValue(view)
        actionMenu(view)
        return view
    }

    private fun initValue(view: View){
        when(MyPreferences(context).darkMode){
            0 -> view.valTheme.text = getString(R.string.default_sistem)
            1 -> view.valTheme.text = getString(R.string.terang)
            2 -> view.valTheme.text = getString(R.string.gelap)
        }
        when(MyPreferences(context).langMode){
            0 -> view.valBahasa.text = "English"
            1 -> view.valBahasa.text = "Indonesia"
        }
    }
    private fun actionMenu(view: View){
        view.lvTheme.setOnClickListener{
            chooseThemeDialog()
        }
        view.lvBahasa.setOnClickListener{
            chooseLanguageDialog()
        }
    }

    private fun chooseThemeDialog() {
        val builder = AlertDialog.Builder(context)
        builder.setTitle(getString(R.string.pilih_tema))
        val styles = arrayOf(getString(R.string.default_sistem), getString(R.string.terang), getString(
                    R.string.gelap))
        val checkedItem = MyPreferences(context).darkMode

        builder.setSingleChoiceItems(styles, checkedItem) { dialog, which ->
            when (which) {
                0 -> {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM)
                    MyPreferences(context).darkMode = 0
                    dialog.dismiss()
                }
                1 -> {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                    MyPreferences(context).darkMode = 1
                    dialog.dismiss()
                }
                2 -> {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                    MyPreferences(context).darkMode = 2
                    dialog.dismiss()
                }

            }
        }

        val dialog = builder.create()
        dialog.show()
    }

    private fun chooseLanguageDialog() {
        val builder = AlertDialog.Builder(context)
        builder.setTitle(getString(R.string.pilih_bahasa))
        val styles = arrayOf("English", "Indonesia")
        val checkedItem = MyPreferences(context).langMode

        builder.setSingleChoiceItems(styles, checkedItem) { dialog, which ->
            when (which) {
                0 -> {
                    (activity as MainActivity?)!!.changeLanguage("en")
                    MyPreferences(context).langMode = 0
                    (activity as MainActivity?)!!.recreate()
                    dialog.dismiss()
                }
                1 -> {
                    (activity as MainActivity?)!!.changeLanguage("id")
                    MyPreferences(context).langMode = 1
                    (activity as MainActivity?)!!.recreate()
                    dialog.dismiss()
                }

            }
        }

        val dialog = builder.create()
        dialog.show()
    }


}