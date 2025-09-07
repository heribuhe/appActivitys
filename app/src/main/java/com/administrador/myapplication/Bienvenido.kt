package com.administrador.myapplication

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Bienvenido : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_bienvenido)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val nombre = intent.getStringExtra("nombre")
        val apellido = intent.getStringExtra("apellido")
        val edad = intent.getStringExtra("edad")
        val ciudad = intent.getStringExtra("ciudad")
        val telefono = intent.getStringExtra("telefono")

        val saludo = findViewById<TextView>(R.id.saludo)
        saludo.text = "Bienvenido $nombre $apellido"

        val presentacion = findViewById<TextView>(R.id.presentacion)
        presentacion.text = "Hola amigo $nombre como ha estado en clima en $ciudad?"

    }
}