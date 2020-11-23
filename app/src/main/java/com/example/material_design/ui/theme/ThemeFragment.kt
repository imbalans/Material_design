package com.example.material_design.ui.theme

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import com.example.material_design.R


class ThemeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootview = inflater.inflate(R.layout.fragment_theme, container, false)

        val btnRed : Button = rootview.findViewById(R.id.btn_red)
        btnRed.setOnClickListener{
            (requireActivity().findViewById<View>(R.id.drawer_layout) as DrawerLayout).setBackgroundColor(R.style.AppTheme_Red)
        }

        val btnBlue : Button = rootview.findViewById(R.id.btn_blue)
        btnBlue.setOnClickListener{
            (requireActivity().findViewById<View>(R.id.drawer_layout) as DrawerLayout).setBackgroundColor(R.style.AppTheme_Blue)
        }

        val btnYellow : Button = rootview.findViewById(R.id.btn_yellow)
        btnYellow.setOnClickListener{
            (requireActivity().findViewById<View>(R.id.drawer_layout) as DrawerLayout).setBackgroundColor(R.style.AppTheme_Yellow)
        }

        val btnWhite : Button = rootview.findViewById(R.id.btn_white)
        btnWhite.setOnClickListener{
            (requireActivity().findViewById<View>(R.id.drawer_layout) as DrawerLayout).setBackgroundColor(R.style.AppTheme_White)
        }

        return rootview
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}