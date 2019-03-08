package com.example.viral.stuffonrent;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.List;

public class Item_Adapter extends RecyclerView.Adapter<Item_Adapter.MyViewHolder> {

    private List<Model_item> model;
    Context context;



    public class MyViewHolder extends RecyclerView.ViewHolder{
        public TextView name, rent, location;
        ImageView imageView;


        public MyViewHolder(View view){
            super(view);

            imageView=(ImageView)view.findViewById(R.id.img) ;
            name=(TextView) view.findViewById(R.id.name);
            rent=(TextView) view.findViewById(R.id.rent);
            location=(TextView) view.findViewById(R.id.location);
        }

    }
    public Item_Adapter(List<Model_item> model, Context context)
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
        Model_item model_item=model.get(position);

        if (model_item.getTag().equals("pac")) {
            holder.name.setText(model_item.getP_name());
            holder.rent.setText(model_item.getP_rent());
            holder.location.setText(model_item.getP_city());
            if (context != null) {
                Glide.with(context)
                        .load(model_item.getImage1())

                        .into(holder.imageView);
            }
        }
        else if (model_item.getTag().equals("fur")){
            holder.name.setText(model_item.getF_name());
            holder.rent.setText(model_item.getF_rent());
            holder.location.setText(model_item.getF_city());
            if (context != null) {
                Glide.with(context)
                        .load(model_item.getImage1())

                        .into(holder.imageView);
            }
        }
        else if (model_item.getTag().equals("appl")){

            holder.name.setText(model_item.getA_name());
            holder.rent.setText(model_item.getA_rent());
            holder.location.setText(model_item.getA_city());
            if (context != null) {
                Glide.with(context)
                        .load(model_item.getImage1())

                        .into(holder.imageView);
            }
        }
        else if (model_item.getTag().equals("vehi")){

            holder.name.setText(model_item.getV_name());
            holder.rent.setText(model_item.getV_rent());
            holder.location.setText(model_item.getV_city());
            if (context != null) {
                Glide.with(context)
                        .load(model_item.getImage1())

                        .into(holder.imageView);
            }
        }
        else if (model_item.getTag().equals("cos")){

            holder.name.setText(model_item.getC_name());
            holder.rent.setText(model_item.getC_rent());
            holder.location.setText(model_item.getC_city());
            if (context != null) {
                Glide.with(context)
                        .load(model_item.getImage1())

                        .into(holder.imageView);
            }
        }
        else {

            Toast.makeText(context, "Prosuct Not Available", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public int getItemCount() {
        return model.size();
    }
}
