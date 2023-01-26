package com.example.onboarding;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.example.onboarding.fragment.HomeFragment;
import com.example.onboarding.fragment.LaporFragment;
import com.example.onboarding.fragment.ProfilFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class FragmentActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigation;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);

        bottomNavigation = findViewById(R.id.bottom_navigation);


        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new HomeFragment()). commit();
        bottomNavigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment selectedFragment = null;

                switch (item.getItemId()){
                    case R.id.nav_home:
                        selectedFragment = new HomeFragment();
                        break;
                    case R.id.nav_lapor:
                        selectedFragment = new LaporFragment();
                        break;
                    case R.id.nav_profil:
                        selectedFragment = new ProfilFragment();
                        break;


                }

                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, selectedFragment). commit();
                return true;
            }


        });

    }


}