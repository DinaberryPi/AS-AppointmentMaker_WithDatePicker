package com.example.week4

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    //var billAmount = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // my code starts here
        //create a reference to the button by using the findViewById() method and assigning it to a variable
        val calculateButton = findViewById<Button>(R.id.calculate)
        // same with others, create reference
        val editAmount = findViewById<EditText>(R.id.enterBill)
        val totalDisplay = findViewById<TextView>(R.id.total)
        /*Set a click listener on the button by calling the setOnClickListener() method on the button variable and passing in a lambda function that will be called when the button is clicked*/
        calculateButton.setOnClickListener {
            val editAmount = editAmount.text.toString().toFloatOrNull()
            // Check if the input is valid
            if (editAmount == null) {
                totalDisplay.text = "Invalid input"
            } else {
                // Calculate the tax amount and display it in the TextView
                val totalAmount = editAmount*1.0625
                totalDisplay.text = "Your total is: $totalAmount"
            }
        }
    }
}