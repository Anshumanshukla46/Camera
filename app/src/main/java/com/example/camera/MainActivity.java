package com.example.camera;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private ImageView img;
    private Button click;
    private static final int CAMERA_PERMISSION = 1888; // for intent request code

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        img = findViewById(R.id.img);
        click = findViewById(R.id.click);

//      Camera can be opened by two methods : one is through api other one is intent
//      we are using 'intent' method

        click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(i, CAMERA_PERMISSION);

            }
        });
    }

//    this will get the image from camera and stored in form of 'data'

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == CAMERA_PERMISSION) {
            Bitmap bitMapPhoto = (Bitmap) data.getExtras().get("data");
//          Bitmap is also a type of image and even it can also be used in place of image

            img.setImageBitmap(bitMapPhoto);
        }
    }
}