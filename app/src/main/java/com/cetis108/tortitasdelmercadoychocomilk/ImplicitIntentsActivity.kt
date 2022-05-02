package com.cetis108.tortitasdelmercadoychocomilk

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageButton

class ImplicitIntentsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_implicit_intents)

        val buttonWeb = findViewById<ImageButton>(R.id.imageButtonWeb)
        buttonWeb.setOnClickListener {
            val direccion = findViewById<EditText>(R.id.editTextWeb).text
            val intentWeb = Intent()
            intentWeb.action = Intent.ACTION_VIEW
            intentWeb.data = Uri.parse("https://$direccion")
            startActivity(intentWeb)
        }
    }
}