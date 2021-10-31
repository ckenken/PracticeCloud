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

class EntryFragment : Fragment() {
    companion object {
        const val TAG = "EntryFragment"
    }

    lateinit var rootView: View
    private val inter by lazy { activity as CloudActivityInterface }
    private val entryButton by lazy { rootView.findViewById<Button>(R.id.entryButton) }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        rootView = inflater.inflate(R.layout.fragment_entry, container, false)
        entryButton.setOnClickListener {
            inter.forward(MainActivity.Page.Entry)
        }
        return rootView
    }
}