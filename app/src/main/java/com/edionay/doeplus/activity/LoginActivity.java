package com.edionay.doeplus.activity;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.edionay.doeplus.R;
import com.edionay.doeplus.model.Organization;
import com.edionay.doeplus.service.FirebaseService;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseAuthInvalidUserException;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.auth.FirebaseAuthWeakPasswordException;

public class LoginActivity extends AppCompatActivity {

    private EditText email, password;
    private TextView register;
    private Button loginButton;
    private Organization organization;
    private FirebaseAuth autentication;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        email = findViewById(R.id.editEmail);
        password = findViewById(R.id.editPassword);
        loginButton = findViewById(R.id.buttonLogin);
        register = findViewById(R.id.registerOption);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String emailField = email.getText().toString();
                String passwordField = password.getText().toString();

                if (!emailField.isEmpty()) {
                    if (!passwordField.isEmpty()) {
                        organization = new Organization();
                        organization.setEmail(emailField);
                        organization.setPassword(passwordField);
                        login(organization);
                    }else{
                        Toast.makeText(LoginActivity.this,
                                "Preencha a senha",
                                Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(LoginActivity.this,
                            "Preencha o e-mail",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), NewOrganizationActivity.class);
                startActivity(intent);
            }
        });
    }

    public void login(Organization organization) {
        autentication = FirebaseService.getAutentication();
        autentication.signInWithEmailAndPassword(organization.getEmail(), organization.getPassword())
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(LoginActivity.this,
                                    "Login efetuado",
                                    Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(getApplicationContext(), EventListActivity.class);
                            startActivity(intent);
                        } else {

                            String exception = "";
                            try{
                                throw task.getException();
                            }catch (FirebaseAuthInvalidUserException e){
                                exception = "E-mail ou senha não correspondem a um usuário cadastrado";
                            }catch (FirebaseAuthInvalidCredentialsException e){
                                exception = "Por favor escolha um email ou senha validos";
                            }catch (Exception e){
                                exception = "Erro no login: " + e.getMessage();
                                e.printStackTrace();
                            }

                            Toast.makeText(LoginActivity.this,
                                    exception,
                                    Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
}
