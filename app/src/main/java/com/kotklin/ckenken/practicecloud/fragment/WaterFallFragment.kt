package com.kotklin.ckenken.practicecloud.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.kotklin.ckenken.practicecloud.R

class WaterFallFragment : Fragment() {

    companion object {
        const val TAG = "WaterFallFragment"
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_listing, container, false)
    }
}