package com.titacolls.app.ui.komunitas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.titacolls.app.R

class KomunitasActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_komunitas)
    }
    companion object {
        const val OPEN_KOMUNITAS = "open_komunitas"
    }
}