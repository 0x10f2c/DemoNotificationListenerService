package com.notificationlistenerservice;

import android.text.TextUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NotificationsHolder {

    //Notification variables
    private String id;
    private String packagedetails;
    private String title;
    private String details;

    //Constructor
    public NotificationsHolder(String idinput, String packagedetailsinput, String Title, String detailsinput){
        id = idinput;
        packagedetails = packagedetailsinput;
        details = detailsinput;
        title = Title;
    }

    public String getNotification(){
        String Notification = "ID: " + id + "\nPackage: " + packagedetails + "\n Title: " + title +"\nDetails: " + details;
        return Notification;
    }

}
