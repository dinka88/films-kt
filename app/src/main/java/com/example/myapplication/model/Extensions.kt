package com.example.myapplication.model

import android.view.View
import com.google.android.material.snackbar.Snackbar


fun View.showSnackBar (
        text: Int,
        length: Int= Snackbar.LENGTH_INDEFINITE
) {
    val sBar=Snackbar.make(this,text,length)
    sBar.show()
}