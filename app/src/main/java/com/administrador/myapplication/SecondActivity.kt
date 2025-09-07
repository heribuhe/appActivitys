package com.administrador.myapplication

import android.os.Bundle
import android.widget.TextView // Importa la clase TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_second)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.bienvenidaVentana)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val datoRecibido = intent.getStringExtra("dato")

        val apellido = intent.getStringExtra("apellido")

        val fechaCumple = intent.getStringExtra("datoCumple")

        val datoEmail = intent.getStringExtra("Email")


        val textViewDatoRecibido = findViewById<TextView>(R.id.textViewDatoRecibido)
        textViewDatoRecibido.text = "datoRecibido: $datoRecibido"

        val datoapellido = findViewById<TextView>(R.id.datoapellido)
        datoapellido.text = "apellido: $apellido"

        val datoCumple = findViewById<TextView>(R.id.datoCumple)
        datoCumple.text = "fechaCumple: $fechaCumple"

        val email = findViewById<TextView>(R.id.email)
        email.text = "email: $datoEmail"




    }
}
