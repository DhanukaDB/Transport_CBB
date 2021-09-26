package com.cbb.transportcbb;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class RetrieveCardActivity extends AppCompatActivity {

    ListView myListView;
    List<CardPayments> cardPaymentsList;

    DatabaseReference paymentDbRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrieve_card);

        myListView = findViewById(R.id.myListView);
        cardPaymentsList = new ArrayList<>();

        paymentDbRef = FirebaseDatabase.getInstance().getReference("CardPayment");

        paymentDbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                cardPaymentsList.clear();

                for (DataSnapshot cardPaymentDatasnap : snapshot.getChildren()){
                    CardPayments cardPayments = cardPaymentDatasnap.getValue(CardPayments.class);
                    cardPaymentsList.add(cardPayments);
                }
                ListAdapter adapter = new ListAdapter(RetrieveCardActivity.this, cardPaymentsList);
                myListView.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        //Making for Update the Details

        myListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {

                CardPayments cardPayments = cardPaymentsList.get(position);
                showUpdateDialog(cardPayments.getId(), cardPayments.getName());

                return false;
            }
        });
    }

    private void updateData(String id, String name, String address, String number){
        //creating database reference
        DatabaseReference DbRef = FirebaseDatabase.getInstance().getReference("CardPayments").child(id);
        CardPayments cardPayments = new CardPayments(id, name, address, number);
        DbRef.setValue(cardPayments);
    }

    private void showUpdateDialog(String id, String name){
        AlertDialog.Builder pDialog = new AlertDialog.Builder(this);
        LayoutInflater inflater = getLayoutInflater();
        View pDialogView = inflater.inflate(R.layout.update_dialog,null);

        pDialog.setView(pDialogView);

        //create views reference
        EditText updateName = pDialogView.findViewById(R.id.updateName);
        EditText updateAddress = pDialogView.findViewById(R.id.updateAddress);
        EditText updateNumber = pDialogView.findViewById(R.id.updateNumber);

        Button btnUpdate = pDialogView.findViewById(R.id. btn_updatePay);

        pDialog.setTitle("Updating" + " " + name + "'s" + " " + "record");
        pDialog.show();

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //here we will update the data in database
                //now getting values from view

                String newName = updateName.getText().toString();
                String newAddress = updateAddress.getText().toString();
                String newNumber = updateNumber.getText().toString();

                updateData(id, newName, newAddress, newNumber);

                Toast.makeText(RetrieveCardActivity.this, "Record Updated", Toast.LENGTH_SHORT).show();

            }
        });
    }


}