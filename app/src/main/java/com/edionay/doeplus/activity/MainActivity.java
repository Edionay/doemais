package com.edionay.doeplus.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.edionay.doeplus.R;


public class MainActivity extends AppCompatActivity {

    private ListView foodList;
    private String[] food = {"Camarão", "Empanado", "Cocada"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        foodList = findViewById(R.id.foodList);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                getApplicationContext(),
                android.R.layout.simple_list_item_1,
                android.R.id.text1,
                food
        );

        foodList.setAdapter(adapter);
    }
}


// Manage Firebase database reference
//    private DatabaseReference firebaseReference = FirebaseDatabase.getInstance().getReference();

// Reference to manage users auth on Firebase
//    private FirebaseAuth user = FirebaseAuth.getInstance();

//        user.signInWithEmailAndPassword("edionay@gmail.com", "ed12345");
//
//        if (user.getCurrentUser() != null) {
//            Log.i("Create User", "Logged user!");
//        } else {
//            Log.i("Create User", "Not logged user!");
//        }
//
//
//        User newUser = new User();
//
//        newUser.setEmail("edionay@gmail.com");
//        newUser.setName("Edionay");
//        newUser.setPassword("12345");
//
//        // Add new data to database
//        DatabaseReference users = firebaseReference.child("users");
//        users.child("001").setValue(newUser);