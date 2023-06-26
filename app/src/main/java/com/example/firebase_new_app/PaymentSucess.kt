package com.example.firebase_new_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class PaymentSucess : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_payment_sucess)

        val buttonHome =findViewById<Button>(R.id.buttonHome)

        buttonHome.setOnClickListener {
            val intent = Intent(this, MountainView::class.java)
            startActivity(intent)
        }
    }
}

