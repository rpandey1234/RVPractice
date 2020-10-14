package edu.stanford.rkpandey.rvpractice

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_contacts.*

class ContactsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contacts)

        btnSubmit.setOnClickListener { 
            val name = etName.text.toString()
            val age = etAge.text.toString().toInt()
            val newPerson = Person(name, age)
            val output = Intent()
            output.putExtra("person", newPerson)
            setResult(Activity.RESULT_OK, output)
            finish()
        }
    }
}