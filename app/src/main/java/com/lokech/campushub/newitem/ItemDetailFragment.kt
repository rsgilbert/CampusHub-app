package com.lokech.campushub.newitem

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.lokech.campushub.EDIT_DESCRIPTION
import com.lokech.campushub.EDIT_NAME
import com.lokech.campushub.EDIT_PRICE
import com.lokech.campushub.R
import com.lokech.campushub.databinding.FragmentDetailBinding
import com.lokech.campushub.dialog.EditDialog
import com.lokech.campushub.dialog.EditListener
import org.jetbrains.anko.support.v4.longToast

class ItemDetailFragment : Fragment(), EditListener {
    val newItemViewModel: NewItemViewModel by viewModels({ requireParentFragment() })

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentDetailBinding>(
            inflater,
            R.layout.fragment_detail,
            container,
            false
        )

        binding.newItemViewModel = newItemViewModel
        binding.apply {
            lifecycleOwner = viewLifecycleOwner
            nameSection.setOnClickListener { startEditDialog(EDIT_NAME) }
            priceSection.setOnClickListener { startEditDialog(EDIT_PRICE) }
            descriptionSection.setOnClickListener { startEditDialog(EDIT_DESCRIPTION) }
        }

        return binding.root
    }

    override fun save(value: String, choice: Int) {
        when (choice) {
            EDIT_NAME -> newItemViewModel.saveName(value)
            EDIT_PRICE -> {
                try {
                    newItemViewModel.savePrice(value.toLong())
                } catch (e: NumberFormatException) {
                    longToast("Wrong value")
                }
            }
            EDIT_DESCRIPTION -> newItemViewModel.saveDescription(value)
        }
    }
}

fun ItemDetailFragment.startEditDialog(choice: Int) {
    val dialog = EditDialog().apply {
        arguments = Bundle().apply {
            putParcelable("item", newItemViewModel.itemLiveData.value!!)
            putInt("choice", choice)
        }
    }
    dialog.show(childFragmentManager, "started edit dialog")
}
