package com.example.jetpackdata.bindingAdapter

import android.widget.EditText
import android.widget.TextView

class PersonBinding {

    // android:onClick="@{(vw)-> obj.doIt(frmNumber, text1) }"
    fun doIt(edit: EditText, vw: TextView) {
        val num = edit.text.toString().toInt()
        var total = 0
        for (n in 1..num) {
            total += n
        }
        vw.text = "Total: $total"
    }

     //
    fun doItSample(vw: TextView) {
        vw.text = "Total: 1000000"
    }
}