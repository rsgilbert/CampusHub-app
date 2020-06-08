package com.lokech.campushub.newitem


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.google.android.material.tabs.TabLayoutMediator
import com.lokech.campushub.R
import com.lokech.campushub.databinding.ViewPagerBinding

class NewItemFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<ViewPagerBinding>(
            inflater, R.layout.view_pager, container, false
        )

        binding.pager.adapter = NewItemViewPagerAdapter(this)
        binding.pager.isUserInputEnabled = false

        TabLayoutMediator(binding.tabLayout, binding.pager, tabConfiguration).attach()

        return binding.root

    }
}

private val NewItemFragment.tabConfiguration: TabLayoutMediator.TabConfigurationStrategy
    get() = TabLayoutMediator.TabConfigurationStrategy { tab, position ->
        when (position) {
            0 -> tab.text = getString(R.string.tab_item_picture_list_text)
            else -> tab.text = getString(R.string.tab_item_detail_text)
        }
    }
