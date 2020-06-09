package com.lokech.campushub.item

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.firestore.SetOptions
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.lokech.campushub.data.Item
import com.lokech.campushub.util.asItem
import com.lokech.campushub.util.uploadPicture
import timber.log.Timber
import java.io.InputStream

class ItemViewModel(val itemId: String) : ViewModel() {

    val itemLiveData = MutableLiveData<Item>()

    val db = Firebase.firestore

    init {
        setItem()
    }
}

fun ItemViewModel.saveName(name: String) {
    saveData(mapOf("name" to name))
}

fun ItemViewModel.savePrice(price: Long) {
    saveData(mapOf("price" to price))
}

fun ItemViewModel.saveDescription(description: String) {
    saveData(mapOf("description" to description))
}

fun ItemViewModel.saveDisplayPicture(stream: InputStream) {
    uploadPicture(stream) { pictureUrl ->
        Timber.i("Display Picture url is $pictureUrl")
        saveData(mapOf("displayPicture" to pictureUrl))
    }
}

fun ItemViewModel.savePicture(stream: InputStream) {
    uploadPicture(stream) { pictureUrl ->
        itemLiveData.value?.let {
            val data = mapOf("pictures" to it.pictures + pictureUrl)
            saveData(data)
        }
    }
}


fun ItemViewModel.setItem() {
    db.collection("items")
        .document(itemId)
        .addSnapshotListener { snapshot, e ->
            if (e != null) {
                Timber.e("Error listening: $e")
                return@addSnapshotListener
            }
            itemLiveData.value = snapshot?.data?.asItem()
            Timber.i("Set item ${snapshot?.data?.asItem()}")
        }
}

fun ItemViewModel.saveData(data: Map<String, Any>) {
    db.collection("items")
        .document(itemId)
        .set(data, SetOptions.merge())
}