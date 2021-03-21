package com.vishnuraj.surfaces.ui.main

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ExpandableListAdapter
import android.widget.ExpandableListView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import com.vishnuraj.surfaces.R
import com.vishnuraj.surfaces.data.APIService
import com.vishnuraj.surfaces.data.Post
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response



class PlaceholderFragment : Fragment() {

    private val listDataOne = HashMap<String, List<Post>>()
    private val listDataOneContents = ArrayList<Post>()
    private val listDataTwo = HashMap<String, List<Post>>()
    private val listDataTwoContents = ArrayList<Post>()
    private val listDataThree = HashMap<String, List<Post>>()
    private val listDataThreeContents = ArrayList<Post>()
    private val listDataFour = HashMap<String, List<Post>>()
    private val listDataFourContents = ArrayList<Post>()
    private val listDataFive = HashMap<String, List<Post>>()
    private val listDataFiveContents = ArrayList<Post>()

    private var expandableListView: ExpandableListView? = null
    private var loadingProgressBar: ProgressBar? = null

    private var adapter: ExpandableListAdapter? = null
    private var titleList: ArrayList<String> ? = null

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_main, container, false)

        expandableListView = root.findViewById(R.id.expandableListView)
        loadingProgressBar = root.findViewById(R.id.progress_circular)
        var listData = HashMap<String, List<Post>>()

        // API Call
        val postsCall: Call<List<Post>> = APIService.getApiService().getPosts()
        postsCall.enqueue(object : Callback<List<Post>> {
            override fun onResponse(call: Call<List<Post>>, response: Response<List<Post>>) {
                val posts: List<Post> = response.body()!!
                for (post in posts) {
                    when {
                        post.getSport() == getString(R.string.tab_text_1) -> {
                            listDataOneContents.add(post)
                            listDataOne[post.getVenueName()!!] = listDataOneContents
                        }
                        post.getSport() == getString(R.string.tab_text_2) -> {
                            listDataTwoContents.add(post)
                            listDataTwo[post.getVenueName()!!] = listDataTwoContents
                        }
                        post.getSport() == getString(R.string.tab_text_3) -> {
                            listDataThreeContents.add(post)
                            listDataThree[post.getVenueName()!!] = listDataThreeContents
                        }
                        post.getSport() == getString(R.string.tab_text_4) -> {
                            listDataFourContents.add(post)
                            listDataFour[post.getVenueName()!!] = listDataFourContents
                        }
                        post.getSport() == getString(R.string.tab_text_5) -> {
                            listDataFiveContents.add(post)
                            listDataFive[post.getVenueName()!!] = listDataFiveContents
                        }
                    }
                }
                when {
                    arguments?.getInt(ARG_SECTION_NUMBER) == 0 -> {
                        listData = listDataOne
                    }
                    arguments?.getInt(ARG_SECTION_NUMBER) == 1 -> {
                        listData = listDataTwo
                    }
                    arguments?.getInt(ARG_SECTION_NUMBER) == 2 -> {
                        listData = listDataThree
                    }
                    arguments?.getInt(ARG_SECTION_NUMBER) == 3 -> {
                        listData = listDataFour
                    }
                    arguments?.getInt(ARG_SECTION_NUMBER) == 4 -> {
                        listData = listDataFive
                    }
                }
                titleList = ArrayList(listData.keys)
                titleList!!.sort()
                adapter = CustomExpandableListAdapter(requireContext(), titleList as ArrayList<String>, listData)
                expandableListView!!.setAdapter(adapter)
                expandableListView!!.visibility = View.VISIBLE
                loadingProgressBar!!.visibility = View.GONE
                expandableListView!!.setOnChildClickListener { parent, v, groupPosition, childPosition, id ->
                    val heading = listData[(titleList as ArrayList<String>)[groupPosition]]!![childPosition].getSurfaceName()
                    val msg = listData[(titleList as ArrayList<String>)[groupPosition]]!![childPosition].getVenueName()
                    val builder: AlertDialog.Builder = AlertDialog.Builder(requireContext())
                    val title = TextView(requireContext())
                    title.text = heading
                    title.setPadding(10, 10, 10, 10)
                    title.gravity = Gravity.CENTER
                    title.setTextColor(Color.WHITE)
                    title.setTypeface(null, Typeface. BOLD)
                    title.textSize = 20f
                    builder.setCustomTitle(title)
                    builder.setMessage(msg.toString())
                            .setPositiveButton("OK") { dialog, which ->
                                dialog.dismiss()
                                val myIntent = Intent(requireContext(), VideoPlayer::class.java)
                                activity!!.startActivity(myIntent)
                            }
                            .setNegativeButton("Cancel") { dialog, which -> dialog.dismiss() }
                            .show()

                    false
                }
            }
            override fun onFailure(call: Call<List<Post>>, t: Throwable) {
                println("FAILED")
            }
        })

        return root
    }

    companion object {
        private const val ARG_SECTION_NUMBER = "section_number"
        @JvmStatic
        fun newInstance(sectionNumber: Int): PlaceholderFragment {
            return PlaceholderFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_SECTION_NUMBER, sectionNumber)
                }
            }
        }
    }
}