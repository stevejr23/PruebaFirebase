package com.sabirm.android2223_01

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_mascota.*

class Mascota : AppCompatActivity() {
    private val db = FirebaseFirestore.getInstance()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mascota)

        val bundle: Bundle? = intent.extras
        val email: String? = bundle?.getString("email")
        val provider: String? = bundle?.getString("provider")

        setup(email ?: "", provider ?: "")
    }

    private fun setup(email: String, provider: String) {
        title = "Inicio2"
        tv_correo.text = email
        tv_provider.text = provider

        btn_cerrar.setOnClickListener() {
            FirebaseAuth.getInstance().signOut()
            onBackPressed()
        }

        btn_enviar.setOnClickListener() {
            db.collection("Mascotas").document(email).set(
                hashMapOf(
                    "provider" to provider,
                    "nombrePET" to et_nomMascota.text.toString(),
                    "edadPET" to et_Edad.text.toString(),
                    "razaPET" to et_raza.text.toString(),
                    "numVacunasPET" to et_vacunas.text.toString(),
                    "fechaPET" to et_fechaVac.text.toString(),
                    "enfermedadesPET" to et_enfermedades.text.toString()
                )
            )
        }
    }
}