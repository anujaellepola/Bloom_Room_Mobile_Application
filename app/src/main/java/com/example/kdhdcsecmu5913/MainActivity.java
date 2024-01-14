package com.example.kdhdcsecmu5913;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    CardView cDV_mUser, cDV_mFlw, cDV_mLogout,cDV_mord;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cDV_mUser = findViewById(R.id.CDV_ManageUser_id);
        cDV_mFlw = findViewById(R.id.CDV_ManageFlower_id);
        cDV_mLogout = findViewById(R.id.CDV_Logout_id);
        cDV_mord=findViewById(R.id.CDV_Manageord_id);
        cDV_mord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent invokeManageord1= new Intent(getApplicationContext(), View_orders.class);
                startActivity(invokeManageord1);
            }

        });

        cDV_mUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent invokeManageFlw1= new Intent(getApplicationContext(), Manage_users.class);
                startActivity(invokeManageFlw1);
            }
        });

        cDV_mFlw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent invokeManageFlw= new Intent(getApplicationContext(), Manage_flw.class);
                startActivity(invokeManageFlw);
            }
        });

        cDV_mLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logout();
            }
        });
    }
    private void logout() {
        Intent intent = new Intent(getApplicationContext(), Login.class);
        startActivity(intent);
        finish();
    }
}
