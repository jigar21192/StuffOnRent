package com.example.viral.stuffonrent;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

public class Package_Adapter extends RecyclerView.Adapter<Package_Adapter.MyViewHolder> {

    private List<Model_Package> model;
    Context context;



    public class MyViewHolder extends RecyclerView.ViewHolder{
        public TextView title, year, genre;
        ImageView imageView;


        public MyViewHolder(View view){
            super(view);

            imageView=(ImageView)view.findViewById(R.id.img) ;
            year=(TextView) view.findViewById(R.id.year);
            genre=(TextView) view.findViewById(R.id.genre);

        }

    }
    public Package_Adapter(List<Model_Package> model,Context context)
    {
        this.model=model;
        this.context=context;
    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.itemview,parent,false);
        return new MyViewHolder(itemView);
    }
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Model_Package model_package=model.get(position);
        holder.genre.setText(model_package.getName());
        if( context!= null ){
            Glide.with(context)
                    .load(model_package.getImage())

                    .into(holder.imageView);
        }


    }

    @Override
    public int getItemCount() {
        return model.size();
    }
}
