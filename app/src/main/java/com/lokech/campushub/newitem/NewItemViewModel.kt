package com.lokech.campushub.newitem

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.StorageReference
import com.google.firebase.storage.ktx.storage
import com.lokech.campushub.data.Item
import timber.log.Timber
import java.io.InputStream
import java.util.*

class NewItemViewModel : ViewModel() {

    val itemLiveData = MutableLiveData<Item>().apply { value = Item() }


}

fun NewItemViewModel.saveName(name: String) {
    itemLiveData.value = itemLiveData.value?.copy(name = name)
}

fun NewItemViewModel.savePrice(price: Long) {
    itemLiveData.value = itemLiveData.value?.copy(price = price)
}

fun NewItemViewModel.saveDescription(description: String) {
    itemLiveData.value = itemLiveData.value?.copy(description = description)
}

fun NewItemViewModel.uploadPicture(stream: InputStream) {
    val storage = Firebase.storage
    val name = Date().time.toString()
    val uploadRef: StorageReference = storage.reference.child("images").child(name)
    uploadRef.putStream(stream)
        .addOnProgressListener {
            Timber.i("Made progress: ${it.bytesTransferred}")
        }
        .continueWithTask { task ->
            if (!task.isSuccessful) {
                task.exception?.let { throw it }
            }
            uploadRef.downloadUrl
        }
        .addOnCompleteListener { task ->
            if (task.isSuccessful) {
                val picture = task.result.toString()
                itemLiveData.value = itemLiveData.value?.let {
                    it.copy(pictures = it.pictures + picture)
                }
                Timber.i("Pictures are ${itemLiveData.value?.pictures}")
            }
        }
}

