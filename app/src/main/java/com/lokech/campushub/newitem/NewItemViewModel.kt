package com.lokech.campushub.newitem

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.firestore.SetOptions
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.lokech.campushub.data.Item
import com.lokech.campushub.util.uploadPicture
import timber.log.Timber
import java.io.InputStream

class NewItemViewModel : ViewModel() {

    val newItemLiveData = MutableLiveData<Item>().apply {
        value = Item()
    }

    val db = Firebase.firestore

    init {
        newItemLiveData.observeForever {
            saveItem(it)
        }
    }
}

fun NewItemViewModel.saveName(name: String) {
    newItemLiveData.value = newItemLiveData.value?.copy(name = name)
}

fun NewItemViewModel.savePrice(price: Long) {
    newItemLiveData.value = newItemLiveData.value?.copy(price = price)
}

fun NewItemViewModel.saveDescription(description: String) {
    newItemLiveData.value = newItemLiveData.value?.copy(description = description)
}

fun NewItemViewModel.saveDisplayPicture(stream: InputStream) {
    uploadPicture(stream) { pictureUrl ->
        newItemLiveData.value = newItemLiveData.value?.copy(displayPicture = pictureUrl)
    }
}

fun NewItemViewModel.savePicture(stream: InputStream) {
    uploadPicture(stream) { pictureUrl ->
        newItemLiveData.value = newItemLiveData.value?.let {
            it.copy(pictures = it.pictures + pictureUrl)
        }
    }
}

fun NewItemViewModel.saveItem(item: Item) {
    db.collection("items").document(item.id)
        .set(item, SetOptions.merge())
        .addOnSuccessListener {
            Timber.i("saved item $item")
        }
        .addOnFailureListener { e ->
            Timber.e("Error creating item $e")
        }
}



