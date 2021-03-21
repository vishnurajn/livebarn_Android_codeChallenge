package com.vishnuraj.surfaces.ui.main

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.vishnuraj.surfaces.R

private val TAB_TITLES = arrayOf(
        R.string.tab_text_1,
        R.string.tab_text_2,
        R.string.tab_text_3,
        R.string.tab_text_4,
        R.string.tab_text_5
)


class SectionsPagerAdapter(private val context: Context, fm: FragmentManager)
    : FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        var fragment = PlaceholderFragment.newInstance(position)
        // getItem is called to instantiate the fragment for the given page.
        // Return a PlaceholderFragment (defined as a static inner class below).
        when (position) {
            1 -> {
                fragment = PlaceholderFragment.newInstance(position)
            }
            2 -> {
                fragment = PlaceholderFragment.newInstance(position)
            }
            3 -> {
                fragment = PlaceholderFragment.newInstance(position)
            }
            4 -> {
                fragment = PlaceholderFragment.newInstance(position)
            }
            5 -> {
                fragment = PlaceholderFragment.newInstance(position)
            }
        }
        return fragment
    }

    override fun getPageTitle(position: Int): CharSequence {
        return context.resources.getString(TAB_TITLES[position])
    }

    override fun getCount(): Int {
        // Show 5 total pages.
        return 5
    }
}