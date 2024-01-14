package com.example.kdhdcsecmu5913;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

import de.hdodenhof.circleimageview.CircleImageView;

public class MainAdapter2 extends FirebaseRecyclerAdapter<MainModel2,MainAdapter2.myViewHolder> {

    /**
     * Initialize a {@link RecyclerView.Adapter} that listens to a Firebase query. See
     * {@link FirebaseRecyclerOptions} for configuration options.
     *
     * @param options
     */
    public MainAdapter2(@NonNull FirebaseRecyclerOptions<MainModel2> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull myViewHolder holder,final int position, @NonNull MainModel2 model) {

        holder.category.setText(model.getCategory());
        holder.price.setText(model.getPrice());




    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.mainitem2,parent,false);
        return new myViewHolder(view);
    }

    static class myViewHolder extends RecyclerView.ViewHolder{

        TextView price, category;

        public myViewHolder(@NonNull View itemView) {
            super(itemView);



            price = (TextView)itemView.findViewById(R.id.fworderPrice);
            category = (TextView)itemView.findViewById(R.id.nameorderText_id);
        }
    }
}
