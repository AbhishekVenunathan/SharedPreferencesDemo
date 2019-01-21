package com.abhishekvenunathan.sharedpreferencesdemo;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.io.IOException;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences sharedPreferences = this.getSharedPreferences("com.abhishekvenunathan.sharedpreferencesdemo",Context.MODE_PRIVATE);

        //sharedPreferences.edit().putString("username","Abhishek").apply();

        //String value = sharedPreferences.getString("username","");

        //Log.i("Username:",value);

        ArrayList<String> friends = new ArrayList<String>();

        friends.add("Abhishek1");
        friends.add("Abhishek2");
        friends.add("Abhishek3");

        try {
            sharedPreferences.edit().putString("friends",ObjectSerializer.serialize(friends)).apply();
            Log.i("Serial:",ObjectSerializer.serialize(friends));

        }
        catch (Exception e) {
            e.printStackTrace();
        }

        ArrayList<String> newFriends = new ArrayList<String>();

        try {
            newFriends = (ArrayList<String>) ObjectSerializer.deserialize(sharedPreferences.getString("friends",ObjectSerializer.serialize(new ArrayList<String>())));
        } catch (Exception e) {
            e.printStackTrace();
        }

        Log.i("New friends:",newFriends.toString());

        //String friendsResult = sharedPreferences.getString("friends","");

        //Log.i("result",friendsResult);

    }
}
