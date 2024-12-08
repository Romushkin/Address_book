package com.example.addressbook

import android.content.Intent
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private val personList: MutableList<Person> = mutableListOf()
    private lateinit var adapter: ArrayAdapter<String>

    private lateinit var nameET: EditText
    private lateinit var surnameET: EditText
    private lateinit var addressET: EditText
    private lateinit var phoneET: EditText
    private lateinit var saveBTN: Button
    private lateinit var userListLV: ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        nameET = findViewById(R.id.nameET)
        surnameET = findViewById(R.id.surnameET)
        addressET = findViewById(R.id.addressET)
        phoneET = findViewById(R.id.phoneET)
        saveBTN = findViewById(R.id.saveBTN)

        userListLV = findViewById(R.id.userListLV)
        adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, mutableListOf())
        userListLV.adapter = adapter

        saveBTN.setOnClickListener {
            if (nameET.text.isEmpty() || surnameET.text.isEmpty()) return@setOnClickListener
            val name = nameET.text.toString()
            val surname = surnameET.text.toString()
            val address = addressET.text.toString()
            val phone = phoneET.text.toString()
            val person = Person(name, surname,address,phone)
            personList.add(person)
            adapter.add("$name $surname")
            adapter.notifyDataSetChanged()
            nameET.text.clear()
            surnameET.text.clear()
            addressET.text.clear()
            phoneET.text.clear()
        }
        userListLV.setOnItemClickListener { parent, view, position, id ->
                val person = personList[position]
                val intent = Intent(this, SecondActivity::class.java)
                intent.putExtra(Person::class.java.simpleName, person)
                startActivity(intent)
            }
    }
}