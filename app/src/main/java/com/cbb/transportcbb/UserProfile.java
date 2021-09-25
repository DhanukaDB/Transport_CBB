package com.cbb.transportcbb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class UserProfile extends AppCompatActivity {

    Button button4;

    TextView editTextTextPersonName2,editTextTextPersonName3,editTextTextPersonName5,editTextTextPersonName6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);

        button4 = findViewById(R.id.button4);

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                startActivity(new Intent(UserProfile.this, home.class));

            }
        });

        editTextTextPersonName2 = findViewById(R.id.editTextTextPersonName2);
        editTextTextPersonName3 = findViewById(R.id.editTextTextPersonName3);
        editTextTextPersonName5 = findViewById(R.id.editTextTextPersonName5);
        editTextTextPersonName6 = findViewById(R.id.editTextTextPersonName6);


        //show
        
        showUserdata();

    }

    private void showUserdata() {

        Intent intent = getIntent();
        String user_email = intent.getStringExtra("email");
        String user_name = intent.getStringExtra("name");
        String user_nic = intent.getStringExtra("nic");
        String user_mobileNum = intent.getStringExtra("mobileNum");

        editTextTextPersonName2.setText(user_email);
        editTextTextPersonName3.setText(user_name);
        editTextTextPersonName5.setText(user_nic);
        editTextTextPersonName6.setText(user_mobileNum);

    }
}