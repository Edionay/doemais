package com.edionay.doeplus;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.security.PrivateKey;

public class MainActivity extends AppCompatActivity {

    // Manage Firebase database reference
    private DatabaseReference firebaseUsersReference = FirebaseDatabase.getInstance().getReference();

    // Reference to manage users auth on Firebase
    private FirebaseAuth user = FirebaseAuth.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Create a new user using email and password
        user.createUserWithEmailAndPassword("edionay@gmail.com", "ed12345")
                .addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
                    // Exception handler
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()) {
                            Log.i("CreateUser", "Success!");
                        } else {
                            Log.i("CreateUser", "Error!");
                        }
                    }
                });


        User newUser = new User();

        newUser.setEmail("edionay@gmail.com");
        newUser.setName("Edionay");
        newUser.setPassword("12345");

        // Add new data to database
        DatabaseReference users = firebaseUsersReference.child("users");
        users.child("001").setValue(newUser);
    }
}
