package com.flybook.flybook.core.binding

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

/*
*created by thomas on 2020-06-02
*/
@BindingAdapter("bind_image")
fun bindImage(view: ImageView, res: Int?) {
    Glide.with(view.context).load(res).into(view)
}