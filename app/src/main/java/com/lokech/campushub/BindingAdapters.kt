package com.lokech.campushub

import android.view.View
import android.widget.ImageView
import androidx.core.content.ContextCompat
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.lokech.campushub.data.Item
import com.lokech.campushub.itemlist.ItemListAdapter
import de.hdodenhof.circleimageview.CircleImageView


@BindingAdapter("imageUrl")
fun CircleImageView.bindImage(imgUrl: String?) {
    imgUrl?.let {
        val imgUri = imgUrl.toUri().buildUpon().scheme("https").build()
//        val imgUri = imgUrl.toUri().buildUpon().build()
        Glide.with(context)
            .load(imgUri)
            .apply(
                RequestOptions()
                    .placeholder(R.drawable.loading_animation)
                    .error(R.drawable.ic_broken_image)
            )
            .into(this)
    }
}

@BindingAdapter("imageUrl")
fun ImageView.bindImage(imgUrl: String?) {
    imgUrl?.let {
        val imgUri = imgUrl.toUri().buildUpon().scheme("https").build()
//        val imgUri = imgUrl.toUri().buildUpon().build()
        Glide.with(context)
            .load(imgUri)
            .apply(
                RequestOptions()
                    .placeholder(R.drawable.loading_animation)
                    .error(R.drawable.ic_broken_image)
            )
            .into(this)
    }
}
@BindingAdapter("addClickAnimation")
fun View.addClickAnimation(shouldAdd: Boolean?) =
    shouldAdd?.let {
        val attrs = intArrayOf(R.attr.selectableItemBackground)
        val typedArray = context.obtainStyledAttributes(attrs)
        val backgroundResource = typedArray.getResourceId(0, 0)
        setBackgroundResource(backgroundResource)
        typedArray.recycle()
    }


@BindingAdapter("addDivider")
fun RecyclerView.addDivider(shouldAdd: Boolean?) =
    shouldAdd?.let {
        if (it) {
            val itemDec = DividerItemDecoration(context, DividerItemDecoration.VERTICAL)
            itemDec.setDrawable(ContextCompat.getDrawable(context, R.drawable.divider)!!)
            addItemDecoration(itemDec)
        }
    }

@BindingAdapter("item")
fun RecyclerView.bindItem(item: Item?) {
    item?.let {
        (adapter as PictureAdapter).submitList(item.pictures)
    }
}

@BindingAdapter("itemList")
fun RecyclerView.bindItem(itemList: List<Item>?) {
    itemList?.let {
        (adapter as ItemListAdapter).submitList(itemList)
    }
}
