package com.administrador.myapplication

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.EditText
import android.text.Editable
import android.text.TextWatcher

import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Bienvenida : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_bienvenida)

        val nombre = findViewById<EditText>(R.id.nombre2)
        val apellido = findViewById<EditText>(R.id.apellido2)
        val edad = findViewById<EditText>(R.id.edad2)
        val telefono = findViewById<EditText>(R.id.telefono)
        val ciudad = findViewById<EditText>(R.id.ciudad)



        val btnDatos = findViewById<Button>(R.id.btnDatos) // This is your button

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.Bienvenida)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        btnDatos.isEnabled = false

        val textWatcher = object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                btnDatos.isEnabled = nombre.text.isNotBlank() &&
                        nombre.text.isNotBlank() &&
                        apellido.text.isNotBlank() &&
                        edad.text.isNotBlank() &&
                        ciudad.text.isNotBlank() &&
                        telefono.text.isNotBlank()


            }
            override fun afterTextChanged(s: Editable?) {}
        }

        nombre.addTextChangedListener(textWatcher)
        apellido.addTextChangedListener(textWatcher)
        edad.addTextChangedListener(textWatcher)
        ciudad.addTextChangedListener(textWatcher)
        telefono.addTextChangedListener(textWatcher)

        btnDatos.setOnClickListener {
            val nombreValue = nombre.text.toString().trim() // Use a different variable name to avoid conflict
            val apellidoValue = apellido.text.toString().trim()
            val edadValue = edad.text.toString().trim()
            val ciudadValue = ciudad.text.toString().trim()
            val telefonoValue = telefono.text.toString().trim()

            val intent = Intent(this, Bienvenido::class.java).apply {

                putExtra("nombre", nombreValue)
                putExtra("apellido", apellidoValue)
                putExtra("edad", edadValue)
                putExtra("ciudad", ciudadValue)
                putExtra("telefono", telefonoValue)

            }
            startActivity(intent)
        }
    }
}