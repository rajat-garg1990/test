package com.example.testapplication;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private static final int REQUEST_CAMERA_IMAGE = 100;
    ImageView imageView;
    TextView textView;
    Uri photoURI;
    String imageFilePath;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = findViewById(R.id.imageI);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView = findViewById(R.id.textI);
                Intent pictureIntent = new Intent(
                        MediaStore.ACTION_IMAGE_CAPTURE);
                if (pictureIntent.resolveActivity(getPackageManager()) != null) {
                    //Create a file to store the image
                    File photoFile = null;
                    photoFile = createImageFile();
                    if (photoFile != null) {
                        photoURI = FileProvider.getUriForFile(MainActivity.this, "com.example.testapplication.provider", photoFile);
                        pictureIntent.putExtra(MediaStore.EXTRA_OUTPUT,
                                photoURI);
                        startActivityForResult(pictureIntent,
                                REQUEST_CAMERA_IMAGE);
                    }
                }
            }
        });
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable @org.jetbrains.annotations.Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_CAMERA_IMAGE) {
            if (resultCode == RESULT_OK) {

                //File object of camera image
                File file = new File(Environment.getExternalStorageDirectory(), "MyPhoto.jpg");

                //Uri of camera image
               // Uri uri = FileProvider.getUriForFile(this, this.getApplicationContext().getPackageName() + ".provider", file);
                imageView.setImageURI(photoURI);
                Log.d("photoURI", String.valueOf(photoURI));
                textView.setText(photoURI.toString());
            }
        }
    }

    private File createImageFile() {
        String timeStamp =
                new SimpleDateFormat("yyyyMMdd_HHmmss",
                        Locale.getDefault()).format(new Date());
        String imageFileName = "IMG_" + timeStamp + "_";
        File storageDir =
                getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        File image = null;
        try {
            image = File.createTempFile(
                    imageFileName,  /* prefix */
                    ".jpg",         /* suffix */
                    storageDir      /* directory */
            );
        } catch (IOException e) {
            e.printStackTrace();
        }

        imageFilePath = image.getAbsolutePath();
        Log.d("imageFilePath",imageFilePath);
        return image;
    }
}


