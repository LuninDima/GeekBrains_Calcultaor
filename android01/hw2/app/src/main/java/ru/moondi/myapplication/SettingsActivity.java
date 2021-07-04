package ru.moondi.myapplication;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SettingsActivity extends AppCompatActivity implements Constants {

    private TextView textViewSettings;
    private String textGetIntent;
    private RadioButton rbuttonLightTheme;
    private RadioButton rbuttonDarkTheme;
    private RadioButton rbuttonAncientRusTheme;
    private RadioButton rbuttonDefaultTheme;
    private Button buttonFinishSettings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(convertCodeToStyle(getAppTheme()));
        setContentView(R.layout.activity_settings);
        textViewSettings = (TextView) findViewById(R.id.textView_Settings);
        rbuttonAncientRusTheme = findViewById(R.id.rbutton_Anciet_Rus_Theme);
        rbuttonDefaultTheme = findViewById(R.id.rbutton_Default_Theme);
        buttonFinishSettings = findViewById(R.id.button_Finish_Setthings);
        initChangerTheme();
        initFinish();


    }

    private void initFinish() {
        buttonFinishSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private int convertCodeToStyle(int codeStyle) {
        switch (codeStyle){
            case LIGHT_THEME:
                return R.style.AppThemeLight;
            case DARK_THEME:
                return R.style.AppThemeDark;
            case ANCIENTRUS_THEME:
                return R.style.AncientRus;
            default: DEFAULT_THEME:
                return R.style.Theme_MyApplicationLight;
        }
    }

    private void initChangerTheme() {
        initButton(findViewById(R.id.rbutton_Light_Theme), LIGHT_THEME);
        initButton(findViewById(R.id.rbutton_Dark_Theme),DARK_THEME);
        initButton(findViewById(R.id.rbutton_Anciet_Rus_Theme),ANCIENTRUS_THEME);
        initButton(findViewById(R.id.rbutton_Default_Theme),DEFAULT_THEME);
    }

    private void initButton(RadioButton button, int codeStyle) {
        button.setOnClickListener(v -> {
            setAppTheme(codeStyle);
            recreate();
        });
    }

    private void setAppTheme(int codeStyle) {
        SharedPreferences sharedPreferences = getSharedPreferences(KEY_PREFERENCE, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(APP_THEME, codeStyle);
        editor.apply();
    }
    private  int getAppTheme(){
        SharedPreferences sharedPreferences = getSharedPreferences(KEY_PREFERENCE, MODE_PRIVATE);
        return sharedPreferences.getInt(APP_THEME, DEFAULT_THEME);

    }


   /* @Override
    public void onClick(View v) {
        if (v instanceof RadioButton) {
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
                case R.id.button_Finish_Setthings:
                    finish();
            }
        } else if (v instanceof Button) {
            Button b = (Button) v;
            switch (b.getId()) {
                case R.id.button_Finish_Setthings:
                    finish();
                    break;
            }
        }
    }*/


}