package com.example.kdhdcsecmu5913;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.Firebase;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class Register extends AppCompatActivity {
    TextView gotoLogin;

    EditText name_O,emailAddress_O,password_O;

    Button register_O;

    boolean valid = true;

    FirebaseAuth fAuth;
    FirebaseFirestore fStore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        fAuth = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();

        gotoLogin = findViewById(R.id.CLK_Login_id);
        register_O = findViewById(R.id.BTN_register_id);

        name_O = findViewById(R.id.TXT_name_id);
        emailAddress_O = findViewById(R.id.TXT_email_id);
        password_O = findViewById(R.id.TXT_password_id);

        register_O.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkField(name_O);
                checkField(emailAddress_O);
                checkField(password_O);

                if (valid){
                    //user registration
                    fAuth.createUserWithEmailAndPassword(emailAddress_O.getText().toString(), password_O.getText().toString()).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                        @Override
                        public void onSuccess(AuthResult authResult) {
                            FirebaseUser user = fAuth.getCurrentUser();
                            Toast.makeText(Register.this, "Account is Created Successfully", Toast.LENGTH_SHORT).show();
                            DocumentReference df = fStore.collection("User").document(user.getUid());
                            Map<String,Object> userInfo = new HashMap<>();
                            userInfo.put("Name",name_O.getText().toString());
                            userInfo.put("UserEmail",emailAddress_O.getText().toString());

                            //access leve;
                            userInfo.put("isUser","1");

                            df.set(userInfo);

                            startActivity(new Intent(getApplicationContext(), Login.class));
                            finish();
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(Register.this, "Failed to Create an Account", Toast.LENGTH_SHORT).show();
                        }
                    });
                }
            }
        });

        gotoLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goLogin= new Intent(getApplicationContext(), Login.class);
                startActivity(goLogin);
            }
        });
    }

    public boolean checkField(EditText editTextValue){
        if (editTextValue.getText().toString().isEmpty()){
            editTextValue.setError("Error");
            valid = false;
        }else {
            valid = true;
        }
        return valid;
    };
}