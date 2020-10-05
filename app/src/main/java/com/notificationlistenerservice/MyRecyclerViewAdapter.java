package com.notificationlistenerservice;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.ViewHolder> {


    private static ArrayList<NotificationsHolder> mNotifications = new ArrayList<>();

    public MyRecyclerViewAdapter(ArrayList<NotificationsHolder> mNots){
        mNotifications = mNots;
    }


    @NonNull
    @Override
    public MyRecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rows, parent, false);
        MyRecyclerViewAdapter.ViewHolder holder = new MyRecyclerViewAdapter.ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyRecyclerViewAdapter.ViewHolder holder, int position) {
        NotificationsHolder object = mNotifications.get(position);
        //Set the text for each view
        holder.NotificationContent.setText(object.getNotification());
    }

    @Override
    public int getItemCount() {
        return mNotifications.size();
    }


    public void addItem(int postion) {
        notifyItemInserted(postion);
    }



    public class ViewHolder extends RecyclerView.ViewHolder{

        //declare list views
        TextView NotificationContent;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            //initialize list views
            NotificationContent = itemView.findViewById(R.id.content);
        }
    }

}