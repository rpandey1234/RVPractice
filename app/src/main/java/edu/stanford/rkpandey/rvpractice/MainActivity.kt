package edu.stanford.rkpandey.rvpractice

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

data class Person(val name: String, val age: Int)

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        
        // 6 STEPS OF IMPLEMENTING RecyclerView, from https://guides.codepath.com/android/using-the-recyclerview
        // 1. Add RecyclerView AndroidX library to the Gradle build file
        // 2. Define a model class to use as the data source
        // 3. Add a RecyclerView to your activity to display the items
        // 4. Create a custom row layout XML file to visualize the item
        // 5. Create a RecyclerView.Adapter and ViewHolder to render the item
        // 6. Bind the adapter to the data source to populate the RecyclerView
    }
    
    private fun createContacts(): List<Person> {
        val contacts = mutableListOf<Person>()
        for (i in 1..100) {
            contacts.add(Person("Person $i", i))    
        }
        return contacts
    }
}