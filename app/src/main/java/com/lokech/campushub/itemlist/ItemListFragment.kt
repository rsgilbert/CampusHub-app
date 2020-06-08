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

class ItemListFragment : Fragment() {

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

        binding.apply {
            fabNewItem.setOnClickListener {
                val action = ItemListFragmentDirections.actionItemsFragmentToNewItemFragment()
                findNavController().navigate(action)
            }
        }

//        // Access a Cloud Firestore instance from your Activity
//        val db = Firebase.firestore
//
//        val user = hashMapOf(
//            "one" to "Ada",
//            "two" to "Mugisha",
//            "died" to 2080
//        )
//        db.collection("users")
//            .add(user)
//            .addOnSuccessListener { documentReference ->
//                toast("Reference is $documentReference")
//            }
//            .addOnFailureListener { e ->
//                toast("ERROR: $e")
//                Timber.e("Error adding document: $e")
//            }
//
//        // Create a new user with a first, middle, and last name
//        val user2 = hashMapOf(
//            "first" to "Alan",
//            "middle" to "Mathison",
//            "last" to "Turing",
//            "born" to 1912
//        )
//
//// Add a new document with a generated ID
//        db.collection("users")
//            .add(user2)
//            .addOnSuccessListener { documentReference ->
//                Timber.i("DocumentSnapshot added with ID: ${documentReference.id}")
//                toast("Reference id is ${documentReference.id}")
//            }
//            .addOnFailureListener { e ->
//                toast("ERROR: $e")
//                Timber.e("Error adding document: $e")
//
//            }
//
//        db.collection("users")
//            .get()
//            .addOnSuccessListener { result ->
//                for (doc in result) {
//                    Timber.i("Doc is $doc")
//                    longToast("Doc got: $doc")
//                }
//            }
//            .addOnFailureListener { e ->
//                toast("ERROR fetching docs: $e")
//                Timber.e("Error getting docs : $e")
//            }

//        val storage = Firebase.storage
//        val storageRef = storage.reference
//        var imageRef: StorageReference? = storageRef.child("images")
//        val shoeRef = storageRef.child("images/shoe.jpg")


        return binding.root
    }
}