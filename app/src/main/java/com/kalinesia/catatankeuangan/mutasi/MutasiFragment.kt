package com.kalinesia.catatankeuangan.mutasi

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.kalinesia.catatankeuangan.MainActivity
import com.kalinesia.catatankeuangan.R

class MutasiFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_mutasi, container, false)
        (activity as MainActivity?)!!.floatingScrolling(view)
        return view
    }

}