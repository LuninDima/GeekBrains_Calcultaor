package ru.moondi.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SettingsActivity extends AppCompatActivity implements View.OnClickListener, Constants {

    private TextView textViewSettings;
    private String textGetIntent;
    private RadioButton rbuttonLightTheme;
    private RadioButton rbuttonDarkTheme;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        Utils.onActivityCreateSetTheme(this);
        textViewSettings = (TextView) findViewById(R.id.textView_Settings);
        rbuttonLightTheme = findViewById(R.id.rbutton_Light_Theme);
        rbuttonDarkTheme = findViewById(R.id.rbutton_Dark_Theme);
        rbuttonDarkTheme.setOnClickListener(this);
        rbuttonLightTheme.setOnClickListener(this);



    }

    @Override
    public void onClick(View v) {
        RadioButton rb = (RadioButton) v;
        switch (rb.getId()){
            case R.id.rbutton_Light_Theme:
                Utils.changeToTheme(this, Utils.THEME_WHITE);
                break;
            case R.id.rbutton_Dark_Theme:
                Utils.changeToTheme(this,Utils.THEME_DARK);
                break;
        }
    }
}