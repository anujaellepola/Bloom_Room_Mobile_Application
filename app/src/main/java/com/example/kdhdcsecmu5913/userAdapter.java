package com.example.kdhdcsecmu5913;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class userAdapter extends RecyclerView.Adapter<userAdapter.MyviewHolder>{

    Context context;
    ArrayList<User> userArrayList;

    public userAdapter(Context context, ArrayList<User> userArrayList) {
        this.context = context;
        this.userArrayList = userArrayList;
    }

    @NonNull
    @Override
    public userAdapter.MyviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(context).inflate(R.layout.item,parent,false);
        return new MyviewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull userAdapter.MyviewHolder holder, int position) {
        User user = userArrayList.get(position);
        holder.Name.setText(user.Name);
        holder.UserEmail.setText(user.UserEmail);

    }

    @Override
    public int getItemCount() {
        return userArrayList.size();
    }
    public static class MyviewHolder extends RecyclerView.ViewHolder{
        TextView Name,UserEmail;

        public MyviewHolder(@NonNull View itemView) {
            super(itemView);
            Name=itemView.findViewById(R.id.nameUser_id);
            UserEmail=itemView.findViewById(R.id.EmailUser_id);
        }
    }
}
