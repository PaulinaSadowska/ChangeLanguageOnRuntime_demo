package com.nekodev.paulina.sadowska.changelanguageonruntime_demo;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import java.util.Locale;

/**
 * Created by Paulina Sadowska on 09.04.16.
 */
public class MainActivity extends AppCompatActivity {

    Button changeLanguageButtonPL;
    Button changeLanguageButtonEN;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        changeLanguageButtonPL = (Button) findViewById(R.id.change_language_button_PL);
        changeLanguageButtonPL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeLanguage("pl");
            }
        });


        changeLanguageButtonEN = (Button) findViewById(R.id.change_language_button_EN);
        changeLanguageButtonEN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeLanguage("en_US");
            }
        });


    }

    private void changeLanguage(String languageCode) {

        Locale locale = new Locale(languageCode);
        Locale.setDefault(locale);

        Configuration config = new Configuration();
        config.locale = locale;
        getApplicationContext().getResources().updateConfiguration(config, null);
        Intent refresh = new Intent(this, MainActivity.class);
        startActivity(refresh);
        finish();

    }
}
