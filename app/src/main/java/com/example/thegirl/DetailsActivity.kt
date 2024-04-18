  package com.example.thegirl

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

private const val TAG = "detailsActivity"

class DetailsActivity : AppCompatActivity() {

    @SuppressLint("MissingInflatedId", "SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)
        Log.i(TAG,"details acitivity 1")
        val contactName = intent.getStringExtra("contact_name")
        intent.getIntExtra("contact_age", 0)
        val contactBio= intent.getStringExtra("contact_bio")
        val profilephoto = intent.getIntExtra("contact_image",0)

        val nameTextView: TextView = findViewById(R.id.PlantText)
        val bioTextView: TextView = findViewById(R.id.IntroText)
        val personimageview: ImageView = findViewById(R.id.PlantImage)

        nameTextView.text = "$contactName"
        bioTextView.text = "Bio: $contactBio"
        personimageview.setImageResource(profilephoto)

        Log.i(TAG,"biodata details activity")
    }
}
