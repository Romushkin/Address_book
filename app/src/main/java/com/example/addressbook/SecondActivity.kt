package com.example.addressbook

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SecondActivity : AppCompatActivity() {
    private var person: Person? = null

    private lateinit var nameTV: TextView
    private lateinit var surnameTV: TextView
    private lateinit var addressTV: TextView
    private lateinit var phoneTV: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_second)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        nameTV = findViewById(R.id.nameTV)
        surnameTV = findViewById(R.id.surnameTV)
        addressTV = findViewById(R.id.addressTV)
        phoneTV = findViewById(R.id.phoneTV)

        person = intent.extras?.getParcelable(Person::class.java.simpleName) as Person?
        nameTV.text = person?.name.toString()
        surnameTV.text = person?.surname.toString()
        addressTV.text = person?.address.toString()
        phoneTV.text = person?.phone.toString()
    }
}