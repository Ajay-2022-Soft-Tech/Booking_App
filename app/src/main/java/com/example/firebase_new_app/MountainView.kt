package com.example.firebase_new_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.cardview.widget.CardView

class MountainView : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mountain_view)

        val cardView1 = findViewById<CardView>(R.id.cardView1)
        val cardView2 = findViewById<CardView>(R.id.cardView2)
        val cardView3 = findViewById<CardView>(R.id.cardView3)
        val cardView4 = findViewById<CardView>(R.id.cardView4)

        cardView1.setOnClickListener{
            val intent = Intent(this, PlaceDetails::class.java)
            startActivity(intent)
        }
        cardView2.setOnClickListener{
            val intent = Intent(this, PlaceDetails2::class.java)
            startActivity(intent)
        }
        cardView3.setOnClickListener{
            val intent = Intent(this, PlaceDetails3::class.java)
            startActivity(intent)
        }
        cardView4.setOnClickListener{
            val intent = Intent(this, PlaceDetails4::class.java)
            startActivity(intent)
        }

    }
}