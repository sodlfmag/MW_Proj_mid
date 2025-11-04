package com.example.helloandroid;

import android.graphics.Bitmap;

public class PostData {
    private Bitmap bitmap;
    private String title;
    private String text;
    private String imageUrl;
    
    public PostData(Bitmap bitmap, String title, String text, String imageUrl) {
        this.bitmap = bitmap;
        this.title = title;
        this.text = text;
        this.imageUrl = imageUrl;
    }
    
    public Bitmap getBitmap() {
        return bitmap;
    }
    
    public String getTitle() {
        return title;
    }
    
    public String getText() {
        return text;
    }
    
    public String getImageUrl() {
        return imageUrl;
    }
}


