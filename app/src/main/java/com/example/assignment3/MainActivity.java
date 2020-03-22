package com.example.assignment3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences sharedPref = this.getPreferences(Context.MODE_PRIVATE);
        int checked = sharedPref.getInt("checked", 0);
        if (checked == 1) {
            Intent intent = new Intent(this, HomeActivity.class);
            startActivity(intent);
        }
        else {
            SharedPreferences.Editor editor = sharedPref.edit();
            editor.putInt("checked", 1);
            editor.commit();
        }
    }

    public void onAgreeClicked(View view) {
        Toast toast = Toast.makeText(getApplicationContext(), "Hey! You didn't read the terms and conditions! That's Illegal!", Toast.LENGTH_SHORT);
        toast.show();
        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);
    }
}
