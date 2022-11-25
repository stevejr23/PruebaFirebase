package com.sabirm.android2223_01

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_mascota.*

class activity_mascota : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mascota)
    }

    class login : AppCompatActivity() {
        private val db = FirebaseFirestore.getInstance()
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_login)
            val bundle: Bundle? = intent.extras
            val email: String? = bundle?.getString("email")
            val provider: String? = bundle?.getString("provider")


            setup(email ?: "", provider ?: "")
        }

        private fun setup(email: String, provider: String) {
            title = "Inicio"
            btn_cerrar.setOnClickListener() {
                FirebaseAuth.getInstance().signOut()
                onBackPressed()
            }
            btn_enviar.setOnClickListener() {
                db.collection("mascotas").document(email).set(
                    hashMapOf(
                        "provider" to provider,
                        "nombre" to et_nomMascota.text.toString(),
                        "edad" to et_Edad.text.toString(),
                        //"raza" to et_rol.text.toString(),
                        "numVacunas" to et_vacunas.text.toString(),
                        "fecha" to et_fechaVac.text.toString(),
                        "enfermedades" to et_enfer.text.toString()
                    )
                )
            }
        }
    }
}