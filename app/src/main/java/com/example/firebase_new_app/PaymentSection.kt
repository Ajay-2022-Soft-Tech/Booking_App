package com.example.firebase_new_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class PaymentSection : AppCompatActivity() {

    private lateinit var dataBase : DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_payment_section)

        val paymentSuccess = findViewById<Button>(R.id.buttonSuccess)
        val buttonToReceipt =findViewById<Button>(R.id.buttonToReceipt)
        val etBankName = findViewById<TextInputEditText>(R.id.etBankName)
        val etAccountNo =findViewById<TextInputEditText>(R.id.etAccountNo)
        val etIFSC = findViewById<TextInputEditText>(R.id.etIFSC)
        val etEmail = findViewById<TextInputEditText>(R.id.etEmail)

        paymentSuccess.setOnClickListener {


            val bankName =etBankName.text.toString()
            val accountNo =etAccountNo.text.toString()
            val ifsc = etIFSC.text.toString()
            val email = etEmail.text.toString()

            val user = Users1(bankName,accountNo,ifsc,email)
            dataBase = FirebaseDatabase.getInstance().getReference("Users")

            dataBase.child(accountNo).setValue(user).addOnSuccessListener {
                etBankName.text?.clear()
                etAccountNo.text?.clear()
                etIFSC.text?.clear()
                etEmail.text?.clear()
                Toast.makeText(this, "Payment Successful", Toast.LENGTH_SHORT).show()

            }

        }

        buttonToReceipt.setOnClickListener{
            val intent = Intent(this, PaymentSucess::class.java)
            startActivity(intent)
        }
    }
}