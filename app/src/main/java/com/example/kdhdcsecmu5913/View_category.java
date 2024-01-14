package com.example.kdhdcsecmu5913;

//import androidx.appcompat.app.AppCompatActivity;
//import androidx.cardview.widget.CardView;
//
//import android.content.Intent;
//import android.os.Bundle;
//import android.view.View;
//
//public class View_category extends AppCompatActivity {
//    CardView cDV_pack1,cDV_pack2, cDV_pack3, cDV_Logout;
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_view_category);
//        cDV_pack1= findViewById(R.id.CDV_valentine);
//        cDV_pack2 = findViewById(R.id.CDV_birthday);
//        cDV_pack3 = findViewById(R.id.CDV_pack3_id);
//        cDV_Logout = findViewById(R.id.CDV_Logout1_id);
//
//
//        cDV_pack1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent invoke=new Intent(getApplicationContext(), valentinepack.class);
//                startActivity(invoke);
//            }
//        });
//
//      cDV_pack2.setOnClickListener(new View.OnClickListener() {
//          @Override
//          public void onClick(View v) {
//              Intent invoke1=new Intent(getApplicationContext(),summerpack.class);
//              startActivity(invoke1);
//          }
//      });
//
//       cDV_pack3.setOnClickListener(new View.OnClickListener() {
//           @Override
//           public void onClick(View v) {
//               Intent invoke2=new Intent(getApplicationContext(), anniversarypack.class);
//               startActivity(invoke2);
//           }
//       });
//
//        cDV_Logout.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                logout();
//            }
//        });
//    }
//    private void logout() {
//        Intent intent = new Intent(getApplicationContext(), Login.class);
//        startActivity(intent);
//        finish();
//    }
//}

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class View_category extends AppCompatActivity {
    CardView cDV_pack1,cDV_pack2, cDV_pack3, cDV_Logout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_category);
        cDV_pack1= findViewById(R.id.CDV_valentine_id);
        cDV_pack2 = findViewById(R.id.CDV_birthday_id);
        cDV_pack3 = findViewById(R.id.CDV_pack3_id);
        cDV_Logout = findViewById(R.id.CDV_Logout1_id);

        cDV_pack1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent invokeorderflower= new Intent(getApplicationContext(), valentinepack.class);
                startActivity(invokeorderflower);

            }
        });

        cDV_pack2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent invokeorderflower= new Intent(getApplicationContext(), summerpack.class);
                startActivity(invokeorderflower);

            }
        });

        cDV_pack3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent invokeViewFlw= new Intent(getApplicationContext(), anniversarypack.class);
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
