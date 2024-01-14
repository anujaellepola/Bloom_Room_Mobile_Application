package com.example.kdhdcsecmu5913;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Showcart_Adapter extends RecyclerView.Adapter<Showcart_Adapter.ViewHolder> {

    Context context;
    List<Showcart_Model> showcartModelList;

    public Showcart_Adapter(Context context, List<Showcart_Model> showcart_models){
        this.context=context;
        this.showcartModelList=showcart_models;
    }

    @NonNull
    @Override
    public Showcart_Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.layout_order,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull Showcart_Adapter.ViewHolder holder, int position) {
        Showcart_Model showcart_model=showcartModelList.get(position);
        holder.Product_category.setText(showcart_model.getCategory());
        holder.Product_price.setText(showcart_model.getPrice());

    }

    @Override
    public int getItemCount() {
        return showcartModelList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        TextView Product_category;
        TextView Product_price;
        public ViewHolder(@NonNull View itemView){
            super(itemView);
            Product_category=itemView.findViewById(R.id.product_category);
            Product_price=itemView.findViewById(R.id.product_price);
        }
    }
}
