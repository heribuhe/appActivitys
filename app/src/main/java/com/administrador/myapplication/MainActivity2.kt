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

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main2)

        val btnEnviar = findViewById<Button>(R.id.btnEnviar)
        val editTextDato = findViewById<EditText>(R.id.editTextDato)
        val apellido = findViewById<EditText>(R.id.apellido)
        val fecha = findViewById<EditText>(R.id.fecha)
        val email = findViewById<EditText>(R.id.email)



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.bienvenidaVentana)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        btnEnviar.isEnabled = false

        editTextDato.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                btnEnviar.isEnabled = !s.isNullOrEmpty()
            }
           override fun afterTextChanged(s: Editable?) {}
        })

        apellido.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                btnEnviar.isEnabled = !s.isNullOrEmpty()
                }
            override fun afterTextChanged(s: Editable?) {}
        })

        fecha.addTextChangedListener(object : TextWatcher {

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                btnEnviar.isEnabled = !s.isNullOrEmpty()
            }
            override fun afterTextChanged(s: Editable?) {}

        })


        btnEnviar.setOnClickListener {
            val dato = editTextDato.text.toString().trim()
            val apellido = apellido.text.toString().trim()
            val fecha = fecha.text.toString().trim()
            val email = email.text.toString().trim()



                
            val intent = Intent(this, SecondActivity::class.java).apply {
                putExtra("dato", dato)
                putExtra("apellido", apellido)
                putExtra("datoCumple", fecha)
                putExtra("datoEmail", email)
            }
            startActivity(intent)
        }
    }
}