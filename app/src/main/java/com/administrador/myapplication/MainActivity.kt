package com.administrador.myapplication


import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat



class MainActivity : AppCompatActivity() {
    private val TAG =  "Cycle app";

    lateinit var boton: Button;

    lateinit var bienvenida: Button;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.bienvenidaVentana)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        boton = findViewById<Button>(R.id.boton)

        boton.setOnClickListener {
            var intent: Intent = Intent(this, MainActivity2::class.java)
            startActivity(intent)
        }

        bienvenida = findViewById<Button>(R.id.bienvenida)

        bienvenida.setOnClickListener {
            var intent: Intent = Intent(this, Bienvenida::class.java)
            startActivity(intent)
        }





    }


    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onPause Called");

    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onPause Called");

    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause Called");

    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onPause Called");

    }

    override fun onRestart() {
        super.onRestart()
        Log.d(TAG, "on Called");

    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy Called");


    }
}