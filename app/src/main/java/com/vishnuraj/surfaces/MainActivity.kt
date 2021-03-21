package com.vishnuraj.surfaces

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.vishnuraj.surfaces.databinding.ActivityMainBinding
import com.vishnuraj.surfaces.ui.main.SectionsPagerAdapter


class MainActivity : AppCompatActivity() {

    private lateinit var activityMainBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        val view = activityMainBinding.root
        setContentView(view)

        val tabs = activityMainBinding.tabs
        val viewPager = activityMainBinding.viewPager
        val sectionsPagerAdapter = SectionsPagerAdapter(this, supportFragmentManager)

        viewPager.adapter = sectionsPagerAdapter
        viewPager.offscreenPageLimit = 5
        tabs.setupWithViewPager(viewPager)

    }

}