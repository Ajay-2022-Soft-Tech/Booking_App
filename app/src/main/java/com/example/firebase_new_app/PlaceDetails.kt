package com.example.firebase_new_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class PlaceDetails : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_place_details)

        val placeDetails = findViewById<Button>(R.id.buttonPlace)

        placeDetails.setOnClickListener {
            val intent = Intent(this, PersonDetails::class.java)
            startActivity(intent)

        }
    }
}