package edu.stanford.rkpandey.rvpractice

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import java.io.Serializable

data class Person(val name: String, val age: Int) : Serializable

class MainActivity : AppCompatActivity() {

    private lateinit var adapter: ContactsAdapter
    private lateinit var contacts: MutableList<Person>
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        
        // 6 STEPS OF IMPLEMENTING RecyclerView, from https://guides.codepath.com/android/using-the-recyclerview
        // 1. Add RecyclerView AndroidX library to the Gradle build file - DONE
        // 2. Define a model class to use as the data source - DONE
        contacts = createContacts()
        // 3. Add a RecyclerView to your activity to display the items - DONE
        // 4. Create a custom row layout XML file to visualize the item - DONE
        // 5. Create a RecyclerView.Adapter and ViewHolder to render the item
        adapter = ContactsAdapter(this, contacts)
        rvContacts.adapter = adapter
        // 6. Bind the adapter to the data source to populate the RecyclerView
        rvContacts.layoutManager = LinearLayoutManager(this)
    }
    
    private fun createContacts(): MutableList<Person> {
        val contacts = mutableListOf<Person>()
        for (i in 1..100) {
            contacts.add(Person("Person $i", i))    
        }
        return contacts
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.miAdd) {
            // Navigate to ContactsActivity
            val intent = Intent(this, ContactsActivity::class.java)
            startActivityForResult(intent, 42)
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == 42 && resultCode == Activity.RESULT_OK) {
            val newPerson = data?.getSerializableExtra("person") as Person
            contacts.add(0, newPerson)
            adapter.notifyDataSetChanged()
        }
        super.onActivityResult(requestCode, resultCode, data)
    }
}