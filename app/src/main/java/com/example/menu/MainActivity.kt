package com.example.menudemo

import android.os.Bundle
import android.view.ContextMenu
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.PopupMenu
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.menu.R

class MainActivity : AppCompatActivity() {

    private lateinit var btnOptionsMenu: Button
    private lateinit var btnContextMenu: Button
    private lateinit var btnPopupMenu: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnOptionsMenu = findViewById(R.id.btnOptionsMenu)
        btnContextMenu = findViewById(R.id.btnContextMenu)
        btnPopupMenu = findViewById(R.id.btnPopupMenu)

        // Registrar los botones para el menú contextual
        registerForContextMenu(btnContextMenu)

        // Configurar clics de los botones
        btnOptionsMenu.setOnClickListener {
            openOptionsMenu()
        }

        btnPopupMenu.setOnClickListener { v ->
            showPopupMenu(v)
        }

        // Configurar clics de los botones para el menú de opciones
        btnOptionsMenu.setOnClickListener {
            openOptionsMenu()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_settings -> {
                Toast.makeText(this, "Configuración clickeada", Toast.LENGTH_SHORT).show()
                true
            }
            R.id.action_about -> {
                Toast.makeText(this, "Acerca de clickeado", Toast.LENGTH_SHORT).show()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onCreateContextMenu(menu: ContextMenu, v: View, menuInfo: ContextMenu.ContextMenuInfo?) {
        super.onCreateContextMenu(menu, v, menuInfo)
        menuInflater.inflate(R.menu.menu_context, menu)
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_settings -> {
                Toast.makeText(this, "Configuracion clickeado", Toast.LENGTH_SHORT).show()
                true
            }
            R.id.action_about -> {
                Toast.makeText(this, "Acerca de clickeado", Toast.LENGTH_SHORT).show()
                true
            }
            else -> super.onContextItemSelected(item)
        }
    }

    private fun showPopupMenu(view: View) {
        val popupMenu = PopupMenu(this, view)
        popupMenu.inflate(R.menu.menu_popup)
        popupMenu.setOnMenuItemClickListener { item ->
            when (item.itemId) {
                R.id.action_share -> {
                    Toast.makeText(this@MainActivity, "Compartir clickeado", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.action_copy -> {
                    Toast.makeText(this@MainActivity, "Copiar clickeado", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.action_delete -> {
                    Toast.makeText(this@MainActivity, "Eliminar clickeado", Toast.LENGTH_SHORT).show()
                    true
                }
                else -> false
            }
        }
        popupMenu.show()
    }
}
