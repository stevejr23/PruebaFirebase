package com.sabirm.android2223_01

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_iva.*
import kotlinx.android.synthetic.main.activity_procesar.*

class iva : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_iva)

        val iva = 0.12

        btn_iva.setOnClickListener() {
            var total = et_iva.text.toString().toDouble()
            var result = total + (total+iva)
            tv_iva.setText("Total: $total  Total del iva: $result")
        }

    }
}