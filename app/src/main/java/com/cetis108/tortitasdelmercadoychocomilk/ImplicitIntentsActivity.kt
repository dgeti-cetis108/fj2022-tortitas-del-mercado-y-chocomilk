package com.cetis108.tortitasdelmercadoychocomilk

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast

class ImplicitIntentsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_implicit_intents)

        addActionToButtonWeb()
        addActionToButtonPhone()
        addActionToButtonCamera()
        addActiontoButtonEmail()
        addActionToButtonSms()
    }

    private fun addActionToButtonSms() {
        // obtener el enlace al botonSms
        val buttonSms = findViewById<Button>(R.id.buttonImplicitIntentSms)
        // agregar la acción al botonSms
        buttonSms.setOnClickListener {
            // definir el número telefónico a donde enviar el SMS
            val number = "+526871234567"
            // definir el mensaje a enviar
            val message = "Hello, this is a Message from Android"
            // crear el intent para enviar mensaje
            val intentSms = Intent().apply {
                action = Intent.ACTION_SENDTO
                data = Uri.parse("smsto:$number")
                putExtra("sms_body", message)
            }
            // llamar al intent
            startActivity(intentSms)
        }
    }

    private fun addActiontoButtonEmail() {
        // obtener el enlace al botonEmail
        val buttonEmail = findViewById<Button>(R.id.buttonImplicitIntentEmail)
        // agregar la acción al botonEmail
        buttonEmail.setOnClickListener {
            val from = Uri.parse("bidkar@cetis108.edu.mx")
            val to = Uri.parse("grupo.6avpr@cetis108.edu.mx")
            val subject = "Mensaje enviado desde Android"
            val message = "hola, te escribo para demostrar que se puede hacer desde mi app"
            val intentEmail = Intent(Intent.ACTION_SEND, from)
            intentEmail.putExtra(Intent.EXTRA_SUBJECT, subject)
            intentEmail.putExtra(Intent.EXTRA_TEXT, message)
            intentEmail.putExtra(Intent.EXTRA_EMAIL, to)
            intentEmail.type = "text/plain"
            startActivity(Intent.createChooser(intentEmail, "Enviar correo con:"))
        }
    }

    private fun addActionToButtonCamera() {
        // obtener el enlace al buttonCamera
        val buttonCamera = findViewById<ImageButton>(R.id.imageButtonCamera)
        // asignar la accion para el buttonCamera
        buttonCamera.setOnClickListener {
            // definir el intent para llamar a la camara
            val intentCamera = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            // ejecutar el intent
            startActivity(intentCamera)
        }
    }

    private fun addActionToButtonPhone() {
        // obtener el enlace al botonPhone
        val buttonPhone = findViewById<ImageButton>(R.id.imageButtonPhone)
        // asignar la accion para el buttonPhone
        buttonPhone.setOnClickListener {
            // obtener el valor de la caja de texto del número telefónico
            val phone = findViewById<EditText>(R.id.editTextPhone).text
            // validar la existencia del número telefónico
            if (phone.isEmpty()) {
                Toast.makeText(
                    this,
                    "Debes ingresar el ☎️",
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                // definir el intent para marcar al teléfono tel:6871234567
                val intentPhone = Intent(Intent.ACTION_DIAL,Uri.parse("tel:$phone"))
                // ejecutar el intent
                startActivity(intentPhone)
            }
        }
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