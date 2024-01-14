package com.example.kdhdcsecmu5913;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;

import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class Addadmin extends AppCompatActivity {
    TextView gotoLogin;
    EditText name_0,emailAddress_0,passWord_0;
    Button register_0;

    boolean valid=true;
    FirebaseAuth fireAuth;
    FirebaseFirestore fireStore;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addadmin);
        fireAuth=FirebaseAuth.getInstance();
        fireStore=FirebaseFirestore.getInstance();

        register_0=findViewById(R.id.BTN_register_id);
        gotoLogin= findViewById(R.id.CLK_Login_id);
        name_0=findViewById(R.id.TXT_name_id);
        emailAddress_0=findViewById(R.id.TXT_email_id);
        passWord_0=findViewById(R.id.TXT_password_id);
        gotoLogin.setOnClickListener(view -> goLogin());

        register_0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkField(name_0);
                checkField(emailAddress_0);
                checkField(passWord_0);

                if (valid){
                    fireAuth.createUserWithEmailAndPassword(emailAddress_0.getText().toString(),passWord_0.getText().toString()).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                        @Override
                        public void onSuccess(AuthResult authResult) {
                            FirebaseUser user = fireAuth.getCurrentUser();
                            Toast.makeText(Addadmin.this,"Account is created successfully", Toast.LENGTH_SHORT).show();
                            DocumentReference df= fireStore.collection("User").document(user.getUid());
                            Map<String, Object>userInfo=new HashMap<>();
                            userInfo.put("Name",name_0.getText().toString());
                            userInfo.put("UserEmail",emailAddress_0.getText().toString());
                            userInfo.put("isAdmin","1");
                            df.set(userInfo);
                            startActivity(new Intent(getApplicationContext(),Login.class));
                            finish();

                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(Addadmin.this,"Failed to create account", Toast.LENGTH_SHORT).show();
                        }
                    });
                }
            }
        });
    }
    public void goLogin(){
        Intent goLogin=new Intent(getApplicationContext(), Login.class);
        startActivity(goLogin);
    }
    public boolean checkField(EditText editTextValue){
        if (editTextValue.getText().toString().isEmpty()){
            editTextValue.setError("Error");
            valid=false;
        }else {
            valid=true;
        }
        return valid;
    };
}