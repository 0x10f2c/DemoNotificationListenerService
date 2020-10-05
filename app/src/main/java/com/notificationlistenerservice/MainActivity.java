package com.notificationlistenerservice;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    static MyRecyclerViewAdapter mAdaptor;
    public static ArrayList<NotificationsHolder> notifications = new ArrayList<NotificationsHolder>();
    MyRecyclerViewAdapter adapter;
    static int position = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // set up the RecyclerView
        RecyclerView recyclerView = findViewById(R.id.recy);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        mAdaptor = new MyRecyclerViewAdapter(notifications);
        recyclerView.setAdapter(mAdaptor);
    }


    //Method to add to array list
    public static void AddtoArray(String idinput, String packagedetailsinput, String title, String detailsinput){
        notifications.add(new NotificationsHolder(idinput,packagedetailsinput,title,detailsinput));
        mAdaptor.addItem(position);
        position = position + 1;
    }

}