package com.example.loginandregistration;

import static com.example.loginandregistration.R.id.loginRedirecText;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.annotation.SuppressLint;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SingUpActivity extends AppCompatActivity {

    private FirebaseAuth auth;
    private EditText signupEmail, signupPassword;
    private Button signupButton;
    private TextView loginRedirectText;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sing_up_activity);

        //mapeo
        auth = FirebaseAuth.getInstance();
        signupEmail = findViewById(R.id.singup_email);
        signupPassword = findViewById(R.id.singup_password);
        signupButton = findViewById(R.id.singup_button);
        loginRedirectText = findViewById(loginRedirecText);

        //boton
        signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user=signupEmail.getText().toString().trim();
                String pass=signupPassword.getText().toString().trim();

                if(user.isEmpty()){
                    signupEmail.setError("Email cannot be empty");
                }

                if(pass.isEmpty()){
                    signupPassword.setError("Password cannot be empty");
                }else{
                    auth.createUserWithEmailAndPassword(user,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful()){
                                Toast.makeText(SingUpActivity.this, "SignUp Succesful", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(SingUpActivity.this, LoginActivity.class));
                            } else{
                                Toast.makeText(SingUpActivity.this, "SignUp Failed" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                            }

                        }
                    });
                }



            }
        });

        loginRedirectText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SingUpActivity.this, LoginActivity.class));
            }
        });



    }
}