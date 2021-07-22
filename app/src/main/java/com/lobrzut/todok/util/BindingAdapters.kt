package com.lobrzut.todok.util

import android.graphics.Color
import android.widget.TextView
import androidx.databinding.BindingAdapter
import java.text.DateFormat


@BindingAdapter("setCategory")
fun setCategory(view: TextView, category: Int){
    when(category){
        0 -> {
            view.text = "Work"
            view.setTextColor(Color.RED)
        }
        1 -> {
            view.text = "Shopping"
            view.setTextColor(Color.GREEN)
        }
        else -> {
            view.text = "Others"
            view.setTextColor(Color.BLUE)
        }
    }
}
@BindingAdapter("setTimestamp")
fun setTimestamp(view: TextView, timestamp: Long){
    view.text = DateFormat.getInstance().format(timestamp)
}