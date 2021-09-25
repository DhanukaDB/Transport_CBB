package com.cbb.transportcbb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class BookingSuccess extends AppCompatActivity {

    EditText editTextTextPersonName7,editTextTextPersonName10,editTextTextPersonName11,editTextTextPersonName13,editTextTextPersonName14,editTextTextPersonName9,editTextTextPersonName12;

    DatabaseReference db;
    Bookdetails bkdob;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking_success);

        db = FirebaseDatabase.getInstance().getReference("Bookings");

        bkdob = new Bookdetails();

        editTextTextPersonName10 = findViewById(R.id.editTextTextPersonName10);
        editTextTextPersonName11 = findViewById(R.id.editTextTextPersonName11);
        editTextTextPersonName13 = findViewById(R.id.editTextTextPersonName13);
        editTextTextPersonName14 = findViewById(R.id.editTextTextPersonName14);
        editTextTextPersonName7 = findViewById(R.id.editTextTextPersonName7);
        editTextTextPersonName9 = findViewById(R.id.editTextTextPersonName9);
        editTextTextPersonName12 = findViewById(R.id.editTextTextPersonName12);

        showUserdata();

    }
        private void showUserdata() {

            Intent intent = getIntent();
            String user_from = intent.getStringExtra("from");
            String user_to = intent.getStringExtra("to");
            String user_date = intent.getStringExtra("date");
            String user_time = intent.getStringExtra("time");
            String user_category = intent.getStringExtra("category");
            String user_email = intent.getStringExtra("email");
            String user_qty = intent.getStringExtra("qty");


            editTextTextPersonName10.setText(user_email);
            editTextTextPersonName11.setText(user_from);
            editTextTextPersonName13.setText(user_to);
            editTextTextPersonName7.setText(user_date);
            editTextTextPersonName14.setText(user_time);
            editTextTextPersonName13.setText(user_category);
            editTextTextPersonName9.setText(user_date);
            editTextTextPersonName12.setText(user_qty);
        }

}