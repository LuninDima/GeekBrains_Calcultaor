package ru.moondi.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SettingsActivity extends AppCompatActivity implements View.OnClickListener, Constants {

    private TextView textViewSettings;
    private String textGetIntent;
    private RadioButton rbuttonLightTheme;
    private RadioButton rbuttonDarkTheme;
    private RadioButton rbuttonAncientRusTheme;
    private RadioButton rbuttonDefaultTheme;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Utils.onActivityCreateSetTheme(this);
        setContentView(R.layout.activity_settings);
        textViewSettings = (TextView) findViewById(R.id.textView_Settings);
        rbuttonLightTheme = findViewById(R.id.rbutton_Light_Theme);
        rbuttonDarkTheme = findViewById(R.id.rbutton_Dark_Theme);
        rbuttonAncientRusTheme = findViewById(R.id.rbutton_Anciet_Rus_Theme);
        rbuttonDefaultTheme = findViewById(R.id.rbutton_Default_Theme);
        rbuttonDarkTheme.setOnClickListener(this);
        rbuttonLightTheme.setOnClickListener(this);
        rbuttonAncientRusTheme.setOnClickListener(this);
        rbuttonDefaultTheme.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        RadioButton rb = (RadioButton) v;
        switch (rb.getId()) {
            case R.id.rbutton_Light_Theme:
                Utils.changeToTheme(this, Utils.THEME_WHITE);
                recreate();
                break;
            case R.id.rbutton_Dark_Theme:
                Utils.changeToTheme(this, Utils.THEME_DARK);
                recreate();
                break;
            case R.id.rbutton_Anciet_Rus_Theme:
                Utils.changeToTheme(this, Utils.THEME_ANCIENT_RUS);
                break;
            case R.id.rbutton_Default_Theme:
                Utils.changeToTheme(this, Utils.THEME_DEFAULT);

                break;

        }
    }
}