package com.example.lab3;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.media.Image;
import android.os.Bundle;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Drawable img1 = getResources().getDrawable(R.drawable.first);
        ImageView imgView1;
        imgView1 = findViewById(R.id.imageView);
        imgView1.setImageDrawable(img1);

        Drawable img2 = getResources().getDrawable(R.drawable.second);
        ImageView imgView2;
        imgView2 = findViewById(R.id.imageView2);
        imgView2.setImageDrawable(img2);
    }
}
