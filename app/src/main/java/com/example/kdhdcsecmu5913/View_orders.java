package com.example.kdhdcsecmu5913;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;

public class View_orders extends AppCompatActivity {

    RecyclerView recyclerView;
    MainAdapter2 mainadap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_orders);

        recyclerView = (RecyclerView)findViewById(R.id.rv5_id);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        FirebaseRecyclerOptions<MainModel2> options = new FirebaseRecyclerOptions.Builder<MainModel2>()
                .setQuery(FirebaseDatabase.getInstance().getReference().child("AddtoCart"), MainModel2.class)
                .build();

        mainadap = new MainAdapter2(options);
        recyclerView.setAdapter(mainadap);
    }

    @Override
    protected void onStart() {
        super.onStart();
        mainadap.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        mainadap.stopListening();
    }
}