package ru.moondi.myapplication;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Utils extends AppCompatActivity implements Constants
{

    public static int convertCodeToStyle(int codeStyle) {
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

    private int getAppTheme(){
        SharedPreferences sharedPreferences = getSharedPreferences(KEY_PREFERENCE, MODE_PRIVATE);
        return sharedPreferences.getInt(APP_THEME, DEFAULT_THEME);
    }
}
