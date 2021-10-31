package com.kotklin.ckenken.practicecloud.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.kotklin.ckenken.practicecloud.R
import com.kotklin.ckenken.practicecloud.activity.CloudActivityInterface
import com.kotklin.ckenken.practicecloud.activity.MainActivity

class WaterFallFragment : Fragment() {

    companion object {
        const val TAG = "WaterFallFragment"
    }

    lateinit var rootView: View
    private val inter by lazy { activity as CloudActivityInterface }
    private val gogogo by lazy { rootView.findViewById<Button>(R.id.gogogo) }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        rootView = inflater.inflate(R.layout.fragment_listing, container, false)
        gogogo.setOnClickListener {
            inter.forward(MainActivity.Page.Listing)
        }
        return rootView
    }
}