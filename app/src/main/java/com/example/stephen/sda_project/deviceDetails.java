package com.example.stephen.sda_project;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Button;
import android.content.Intent;

import java.lang.reflect.Array;


public class deviceDetails extends AppCompatActivity {
    private static final int cameraCode = 20;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.device_details);

        Spinner jobSpinner = findViewById(R.id.jobType);
        ArrayAdapter<CharSequence> spinJobAdapter = ArrayAdapter.createFromResource(this, R.array.job_list,
                R.layout.support_simple_spinner_dropdown_item);
        spinJobAdapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        jobSpinner.setAdapter(spinJobAdapter);


        Spinner areaSpinner = findViewById(R.id.areaSpin);
        ArrayAdapter<CharSequence> spinAreaAdapter = ArrayAdapter.createFromResource(this, R.array.area_list,
                R.layout.support_simple_spinner_dropdown_item);
        spinAreaAdapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        areaSpinner.setAdapter(spinAreaAdapter);


        final Button photoDevice = findViewById(R.id.photo_button);

        photoDevice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(cameraIntent, cameraCode);
            }


        });

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        if(requestCode==cameraCode && resultCode==RESULT_OK){
            Bundle extras = data.getExtras();
            Bitmap deviceBitmap = (Bitmap) extras.get("data");

            ImageView imageCamera = findViewById(R.id.imagePhoto);
            imageCamera.setImageBitmap(deviceBitmap);


        }

    }
}
