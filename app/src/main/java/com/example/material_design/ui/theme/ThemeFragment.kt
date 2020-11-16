package com.example.material_design.ui.theme

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.material_design.R

class ThemeFragment : Fragment() {

    private lateinit var themeViewModel: ThemeViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        val rootview = inflater.inflate(R.layout.fragment_theme, container, false)

        return rootview
    }
}