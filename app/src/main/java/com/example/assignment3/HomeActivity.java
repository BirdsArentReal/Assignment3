package com.example.assignment3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class HomeActivity extends AppCompatActivity {

    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                    Fragment selectedFragment = null;
                    switch(menuItem.getItemId()){
                        case R.id.recordPage:
                            selectedFragment = new RecordingFragment();
                            break;

                        case R.id.dataPage:
                            selectedFragment = new DataFragment();
                            break;

                        case R.id.sendPage:
                            selectedFragment = new ExportFragment();
                            break;

                        default: break;
                    }

                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                            selectedFragment).commit();
                    return true;
                }
            };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        //Action bar
        Toolbar myToolbar = findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);

        //Bottom Navigation View
        BottomNavigationView botNav = findViewById(R.id.bottom_nav_view);
        botNav.setOnNavigationItemSelectedListener(navListener);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                new RecordingFragment()).commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater mi = getMenuInflater();
        mi.inflate(R.menu.menu_action_bar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()){
            case R.id.profilePic:
                ProfileDialog profileDialog = new ProfileDialog();

                profileDialog.show(getSupportFragmentManager(),"profile dialog");
                return true;

            case R.id.help:
                HelpDialog helpDialog = new HelpDialog();

                helpDialog.show(getSupportFragmentManager(),"help dialog");
                return true;

            default: break;
        }
        return super.onOptionsItemSelected(item);
    }


}
