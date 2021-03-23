package com.kalinesia.catatankeuangan.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.ViewPager
import com.kalinesia.catatankeuangan.MainActivity
import com.kalinesia.catatankeuangan.R
import com.kalinesia.catatankeuangan.more.MoreFragment
import com.kalinesia.catatankeuangan.piutang.PiutangFragment
import kotlinx.android.synthetic.main.fragment_home.view.*


class HomeFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_home, container, false)
        (activity as MainActivity?)!!.floatingScrolling(view)
        return view
    }

}