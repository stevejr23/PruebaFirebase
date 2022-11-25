package com.sabirm.android2223_01

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.sabirm.android2223_01.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

//import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        Thread.sleep(3000)
        setTheme(R.style.Theme_Android2223_01)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btn_2 = findViewById<Button>(R.id.btn2)
        btn_2.setOnClickListener {
            val saltar: Intent = Intent(this, Ventana2::class.java)
            startActivity(saltar)
        }
        btn3.setOnClickListener {
            val saltar2: Intent = Intent(this, VentanaFecha::class.java)
            startActivity(saltar2)
        }

        btn1.setOnClickListener() {
            Toast.makeText(applicationContext, "Esto es un mensaje", Toast.LENGTH_SHORT).show()
        }
//        btn4.setOnClickListener {
//            var saltarGPS: Intent = Intent(this, ServicioGPS::class.java)
//            startActivity(saltarGPS)
//        }
        btn4.setOnClickListener() {
            var saltarBase: Intent = Intent(this, Auth_Ativity::class.java)
            startActivity(saltarBase)
        }
        btn5.setOnClickListener() {
            var saltaMascota: Intent = Intent(this, Mascota::class.java)
            startActivity(saltaMascota)
        }
    }
}

