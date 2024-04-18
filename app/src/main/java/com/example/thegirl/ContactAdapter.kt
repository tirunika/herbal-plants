package com.example.thegirl

import android.annotation.SuppressLint
import android.content.ContentValues.TAG
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ContactAdapter(private val contacts: MutableList<Person>):
    RecyclerView.Adapter<ContactAdapter.ViewHolder>() {
    //Creating new views
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout,parent,false)
        return ViewHolder(view)
    }

    //Binding data to the views
    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ContactAdapter.ViewHolder, position: Int) {
        val contact = contacts[position]
        holder.tvName.text=contact.name
        holder.itemView.setOnClickListener {
            // Create an explicit intent to start DetailsActivity
            val intent = Intent(context, DetailsActivity::class.java).apply {
                putExtra("contact_name", contact.name)
                putExtra("contact_bio", contact.intro)
                putExtra("contact_image", contact.imageId)
                Log.i(TAG,"biodata in constacts adapter")
                Log.i(TAG,"intent onbindviewholder $position")
            }
            context.startActivity(intent)


        }


    }

    //Get the number of items in the data set
    override fun getItemCount(): Int {
        return contacts.size
    }

    //Defining data for each view inside the item layout
    inner class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        val tvName: TextView = itemView.findViewById(R.id.PlantText)


    }

}


