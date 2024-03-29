package com.lokech.campushub.item

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.lokech.campushub.PICK_PHOTO_REQUEST_CODE
import com.lokech.campushub.PictureAdapter
import com.lokech.campushub.R
import com.lokech.campushub.databinding.FragmentItemPictureListBinding
import org.jetbrains.anko.support.v4.toast
import java.io.FileNotFoundException
import java.io.InputStream

class ItemPictureListFragment : Fragment() {
    val itemViewModel: ItemViewModel by viewModels({ requireParentFragment() }) {
        ItemViewModelFactory(itemId)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = DataBindingUtil.inflate<FragmentItemPictureListBinding>(
            inflater,
            R.layout.fragment_item_picture_list,
            container,
            false
        )

        binding.itemViewModel = itemViewModel
        binding.apply {
            lifecycleOwner = viewLifecycleOwner
            pictureList.adapter =
                PictureAdapter(pictureOnClickListener)
            fabNewPicture.setOnClickListener {
                startImagePicker()
            }
        }



        return binding.root
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == PICK_PHOTO_REQUEST_CODE && resultCode == Activity.RESULT_OK) {
            try {
                data?.let { intent ->
                    val inputStream: InputStream? =
                        context?.contentResolver?.openInputStream(intent.data!!)
                    inputStream?.let { stream ->
                        itemViewModel.savePicture(stream)
                    }
                }
            } catch (e: FileNotFoundException) {
                e.printStackTrace()
            }
        }
    }
}


fun ItemPictureListFragment.startImagePicker() {
    val intent = Intent(Intent.ACTION_GET_CONTENT)
    intent.type = "image/*"
    startActivityForResult(intent, PICK_PHOTO_REQUEST_CODE)
}

val ItemPictureListFragment.pictureOnClickListener: PictureAdapter.OnClickListener
    get() = PictureAdapter.OnClickListener {
        toast("Link is $it")
    }

val ItemPictureListFragment.itemId: String
    get() = ItemFragmentArgs.fromBundle(requireParentFragment().arguments!!).id
