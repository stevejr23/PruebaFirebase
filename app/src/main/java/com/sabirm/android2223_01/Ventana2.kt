package com.sabirm.android2223_01

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_ventana2.*

class Ventana2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ventana2)

        val btn_2=findViewById<Button>(R.id.btn1V2)


        btn_2.setOnClickListener{
            try {
                //recolectar variables del formulario
                var nombre:String=et_nombres.text.toString()
                var Edad:String=et_edad.text.toString()
                var edad=Integer.parseInt(Edad) //convirtiendo a entero Edad

                val saltar:Intent=Intent(this, procesar::class.java)
                //envío de variables
                saltar.putExtra("nombre",nombre)
                saltar.putExtra("edad",edad)
                startActivity(saltar)
            } catch (e: NumberFormatException) {
                var nombre="Sin nombre"
                var edad = 0
                Toast.makeText(applicationContext, "LLene el formulario por completo",
                    Toast.LENGTH_SHORT).show()
            }
        }
    }
}