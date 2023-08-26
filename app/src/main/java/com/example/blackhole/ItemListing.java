package com.example.blackhole;

import android.os.Bundle;
import android.content.Context;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ItemListing extends AppCompatActivity {
    private RecyclerView itemRecyclerView;

        ItemListAdapter itemListAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_itemlisting);

        itemRecyclerView = findViewById(R.id.itemRecyclerView);
        itemListAdapter = new ItemListAdapter();
        itemRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        itemRecyclerView.setAdapter(itemListAdapter);

        // Fetch item data from the API using Retrofit
        fetchItemsFromAPI();
    }

    private void fetchItemsFromAPI() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://fakestoreapi.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        FakeStoreApiService apiService = retrofit.create(FakeStoreApiService.class);
        Call<List<Item>> call = apiService.getItems();

        call.enqueue(new Callback<List<Item>>() {
            @Override
            public void onResponse(Call<List<Item>> call, Response<List<Item>> response) {
                if (response.isSuccessful()) {
                    List<Item> itemList = response.body();
                    if (itemList != null) {
                        itemListAdapter.setItems(itemList);
                    }
                } else {

                }
            }

            @Override
            public void onFailure(Call<List<Item>> call, Throwable t) {
                // Handle failure
            }
        });
    }
}