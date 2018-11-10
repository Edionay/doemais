package com.edionay.doeplus.service;

import com.google.firebase.auth.FirebaseAuth;

public class FirebaseService {

    private static FirebaseAuth autentication;

    public static FirebaseAuth getAutentication() {

        if (autentication == null) {
            autentication = FirebaseAuth.getInstance();
        }
        return autentication;
    }
}
