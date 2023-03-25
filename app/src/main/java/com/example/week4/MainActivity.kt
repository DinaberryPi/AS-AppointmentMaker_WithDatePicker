package com.example.week4

import android.os.Bundle
import android.view.WindowManager
import android.widget.Button
import android.widget.DatePicker
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);
        // my code starts here
        //create a reference to the button by using the findViewById() method and assigning it to a variable
        val confirmButton = findViewById<Button>(R.id.confirm)
        // same with others, create reference
        val resultDisplay = findViewById<TextView>(R.id.result)
        val datePicker = findViewById<DatePicker>(R.id.datePicker)

        // Obtain the current date using the Calendar class
        val calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)

        // Set the current date on the DatePicker

        datePicker.init(year, month, day
        ) { view, year, monthOfYear, dayOfMonth -> // Update the TextView with the selected date
            val dateString = "$dayOfMonth/${monthOfYear + 1}/$year"
            resultDisplay.text = dateString
        }

        /*Set a click listener on the button by calling the setOnClickListener() method on the button variable and passing in a lambda function that will be called when the button is clicked*/
        confirmButton.setOnClickListener {
            val dateString = "${datePicker.dayOfMonth}/${datePicker.month+1}/${datePicker.year}"
            val nameEntered = findViewById<EditText>(R.id.username).text.toString()
            val message = getString(R.string.appointment_message, nameEntered, dateString)
            resultDisplay.text = message
        }
    }
}