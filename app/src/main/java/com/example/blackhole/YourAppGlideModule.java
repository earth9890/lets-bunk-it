package com.example.blackhole;

import android.content.Context;

import com.bumptech.glide.annotation.GlideModule;
import com.bumptech.glide.module.AppGlideModule;
import com.bumptech.glide.GlideBuilder;
import com.bumptech.glide.load.engine.cache.InternalCacheDiskCacheFactory;

@GlideModule
public class YourAppGlideModule extends AppGlideModule {

    @Override
    public void applyOptions(Context context, GlideBuilder builder) {
        // Apply custom options to Glide here
        int cacheSizeBytes = 1024 * 1024 * 100; // 100 MB cache
        builder.setDiskCache(new InternalCacheDiskCacheFactory(context, cacheSizeBytes));
    }

    // You can also override other methods if needed
}
