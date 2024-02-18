package com.example.thegirl

import android.annotation.SuppressLint
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


    }

    //Get the number of items in the data set
    override fun getItemCount(): Int {
        return contacts.size
    }

    //Defining data for each view inside the item layout
    inner class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        val tvName: TextView = itemView.findViewById(R.id.itemTextView)


    }

}


