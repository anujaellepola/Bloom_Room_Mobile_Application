package com.example.kdhdcsecmu5913;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;

public class View_flw extends AppCompatActivity {

    RecyclerView recyclerView;
    MainAdapter1 mainAdapter1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_flw);

        recyclerView = (RecyclerView)findViewById(R.id.rv1_id);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        FirebaseRecyclerOptions<MainModel> options =
                new FirebaseRecyclerOptions.Builder<MainModel>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("Flowers"), MainModel.class)
                        .build();

        mainAdapter1 = new MainAdapter1(options);
        recyclerView.setAdapter(mainAdapter1);
    }

    @Override
    protected void onStart() {
        super.onStart();
        mainAdapter1.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        mainAdapter1.stopListening();
    }
}