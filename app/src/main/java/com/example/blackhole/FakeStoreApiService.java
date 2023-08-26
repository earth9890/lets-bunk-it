package com.example.blackhole;

import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;

public interface FakeStoreApiService {

    @GET("products")
    Call<List<Item>> getItems();
}
