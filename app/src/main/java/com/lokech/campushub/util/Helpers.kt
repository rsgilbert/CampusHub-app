package com.lokech.campushub.util

import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.StorageReference
import com.google.firebase.storage.ktx.storage
import timber.log.Timber
import java.io.InputStream
import java.util.*


fun uploadPicture(
    stream: InputStream,
    onUpload: (pictureUrl: String) -> Unit
) {
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
                onUpload(task.result.toString())
            }
        }
}
