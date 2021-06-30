package ru.moondi.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SettingsActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView textSettings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        textSettings = (TextView) findViewById(R.id.textView_Settings);
        Intent intent = new Intent();


    }

    @Override
    public void onClick(View v) {

    }
}