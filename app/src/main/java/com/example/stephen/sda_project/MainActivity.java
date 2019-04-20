package com.example.stephen.sda_project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.view.View.OnClickListener;
import android.view.View;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final Button medDevice = findViewById(R.id.button);

        medDevice.setOnClickListener(new OnClickListener() {

            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, deviceDetails.class);
                startActivity(intent);
            }

        });

    }
}


