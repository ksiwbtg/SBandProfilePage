package com.example.ahmaadyunus.navigationdrawmultipleactivitytest;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.io.FileDescriptor;
import java.io.IOException;

public class ProfileActivity extends MainActivity {
    private static final int RESULT_PICK_IMAGINE = 1000;
    private ImageView imageView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
             View contentView = getLayoutInflater().inflate(R.layout.activity_profile,null);
             drawerLayout.addView(contentView,1);
        imageView = (ImageView) findViewById(R.id.imageView11);


        findViewById(R.id.button2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_OPEN_DOCUMENT);
                intent.addCategory(Intent.CATEGORY_OPENABLE);
                intent.setType("image/*");
                startActivityForResult(intent, RESULT_PICK_IMAGINE);
            }
        });
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent resultData) {
        if (requestCode == RESULT_PICK_IMAGINE && resultCode == RESULT_OK) {
            Uri uri;
            if (resultData != null) {
                uri = resultData.getData();

                try {
                    Bitmap bmp = getBitmapFromUri(uri);
                    imageView.setImageBitmap(bmp);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private Bitmap getBitmapFromUri(Uri uri) throws IOException {
        ParcelFileDescriptor parcelFileDescriptor =
                getContentResolver().openFileDescriptor(uri, "r");
        FileDescriptor fileDescriptor = parcelFileDescriptor.getFileDescriptor();
        Bitmap image = BitmapFactory.decodeFileDescriptor(fileDescriptor);
        parcelFileDescriptor.close();
        return image;
    }


}
