package ru.moondi.myapplication;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class SettingsActivity extends AppCompatActivity implements Constants {


    private TextView textViewSettings;
    private Button buttonFinishSettings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setTheme(Utils.convertCodeToStyle(getAppTheme()));
        setContentView(R.layout.activity_settings);
        textViewSettings = (TextView) findViewById(R.id.textView_Settings);
        buttonFinishSettings = (Button) findViewById(R.id.button_Finish_Setthings);
        initChangerTheme();
        initFinish();
    }

    private void initFinish() {
        buttonFinishSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(RESULT_OK);
                finish();
            }
        });
    }

    private void initChangerTheme() {
        initButton(findViewById(R.id.rbutton_Light_Theme), LIGHT_THEME);
        initButton(findViewById(R.id.rbutton_Dark_Theme), DARK_THEME);
        initButton(findViewById(R.id.rbutton_Anciet_Rus_Theme), ANCIENTRUS_THEME);
        initButton(findViewById(R.id.rbutton_Default_Theme), DEFAULT_THEME);
    }

    private void initButton(RadioButton button, int codeStyle) {
        button.setOnClickListener(v -> {
            setAppTheme(codeStyle);
            recreate();
        });
    }
    public void setAppTheme(int codeStyle) {
        SharedPreferences sharedPreferences = getSharedPreferences(KEY_PREFERENCE, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(APP_THEME, codeStyle);
        editor.apply();
    }
    private int getAppTheme(){
        SharedPreferences sharedPreferences = getSharedPreferences(KEY_PREFERENCE, MODE_PRIVATE);
        return sharedPreferences.getInt(APP_THEME, DEFAULT_THEME);
    }

}