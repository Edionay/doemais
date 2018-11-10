package com.edionay.doeplus.activity;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.edionay.doeplus.R;
import com.edionay.doeplus.model.Organization;
import com.edionay.doeplus.service.FirebaseService;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class NewOrganizationActivity extends AppCompatActivity {

    private EditText organizationName, organizationEmail, organizationPassword;
    private Button organizationRegisterButton;
    private FirebaseAuth autentication;
    private Organization newOrganization;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_organization);

        organizationName = findViewById(R.id.editOrganizationName);
        organizationEmail = findViewById(R.id.editOrganizationEmail);
        organizationPassword = findViewById(R.id.editOrganizationPassword);
        organizationRegisterButton = findViewById(R.id.buttonNewOrganization);

        organizationRegisterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String nameField = organizationName.getText().toString();
                String emailField = organizationEmail.getText().toString();
                String passwordField = organizationPassword.getText().toString();

                if (!nameField.isEmpty()) {
                    if (!emailField.isEmpty()) {
                        if (!passwordField.isEmpty()) {
                            newOrganization = new Organization();
                            newOrganization.setName(nameField);
                            newOrganization.setEmail(emailField);
                            newOrganization.setPassword(passwordField);
                            registerOrganization(newOrganization);
                        }
                    }
                } else {
                    Toast.makeText(NewOrganizationActivity.this,
                            "Preencha todos os campos!",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void registerOrganization(Organization newOrganization) {

        autentication = FirebaseService.getAutentication();
        autentication.createUserWithEmailAndPassword(newOrganization.getEmail(),
                newOrganization.getPassword()).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    Toast.makeText(NewOrganizationActivity.this,
                            "Cadastro efetuado",
                            Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(NewOrganizationActivity.this,
                            "Erro ao cadastrar!",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
