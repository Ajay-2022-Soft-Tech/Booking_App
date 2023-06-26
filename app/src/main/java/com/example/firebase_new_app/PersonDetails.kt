package com.example.firebase_new_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class PersonDetails : AppCompatActivity() {

    private lateinit var dataBase : DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_person_details)

        val buttonPay = findViewById<Button>(R.id.buttonPay)
        val buttonPToPayment = findViewById<Button>(R.id.buttonToPayment)
        val etName = findViewById<TextInputEditText>(R.id.etName)
        val etAddress = findViewById<TextInputEditText>(R.id.etAddress)
        val etMail = findViewById<TextInputEditText>(R.id.etMail)
        val etPassword = findViewById<TextInputEditText>(R.id.etPassword)

        buttonPay.setOnClickListener {
            val name = etName.text.toString()
            val address = etAddress.text.toString()
            val mail = etMail.text.toString()
            val password = etPassword.text.toString()

            val user = User(name,mail,address,password)

            dataBase = FirebaseDatabase.getInstance().getReference("Users")

            dataBase.child(password).setValue(user).addOnSuccessListener {
                etName.text?.clear()
                etAddress.text?.clear()
                etMail.text?.clear()
                etPassword.text?.clear()


                Toast.makeText(this, "User Registered", Toast.LENGTH_SHORT).show()
            }


        }


        buttonPToPayment.setOnClickListener {
            val intent = Intent(this, PaymentSection::class.java)
            startActivity(intent)
        }

    }
}