package com.sabirm.android2223_01

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_ventana_fecha.*
import java.util.*

class VentanaFecha : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ventana_fecha)

        hora()

        btnRegresar.setOnClickListener(){
            var saltar:Intent=Intent(this, MainActivity::class.java)
            startActivity(saltar)
        }
    }
    fun hora(){
        val c: Calendar = Calendar.getInstance()
        val dia:Int=c.get(Calendar.DAY_OF_WEEK)
        val mes:Int=c.get(Calendar.MONTH)
        val year:Int=c.get(Calendar.YEAR)
        val hora:Int=c.get(Calendar.HOUR)
        val minutos:Int=c.get(Calendar.MINUTE)
        textView3.setText("La hora actual es $year-$mes-$dia | $hora:$minutos ")
    }

}