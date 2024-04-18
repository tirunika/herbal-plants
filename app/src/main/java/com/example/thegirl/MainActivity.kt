package com.example.thegirl

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

data class Person(val name:String ,val intro:String ,val imageId:Int)//Define a data class to store the data in the application
//We can call this class anywhere in the code because we have defined it out side the main class
class MainActivity : AppCompatActivity() {
    private lateinit var contacts: MutableList<Person>
    private lateinit var adapter: ContactAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // Defined data required for the application
        contacts = createContacts()
        //Define an adapter that will connect the data with dynamic screen
        adapter = ContactAdapter(contacts)
        val recyclerView: RecyclerView =findViewById(R.id.items)
        recyclerView.adapter=adapter
        recyclerView.layoutManager=LinearLayoutManager(this)
    }

    private fun createContacts(): MutableList<Person> {
        //Define each of the item as a variable
        val contacts = mutableListOf<Person>()
        val bioDataArray = resources.getStringArray(R.array.bio_data_array)
        for (i in 1..10) {
            val biodata = bioDataArray.getOrNull( i-1)?:""
            val specificimagename = "person$i"
            val imageresid = resources.getIdentifier(specificimagename,"drawable",packageName)
            contacts.add(Person("Plant $i",biodata,imageresid))//has all the information regarding app
        }
        return contacts

    }
}