package com.kotklin.ckenken.practicecloud.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.kotklin.ckenken.practicecloud.R
import com.kotklin.ckenken.practicecloud.fragment.DetailFragment
import com.kotklin.ckenken.practicecloud.fragment.EntryFragment
import com.kotklin.ckenken.practicecloud.fragment.WaterFallFragment

class MainActivity : AppCompatActivity(), CloudActivityInterface {
    enum class Page {
        Entry, Listing, Detail
    }

    companion object {
        const val FRAGMENT_CONTAINER_ID = R.id.entryFragmentContainer
    }

    private val entryFragment
        get() = supportFragmentManager.findFragmentByTag(EntryFragment.TAG)
    private val waterFallFragment
        get() = supportFragmentManager.findFragmentByTag(WaterFallFragment.TAG)
    private val detailFragment
        get() = supportFragmentManager.findFragmentByTag(DetailFragment.TAG)

    override fun onBackPressed() {
        Log.d("ckenken", "MainActivity onBackPressed, DetailFragment.TAG = ${supportFragmentManager.findFragmentByTag(DetailFragment.TAG)}")
        Log.d("ckenken", "MainActivity onBackPressed, WaterFallFragment.TAG = ${supportFragmentManager.findFragmentByTag(WaterFallFragment.TAG)}")
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        when {
            supportFragmentManager.findFragmentByTag(DetailFragment.TAG) != null -> {
                fragmentTransaction.remove(detailFragment!!)
                    .show(waterFallFragment!!)
                    .commitAllowingStateLoss()
            }
            supportFragmentManager.findFragmentByTag(WaterFallFragment.TAG) != null -> {
                fragmentTransaction.remove(waterFallFragment!!)
                    .show(entryFragment!!)
                    .commitAllowingStateLoss()
            }
            else -> {
                super.onBackPressed()
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.add(R.id.entryFragmentContainer, EntryFragment(), EntryFragment.TAG)
        fragmentTransaction.commit()
    }

    override fun forward(currentPage: Page) {
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        when (currentPage) {
            Page.Entry -> {
                fragmentTransaction.hide(entryFragment!!)
                    .add(FRAGMENT_CONTAINER_ID, WaterFallFragment(), WaterFallFragment.TAG)
                    .commitAllowingStateLoss()
            }
            Page.Listing -> {
                fragmentTransaction.hide(waterFallFragment!!)
                    .add(FRAGMENT_CONTAINER_ID, DetailFragment(), DetailFragment.TAG)
                    .commitAllowingStateLoss()
            }
        }
    }
}

interface CloudActivityInterface {
    fun forward(currentPage : MainActivity.Page)
}