package com.example.mycardviewapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class ItemData extends AppCompatActivity {
    ImageView imageResult;
    TextView headerResult, descResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_data);

        imageResult = (ImageView) findViewById(R.id.imageResult);
        headerResult = (TextView) findViewById(R.id.headerResult);
        descResult = (TextView) findViewById(R.id.descResult);

        imageResult.setImageResource(getIntent().getIntExtra("imageFinal",0));
        headerResult.setText(getIntent().getStringExtra("headerFinal"));
        descResult.setText(getIntent().getStringExtra("descFinal"));
    }
}