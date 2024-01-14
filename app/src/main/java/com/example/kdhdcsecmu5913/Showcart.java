package com.example.kdhdcsecmu5913;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class Showcart extends AppCompatActivity {

    private RecyclerView rec;
    private List<Showcart_Model> showcartModelList=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_showcart);
        rec=findViewById(R.id.rec);
        rec.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

        DatabaseReference Show_info= FirebaseDatabase.getInstance().getReference("AddtoCart");

        Show_info.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()){
                    showcartModelList.clear();
                    for (DataSnapshot snapshot1:snapshot.getChildren()){
                        Showcart_Model showcart_model=snapshot1.getValue(Showcart_Model.class);
                        showcartModelList.add(showcart_model);
                    }
                    rec.setAdapter(new Showcart_Adapter(getApplicationContext(),showcartModelList));
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}