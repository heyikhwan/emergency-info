package com.ikhwan.emergencyinfo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.emergency_menu);
    }

    public void clickRS(View view) {
        // gambar rs klik
        Intent i = new Intent(this, RS.class);
        startActivity(i);
    }
}