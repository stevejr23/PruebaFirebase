package com.sabirm.android2223_01

import android.content.Intent
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.app.ActivityCompat
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import kotlinx.android.synthetic.main.activity_procesar.*
import kotlinx.android.synthetic.main.activity_servicio_gps.*

class ServicioGPS : AppCompatActivity() {

    lateinit var fusedLocationProviderClient: FusedLocationProviderClient

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_servicio_gps)

        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this)

        btn_geo.setOnClickListener() {
            var msgLatLong = "Ubicacion"
            tv_gps.setText(msgLatLong)
            findLocation()
        }

        btn_home_gps.setOnClickListener() {
            var intentRegresar: Intent = Intent(this, MainActivity::class.java)
            startActivity(intentRegresar)
        }
    }

    fun findLocation() {
        val task = fusedLocationProviderClient.lastLocation
        if (ActivityCompat.checkSelfPermission(
                this,
                android.Manifest.permission.ACCESS_FINE_LOCATION
            )
            != PackageManager.PERMISSION_GRANTED
            && ActivityCompat.checkSelfPermission(
                this,
                android.Manifest.permission.ACCESS_COARSE_LOCATION
            ) !=
            PackageManager.PERMISSION_GRANTED
        ) {
            ActivityCompat.requestPermissions(
                this,
                arrayOf(android.Manifest.permission.ACCESS_FINE_LOCATION),
                101
            )
            return
        }

        task.addOnSuccessListener {
            if (it != null) {
                Toast.makeText(
                    applicationContext,
                    "${it.latitude} ${it.longitude}",
                    Toast.LENGTH_SHORT
                ).show()
                tv_gps.setText("${it.latitude} ${it.longitude} ${it.altitude}")
            }
        }
    }

}