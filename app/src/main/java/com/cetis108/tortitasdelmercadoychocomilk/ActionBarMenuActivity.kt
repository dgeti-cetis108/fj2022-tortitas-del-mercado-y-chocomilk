package com.cetis108.tortitasdelmercadoychocomilk

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast

class ActionBarMenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_action_bar_menu)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item!!.itemId) {
            R.id.MenuItemMainSaludar -> {
                // mostrar mensaje en pantalla
                Toast.makeText(this,"Saludos desde el menú",Toast.LENGTH_SHORT).show()
            }
            R.id.MenuItemMainIrA -> {
                // ir a otro activity y cerrar el actual
                val intent = Intent(this, MainActivity::class.java)
                this.startActivity(intent)
                this.finish()
            }
            R.id.MenuItemMainAcercaDe -> {
                // ir a otro activity pero dar la posibilidad de regresar <-
                val intent = Intent(this, TableLayoutCredentialActivity::class.java)
                this.startActivity(intent)
            }
        }
        return super.onOptionsItemSelected(item)
    }
}