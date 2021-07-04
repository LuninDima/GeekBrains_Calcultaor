package ru.moondi.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.switchmaterial.SwitchMaterial;

import java.util.Locale;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, Constants {

    private Button buttonClear;
    private Button buttonPlus;
    private Button buttonEqually;
    private Button buttonMultiplay;
    private Button buttonMinus;
    private Button buttonDivision;
    private Button buttonOne;
    private Button buttonTwo;
    private Button buttonThree;
    private Button buttonFour;
    private Button buttonFive;
    private Button buttonSix;
    private Button buttonSeven;
    private Button buttonEight;
    private Button buttonNine;
    private Button buttonZero;
    private Button buttonStartActivitySettings;
    private TextView editTextScoreBoard;
    private SwitchMaterial switchMaterialButtonThemes;
    private int buffer = 0;
    private char operation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(convertCodeToStyle(getAppTheme()));
        setContentView(R.layout.activity_main);
        initView();
        initOnclickListener();
    }

    private void initView() {
        buttonClear = findViewById(R.id.button_clear);
        buttonPlus = findViewById(R.id.button_plus);
        buttonEqually = findViewById(R.id.button_equally);
        buttonMultiplay = findViewById(R.id.button_multiply);
        buttonMinus = findViewById(R.id.button_minus);
        buttonDivision = findViewById(R.id.button_division);
        buttonOne = findViewById(R.id.button1);
        buttonTwo = findViewById(R.id.button2);
        buttonThree = findViewById(R.id.button3);
        buttonFour = findViewById(R.id.button4);
        buttonFive = findViewById(R.id.button5);
        buttonSix = findViewById(R.id.button6);
        buttonSeven = findViewById(R.id.button7);
        buttonEight = findViewById(R.id.button8);
        buttonNine = findViewById(R.id.button9);
        buttonZero = findViewById(R.id.button0);
        buttonStartActivitySettings = findViewById(R.id.button_Start_Activity_Settings);
        editTextScoreBoard = findViewById(R.id.editTextScoreBoard);
        switchMaterialButtonThemes = findViewById(R.id.switch_Button_Themes);
    }

    private void initOnclickListener() {
        buttonOne.setOnClickListener(this);
        buttonTwo.setOnClickListener(this);
        buttonThree.setOnClickListener(this);
        buttonFour.setOnClickListener(this);
        buttonFive.setOnClickListener(this);
        buttonSix.setOnClickListener(this);
        buttonSeven.setOnClickListener(this);
        buttonEight.setOnClickListener(this);
        buttonNine.setOnClickListener(this);
        buttonZero.setOnClickListener(this);
        buttonMinus.setOnClickListener(this);
        buttonPlus.setOnClickListener(this);
        buttonMultiplay.setOnClickListener(this);
        buttonDivision.setOnClickListener(this);
        buttonClear.setOnClickListener(this);
        buttonEqually.setOnClickListener(this);
        buttonStartActivitySettings.setOnClickListener(this);
        switchMaterialButtonThemes.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Button b = (Button) v;
        switch (v.getId()) {
            case R.id.button0:
            case R.id.button1:
            case R.id.button2:
            case R.id.button3:
            case R.id.button4:
            case R.id.button5:
            case R.id.button6:
            case R.id.button7:
            case R.id.button8:
            case R.id.button9:
                editTextScoreBoard.setText(editTextScoreBoard.getText().toString() + b.getText().toString());
                break;
            case R.id.button_plus:
            case R.id.button_multiply:
            case R.id.button_minus:
            case R.id.button_division:
                operation(v);
                break;
            case R.id.button_equally:
                operationEqually();
                break;
            case R.id.button_clear:
                editTextScoreBoard.setText("0");
                buffer = 0;
            break;
            case R.id.switch_Button_Themes:
                switchThemes();
                break;
            case R.id.button_Start_Activity_Settings:
                startActivitySettings();

                break;
        }
    }

    private void startActivitySettings() {
        Intent intent = new Intent(this, SettingsActivity.class);
            intent.putExtra(Constants.INTENT_KEY, "настройки");
            startActivityForResult(intent, REQUEST_CODE_SETTING_ACTIVITY);
        }
protected void onActivityResult(int requestCode, int resultCode, Intent data){
if(requestCode != REQUEST_CODE_SETTING_ACTIVITY){
    super.onActivityResult(requestCode, resultCode, data);
    return;
}
if(resultCode == RESULT_OK){
    recreate();
}
}

    private  int getAppTheme(){
        SharedPreferences sharedPreferences = getSharedPreferences(KEY_PREFERENCE, MODE_PRIVATE);
        return sharedPreferences.getInt(APP_THEME, DEFAULT_THEME);

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
    private void switchThemes() {
        if (switchMaterialButtonThemes.isChecked()) {
            Utils.changeToTheme(this, Utils.THEME_DARK);
        } else {
            Utils.changeToTheme(this, Utils.THEME_WHITE);
        }

    }

    public void operation(View v) {
        Button b = (Button) v;
        buffer = Integer.parseInt(editTextScoreBoard.getText().toString());
        operation = b.getText().charAt(0);
        Log.d("operation", String.valueOf(operation));
        editTextScoreBoard.setText("");
    }

    public void operationEqually() {
        switch (operation) {
            case '+':
                buffer += Integer.parseInt(editTextScoreBoard.getText().toString());
                editTextScoreBoard.setText(String.valueOf(buffer));
                break;
            case '-':
                buffer -= Integer.parseInt(editTextScoreBoard.getText().toString());
                editTextScoreBoard.setText(String.valueOf(buffer));
                break;
            case '*':
                buffer *= Integer.parseInt(editTextScoreBoard.getText().toString());
                editTextScoreBoard.setText(String.valueOf(buffer));
                break;
            case '/':
                if (Integer.parseInt(editTextScoreBoard.getText().toString()) != 0) {
                    buffer /= Integer.parseInt(editTextScoreBoard.getText().toString());
                    editTextScoreBoard.setText(String.valueOf(buffer));
                } else {
                    Toast.makeText(this, "Делить на ноль нельзя", Toast.LENGTH_LONG).show();
                    editTextScoreBoard.setText("0");
                    buffer = 0;
                }

                break;
        }
    }
}