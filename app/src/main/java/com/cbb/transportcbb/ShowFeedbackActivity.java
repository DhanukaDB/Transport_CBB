package com.cbb.transportcbb;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class ShowFeedbackActivity extends AppCompatActivity {


    private RecyclerView feedBackRecycler;
    private DatabaseReference dbFeed;
    private FeedAdapter feedAdapter;
    private List<FeedbackModel> feedbackModelList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_feedback);

        feedBackRecycler = findViewById(R.id.feedbackRecyclerView);
        feedBackRecycler.setHasFixedSize(true);
        feedBackRecycler.setLayoutManager(new LinearLayoutManager(this));

        dbFeed = FirebaseDatabase.getInstance().getReference().child("Feedbacks");
        feedbackModelList = new ArrayList<>();
        feedAdapter = new FeedAdapter(this, feedbackModelList);
        feedBackRecycler.setAdapter(feedAdapter);

        dbFeed.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot: snapshot.getChildren()){
                    FeedbackModel feedbackModel = dataSnapshot.getValue(FeedbackModel.class);
                    feedbackModelList.add(feedbackModel);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }


    }
