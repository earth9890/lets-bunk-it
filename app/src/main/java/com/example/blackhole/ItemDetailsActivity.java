package com.example.blackhole;



import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.Locale;

public class ItemDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_details);

        ImageView imageView = findViewById(R.id.poster_image);
        TextView buyNow = findViewById(R.id.buynow);
        TextView title_tv = findViewById(R.id.mTitle);
        TextView description = findViewById(R.id.description);
        TextView price = findViewById(R.id.price);

        Bundle bundle = getIntent().getExtras();

        String mTitle = "Title: " + bundle.getString("title");
        String mPoster =  bundle.getString("image");
        String mDescription = "Description: "+bundle.getString("description");
        String mPrice = "Price: " + bundle.getString("price");
        Glide.with(this).load(mPoster).into(imageView);
        title_tv.setText(mTitle);
        description.setText(mDescription);
        price.setText(mPrice);
        String tt = bundle.getString("title");
        String img = bundle.getString("image");
        String pr = bundle.getString("price");
        buyNow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ItemDetailsActivity.this, MainActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("title", tt);
                bundle.putString("price", pr);
                bundle.putString("image", img);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });


    }
}