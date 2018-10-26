package com.edionay.doeplus;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.security.PrivateKey;

public class MainActivity extends AppCompatActivity {

    private DatabaseReference firebaseUsersReference = FirebaseDatabase.getInstance().getReference();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DatabaseReference users = firebaseUsersReference.child("users");

        User newUser = new User();

        newUser.setEmail("edionay@gmail.com");
        newUser.setName("Edionay");
        newUser.setPassword("12345");

        users.child("001").setValue(newUser);
    }
}
