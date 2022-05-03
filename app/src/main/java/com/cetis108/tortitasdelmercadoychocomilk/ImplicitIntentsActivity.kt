package com.cetis108.tortitasdelmercadoychocomilk

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast

class ImplicitIntentsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_implicit_intents)

        addActionToButtonWeb()
    }

    private fun addActionToButtonWeb() {
        val buttonWeb = findViewById<ImageButton>(R.id.imageButtonWeb)
        buttonWeb.setOnClickListener {
            // validar si la caja de texto web esta vacía
            val direccion = findViewById<EditText>(R.id.editTextWeb).text
            // si esta vacía enviar mensaje que escriba algo
            if (direccion.isEmpty()) {
                Toast.makeText(this,"Escribe algo",Toast.LENGTH_SHORT).show()
            } else {
                // sino esta vacía continuar con el llamado al intent
                val intentWeb = Intent()
                intentWeb.action = Intent.ACTION_VIEW
                intentWeb.data = Uri.parse("https://$direccion")
                startActivity(intentWeb)
            }
        }
    }

}