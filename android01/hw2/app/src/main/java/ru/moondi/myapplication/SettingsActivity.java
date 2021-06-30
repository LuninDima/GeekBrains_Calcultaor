package ru.moondi.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SettingsActivity extends AppCompatActivity implements View.OnClickListener, Constants {

    private TextView textViewSettings;
    private String textGetIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        textViewSettings = (TextView) findViewById(R.id.textView_Settings);
        textGetIntent = getIntent().getExtras().getString(Constants.INTENT_KEY);
        textViewSettings.setText(textGetIntent);


    }

    @Override
    public void onClick(View v) {

    }
}