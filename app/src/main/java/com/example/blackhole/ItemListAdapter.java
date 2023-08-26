package com.example.blackhole;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;
import java.util.Locale;

public class ItemListAdapter extends RecyclerView.Adapter<ItemListAdapter.ViewHolder> {

    private List<Item> itemList;
    private Context context;


    public void setItems(List<Item> itemList) {
        this.itemList = itemList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_item, parent, false);
        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Item item = itemList.get(position);
        String url = item.getImageUrl();
//        if(!url.isEmpty()) {
            try {
                Glide.with(holder.priceImageView.getContext())
                        .load(url).
                        placeholder(R.drawable.placeholder)
                        .into(holder.priceImageView);
            } catch (Exception e) {
                e.printStackTrace();
            }
//        }


//        Glide.with(context).load(item.getImageUrl()).into(holder.priceImageView);


        // Bind other data to the views
        holder.titleTextView.setText(item.getTitle());
        holder.priceTextView.setText(String.format(Locale.getDefault(), "$%.2f", item.getPrice()));
        holder.constraintLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(holder.itemView.getContext(), ItemDetailsActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("title", item.getTitle());
                bundle.putString("image", item.getImageUrl());
                bundle.putString("description", item.getDescription());
                String price = String.format(Locale.getDefault(), "$%.2f", item.getPrice());
                bundle.putString("price", price);
                intent.putExtras(bundle);
                holder.itemView.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return itemList == null ? 0 : itemList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView titleTextView;
        TextView priceTextView;
        ImageView priceImageView;

        TextView descriptionTextView;
        ConstraintLayout constraintLayout;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            titleTextView = itemView.findViewById(R.id.titleTextView);
            priceTextView = itemView.findViewById(R.id.priceTextView);
            // Initialize other UI components here
            descriptionTextView = itemView.findViewById(R.id.descriptionTextView);
            priceImageView = itemView.findViewById(R.id.itemImageView);

            constraintLayout = itemView.findViewById(R.id.main_layout);
        }
    }
}
