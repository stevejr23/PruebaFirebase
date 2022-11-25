package com.sabirm.android2223_01

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_procesar.*

class procesar : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_procesar)

        val extras = intent.extras
        val nombres = extras?.getString("nombre") ?: "sin nombre"
        val edad = extras?.getInt("edad") ?: -1

        tv_nombre.setText(nombres + " Ud tiene: " + edad + " años")
        if (edad < 18) {
            var mensajeEdad = "Ud es menor de edad"
            tv_edad.setText(mensajeEdad)
        } else {
            var mensajeEdad = "Ud es mayor de edad"
            tv_edad.setText(mensajeEdad)
        }

        btn_home.setOnClickListener() {
            val saltar: Intent = Intent(this, MainActivity::class.java)
            startActivity(saltar)
        }
    }
}