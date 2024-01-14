package com.example.kdhdcsecmu5913;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;


public class Login extends AppCompatActivity {

    TextView gotoRegister;

    EditText emailAddress_O,password_O;

    Button goLoginBTN;

    FirebaseAuth fAuth;
    FirebaseFirestore fStore;

    boolean valid = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        gotoRegister = findViewById(R.id.CLK_Register_id);

        emailAddress_O = findViewById(R.id.TXT_lg_email_id);
        password_O = findViewById(R.id.TXT_lg_password_id);

        goLoginBTN = findViewById(R.id.BTN_login_id);
        

        fAuth = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();


        goLoginBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkField(emailAddress_O);
                checkField(password_O);

                if (valid){
                    fAuth.signInWithEmailAndPassword(emailAddress_O.getText().toString(), password_O.getText().toString()).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                        @Override
                        public void onSuccess(AuthResult authResult) {
                            
                            Toast.makeText(Login.this, "Logged In Successfully", Toast.LENGTH_SHORT).show();
                            checkUserAccessLevel(authResult.getUser().getUid());

                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(Login.this, e.getMessage(), Toast.LENGTH_SHORT).show();
    
                        }
                    });
                }
            }
        });

        gotoRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goRegister= new Intent(getApplicationContext(), Register.class);
                startActivity(goRegister);
            }
        });
    }

    private void checkUserAccessLevel(String uid) {

        DocumentReference df = fStore.collection("User").document(uid);

        df.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {

                Log.d("TAG", "onSuccess:" + documentSnapshot.getData());

                if (documentSnapshot.getString("isAdmin") != null){
                    startActivity(new Intent(getApplicationContext(), MainActivity.class));
                    finish();
                }
                if (documentSnapshot.getString("isUser") != null){
                    startActivity(new Intent(getApplicationContext(), UserPage.class));
                    finish();
                }
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