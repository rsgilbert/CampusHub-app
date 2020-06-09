package com.lokech.campushub.itemlist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.lokech.campushub.R
import com.lokech.campushub.databinding.ItemlistFragmentBinding
import org.jetbrains.anko.support.v4.longToast

class ItemListFragment : Fragment() {

    val itemListViewModel: ItemListViewModel = ItemListViewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = DataBindingUtil.inflate<ItemlistFragmentBinding>(
            inflater,
            R.layout.itemlist_fragment,
            container,
            false
        )

        binding.itemListViewModel = itemListViewModel
        binding.apply {
            lifecycleOwner = viewLifecycleOwner
            itemList.adapter = ItemListAdapter(onClickListener)
            fabNewItem.setOnClickListener {
                val action = ItemListFragmentDirections.actionItemsFragmentToNewItemFragment()
                findNavController().navigate(action)
            }
        }

        return binding.root
    }
}

val ItemListFragment.onClickListener: ItemListAdapter.OnClickListener
    get() = ItemListAdapter.OnClickListener {
        longToast("Item is $it")
    }