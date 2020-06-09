package com.lokech.campushub.itemlist

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.lokech.campushub.data.Item
import timber.log.Timber

class ItemListViewModel : ViewModel() {
    val db = Firebase.firestore
    val itemListLiveData = MutableLiveData<List<Item>>()

    init {
        getItems()
    }
}

fun ItemListViewModel.getItems() {
    db.collection("items")
        .addSnapshotListener { value, e ->
            if (e != null) {
                Timber.e("Error listening: $e")
                return@addSnapshotListener
            }
            val items = ArrayList<Item>()
            for (doc in value!!) {
                try {
                    Timber.i("Data is ${doc.data.asItem()}")
                    items.add(doc.data.asItem())
                } catch (e: TypeCastException) {
                    Timber.e("incompatible data: ${doc.data}")
                }
            }
            itemListLiveData.value = items
        }
}

fun Map<String, Any>.asItem(): Item {
    return Item(
        id = get("id") as String,
        name = get("name") as String,
        price = get("price") as Long,
        description = get("description") as String,
        pictures = get("pictures") as List<String>
    )
}

