package com.cbb.transportcbb;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class FeedAdapter extends RecyclerView.Adapter<FeedAdapter.FeedViewHolder> {

    private com.example.realtime.ShowFeedbackActivity feedbackActivity;
    private List<FeedbackModel> fList;
    public FeedAdapter(com.example.realtime.ShowFeedbackActivity feedbackActivity, List<FeedbackModel> fList){
        this.feedbackActivity = feedbackActivity;
        this.fList = fList;
    }


    @NonNull
    @Override
    public FeedViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(feedbackActivity).inflate(R.layout.feedback, parent, false);
        return new FeedViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull FeedViewHolder holder, int position) {

        holder.email.setText(fList.get(position).getEmail());
        holder.feedBack.setText(fList.get(position).getFeedback());


    }

    @Override
    public int getItemCount() {
        return fList.size();
    }

    public static class FeedViewHolder extends RecyclerView.ViewHolder{

        TextView email , feedBack;

        public FeedViewHolder(@NonNull View itemView) {
            super(itemView);

            email = itemView.findViewById(R.id.feed_email);
            feedBack = itemView.findViewById(R.id.feed_feedback);
        }
    }
}
