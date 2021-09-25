package com.cbb.transportcbb;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    Button button;
    Button btnsignin;

    User userob;

    EditText editTextTextEmailAddress2,editTextTextPassword;

    DatabaseReference db;
    FirebaseDatabase rootNode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userob = new User();

        button = findViewById(R.id.button);
        editTextTextEmailAddress2 = findViewById(R.id.editTextTextEmailAddress2);
        editTextTextPassword = findViewById(R.id.editTextTextPassword);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                startActivity(new Intent(MainActivity.this, Signup.class));
            }
        });




    }


    public void Signin(View view) {





        String enteredUsername = editTextTextEmailAddress2.getText().toString().trim();
        String enteredPassword = editTextTextPassword.getText().toString().trim();

        db = FirebaseDatabase.getInstance().getReference().child("User");

        Query checkUser = db.orderByChild("nic").equalTo(enteredUsername);

        checkUser.addListenerForSingleValueEvent(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                if(dataSnapshot.exists()){



                  String passwordFromDB = dataSnapshot.child(enteredUsername).child("password").getValue(String.class);

                    if(passwordFromDB.equals(enteredPassword)){

                        String emailFromDB = dataSnapshot.child(enteredUsername).child("email").getValue(String.class);
                        String mobileNumFromDB = dataSnapshot.child(enteredUsername).child("mobileNum").getValue(String.class);
                        String nameFromDB = dataSnapshot.child(enteredUsername).child("name").getValue(String.class);
                        String nicFromDB = dataSnapshot.child(enteredUsername).child("nic").getValue(String.class);

                        Intent intent = new Intent(getApplicationContext(),UserProfile.class);

                        intent.putExtra("name",nameFromDB);
                        intent.putExtra("email",emailFromDB);
                        intent.putExtra("nic",nicFromDB);
                        intent.putExtra("mobileNum",mobileNumFromDB);


                        Toast.makeText(getApplicationContext()," Successfully Logged in",Toast.LENGTH_LONG).show();
                        startActivity(intent);

                    }else {

                        Toast.makeText(getApplicationContext(),"Password Error",Toast.LENGTH_LONG).show();
                    }
                }else {

                    Toast.makeText(getApplicationContext(),"Username Error",Toast.LENGTH_LONG).show();
                }

            }

            @Override
            public void onCancelled(@NonNull  DatabaseError error) {

            }
        });
    }




}