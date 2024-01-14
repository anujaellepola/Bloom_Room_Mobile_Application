package com.example.kdhdcsecmu5913;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class UserPage extends AppCompatActivity {

    CardView cDV_viewCategory, cDV_orderFlw, cDV_viewFlw, cDV_Logout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_page);

        cDV_viewCategory = findViewById(R.id.CDV_viewCategory_id);
        cDV_orderFlw = findViewById(R.id.CDV_orderFlw_id);
        cDV_viewFlw = findViewById(R.id.CDV_viewFlw_id);
        cDV_Logout = findViewById(R.id.CDV_Logout_id);

        cDV_viewCategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent invokeorderflower= new Intent(getApplicationContext(), View_category.class);
                startActivity(invokeorderflower);

            }
        });

        cDV_orderFlw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent invokeorderflower= new Intent(getApplicationContext(), Orderflower.class);
                startActivity(invokeorderflower);
            }
        });

        cDV_viewFlw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent invokeViewFlw= new Intent(getApplicationContext(), View_flw.class);
                startActivity(invokeViewFlw);
            }
        });

        cDV_Logout.setOnClickListener(new View.OnClickListener() {
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
