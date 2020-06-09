package com.lokech.campushub.newitem

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.lokech.campushub.*
import com.lokech.campushub.databinding.FragmentNewItemDetailBinding
import com.lokech.campushub.dialog.EditDialog
import com.lokech.campushub.dialog.EditListener
import com.lokech.campushub.util.startImagePicker
import org.jetbrains.anko.support.v4.longToast
import java.io.FileNotFoundException
import java.io.InputStream

class ItemDetailFragment : Fragment(), EditListener {
    val newItemViewModel: NewItemViewModel by viewModels({ requireParentFragment() })


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentNewItemDetailBinding>(
            inflater,
            R.layout.fragment_new_item_detail,
            container,
            false
        )

        binding.newItemViewModel = newItemViewModel
        binding.apply {
            lifecycleOwner = viewLifecycleOwner
            displayPicture.setOnClickListener { startImagePicker() }
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

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == PICK_PHOTO_REQUEST_CODE && resultCode == Activity.RESULT_OK) {
            try {
                data?.let { intent ->
                    val inputStream: InputStream? =
                        context?.contentResolver?.openInputStream(intent.data!!)
                    inputStream?.let { stream ->
                        newItemViewModel.saveDisplayPicture(stream)
                    }
                }
            } catch (e: FileNotFoundException) {
                e.printStackTrace()
            }
        }
    }
}

fun ItemDetailFragment.startEditDialog(choice: Int) {
    val dialog = EditDialog().apply {
        arguments = Bundle().apply {
            putParcelable("item", newItemViewModel.newItemLiveData.value!!)
            putInt("choice", choice)
        }
    }
    dialog.show(childFragmentManager, "started edit dialog")
}
