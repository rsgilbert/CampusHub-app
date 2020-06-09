package com.lokech.campushub.util

import android.content.Intent
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import com.lokech.campushub.PICK_PHOTO_REQUEST_CODE
import com.lokech.campushub.data.Item


val Fragment.supportActionBar: ActionBar?
    get() =
        (activity as AppCompatActivity).supportActionBar

fun Fragment.setSupportActionBar(toolbar: Toolbar) =
    (activity as AppCompatActivity).setSupportActionBar(toolbar)

//val Fragment.repository: Repository
//    get() = Repository(getDatabase(context!!).dao)
//

fun Map<String, Any>.asItem(): Item {
    return Item(
        id = get("id") as String,
        name = get("name") as String,
        price = get("price") as Long,
        description = get("description") as String,
        displayPicture = get("displayPicture") as String,
        pictures = get("pictures") as List<String>
    )
}

fun Fragment.startImagePicker() {
    val intent = Intent(Intent.ACTION_GET_CONTENT)
    intent.type = "image/*"
    startActivityForResult(intent, PICK_PHOTO_REQUEST_CODE)
}
