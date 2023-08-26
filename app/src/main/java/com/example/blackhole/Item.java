package com.example.blackhole;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;

public class Item implements Parcelable {
    private int id;
    private static int cnt = 0;
    private String title,category,description;
    private double price;
    private String image;

    protected Item(Parcel in) {
        id = in.readInt();
        title = in.readString();
        price = in.readDouble();
        category = in.readString();
        description = in.readString();
        image = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(title);
        dest.writeDouble(price);
        dest.writeString(category);
        dest.writeString(description);
        dest.writeString(image);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Item> CREATOR = new Creator<Item>() {
        @Override
        public Item createFromParcel(Parcel in) {
            return new Item(in);
        }

        @Override
        public Item[] newArray(int size) {
            return new Item[size];
        }
    };

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public double getPrice() {
        return price;
    }

    public String getImageUrl() {
        Log.d("Item", "data " + description);

        if (image == null || image.isEmpty()) {
            // Handle missing or null image URL
//            Log.d("Item", "Missing or null image URL for item: " + title);
////            if(cnt>2)
//            {
            image = "https://www.samsonite.in/dw/image/v2/AAWQ_PRD/on/demandware.static/-/Sites-Samsonite/default/dw0dbb2ae7/images/esquire-lth-portfolio-in/hi-res/145914_1221_hi-res_FRONT34_1.jpg?sw=500&sh=750";// Replace with a valid URL

//            }
//           if(cnt < 2) {
//                Log.d("Image", "img : " + strAr1[cnt]);
//
//                imageUrl = strAr1[cnt++];
//            }
//        }
        }
        return image;
    }
    public String getDescription() {
        return description;
    }

    // Add getter and setter methods for other fields if needed
}
