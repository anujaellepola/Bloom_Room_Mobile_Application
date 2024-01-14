package com.example.kdhdcsecmu5913;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;

public class Orderflower extends AppCompatActivity {
    TextView show_cart;
    Button button1,button2,button3;

    DatabaseReference reference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orderflower);

        reference= FirebaseDatabase.getInstance().getReference("AddtoCart");



        show_cart=findViewById(R.id.show_cart);
        button1=findViewById(R.id.button1);
        button2=findViewById(R.id.button2);
        button3=findViewById(R.id.button3);

        String ID_cart = reference.push().getKey();
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ID_cart = reference.push().getKey();
                HashMap<String, String> parameter=new HashMap<>();
                parameter.put("category","Valentine Pack");
                parameter.put("price","9000");
                reference.child(ID_cart).setValue(parameter);
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ID_cart = reference.push().getKey();
                HashMap<String, String> parameter=new HashMap<>();
                parameter.put("category","Birthday Pack");
                parameter.put("price","6290");
                reference.child(ID_cart).setValue(parameter);
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ID_cart = reference.push().getKey();
                HashMap<String, String> parameter=new HashMap<>();
                parameter.put("category","Anniversary Pack");
                parameter.put("price","9000");
                reference.child(ID_cart).setValue(parameter);
            }
        });

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                show_cart.setText(""+snapshot.getChildrenCount());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {


            }
        });
        show_cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),Showcart.class));
            }
        });


    }
}