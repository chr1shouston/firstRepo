package com.example.localop

import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
class MainActivity : AppCompatActivity() {

    // Declaring variables
    private lateinit var cbITStudent: CheckBox
    private lateinit var edtName:EditText
    private lateinit var edtAge: EditText
    private lateinit var btnCheck: Button
    private lateinit var cbStaff: CheckBox
    private lateinit var cbBanned: CheckBox
    private lateinit var tvResult: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // Linking variables to the UI components using their ID's (typecasting)

        cbITStudent = findViewById(R.id.cbITStudent)
        edtName = findViewById(R.id.edtName)
        edtAge = findViewById(R.id.edtAge)
        btnCheck = findViewById(R.id.btnCheck)
        cbStaff = findViewById(R.id.cbStaff)
        cbBanned = findViewById(R.id.cbBanned)
        tvResult = findViewById(R.id.tvResult)



        btnCheck.setOnClickListener {

            //get the user's name from the edittext
            val name = edtName.text.toString()

            // convert the age entered into a number

            val age = edtAge.text.toString().toInt()

            // check if the checkboxes are selected (true or false)

            val isITStudent = cbITStudent.isChecked
            val isStaff = cbStaff.isChecked
            val isBanned = cbBanned.isChecked

            if(((age >= 18 && isITStudent) || isStaff) && !isBanned){
                // if the condition above is true
                tvResult.text = "Congratulations $name! You Qualify or the Student Tech Discount"
                }
            else{tvResult.text = "Sorry no"}

            /*
            Logical condition explanation
            Step 1:
               (age >= 18 && isITStudent)
               >= means greater than or equal to
               && means AND (both conditions must be true)

              so this checks if the user is 18 or older and is an IT student

             Step 2:
                || means OR (only one condition needs to be true
                This means the person can qualify if they are a staff member even if they are not an IT student

                Step 3: && !isBanned
                ! means NOT (it reverses the value of isBanned.isChecked)
                isBanned means the person must NOT be banned

             */
            {


            }

        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}