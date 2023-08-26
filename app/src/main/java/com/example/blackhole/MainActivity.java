package com.example.blackhole;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

public class MainActivity extends AppCompatActivity {

    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Retrieve the data from the intent's extras
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            String title = bundle.getString("title");
            String price = bundle.getString("price");

            // Inflate the bought item layout
            LinearLayout boughtItemLayout = findViewById(R.id.boughtItemLayout);
            View boughtItemView = getLayoutInflater().inflate(R.layout.layout_bought_item, null);
            boughtItemLayout.addView(boughtItemView);

            // Set title and price in the inflated layout
            TextView boughtItemTitle = boughtItemView.findViewById(R.id.boughtItemTitle);
            TextView boughtItemPrice = boughtItemView.findViewById(R.id.boughtItemPrice);

            boughtItemTitle.setText(title);
            boughtItemPrice.setText(price);

            // Play sound effect
            mediaPlayer = MediaPlayer.create(this, R.raw.payment_success);
            mediaPlayer.start();

            // Show animation
            ImageView boughtItemAnimation = boughtItemView.findViewById(R.id.boughtItemAnimation);
            boughtItemAnimation.setVisibility(View.VISIBLE);

            // Load GIF animation using Glide library
            Glide.with(this)
                    .asGif()
                    .load(R.drawable.success) // Make sure you have success.gif in your drawable folder
                    .into(boughtItemAnimation);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mediaPlayer != null) {
            mediaPlayer.release();
        }
    }
}
