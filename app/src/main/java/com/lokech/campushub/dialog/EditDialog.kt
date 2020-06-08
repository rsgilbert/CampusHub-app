package com.lokech.campushub.dialog

import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.text.InputType
import android.view.LayoutInflater
import android.widget.EditText
import androidx.fragment.app.DialogFragment
import com.lokech.campushub.EDIT_DESCRIPTION
import com.lokech.campushub.EDIT_NAME
import com.lokech.campushub.EDIT_PRICE
import com.lokech.campushub.data.Item
import com.lokech.campushub.databinding.DialogEditBinding

class EditDialog : DialogFragment() {

    lateinit var listener: EditListener

    override fun onAttach(context: Context) {
        super.onAttach(context)
        try {
            listener = parentFragment as EditListener
        } catch (e: ClassCastException) {
            throw ClassCastException("$context must implement EditListener")
        }
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            val builder = AlertDialog.Builder(it)
            val binding = DialogEditBinding.inflate(LayoutInflater.from(context))

            binding.apply {
                arguments?.let { args ->
                    val item: Item = args.getParcelable("item")!!
                    val choice = args.getInt("choice")
                    when (choice) {
                        EDIT_PRICE -> {
                            dialogTitle.text = "Price"
                            editText.inputType = InputType.TYPE_CLASS_NUMBER
                            value = item.price.toString()
                        }
                        EDIT_DESCRIPTION -> {
                            dialogTitle.text = "Description"
                            value = item.description
                        }
                        EDIT_NAME -> {
                            dialogTitle.text = "Name"
                            value = item.name
                        }
                    }
                    btnSave.setOnClickListener {
                        updateThenDismiss(
                            editText,
                            choice
                        )
                    }
                }
            }

            builder.setView(binding.root)
            return builder.create()
        } ?: throw IllegalStateException("Activity can not be null")
    }
}

fun EditDialog.updateThenDismiss(editText: EditText, choice: Int) {
    val value = editText.text
    if (value.isNotBlank()) {
        listener.save(value.toString(), choice)
    }
    dismiss()
}

interface EditListener {
    fun save(value: String, choice: Int)
}