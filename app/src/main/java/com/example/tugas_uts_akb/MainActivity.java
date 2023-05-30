package com.example.tugas_uts_akb;
//10120049 IF2 Mochammad Gymnastiar

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().hide();
        bottomNavigationView = findViewById(R.id.bottomNavigationView);

        final ProfileFragment profileFragment = new ProfileFragment();
        final NoteFragment noteFragment = new NoteFragment();
        final InformationFragment informationFragment = new InformationFragment();

        loadFragment(profileFragment);

        bottomNavigationView.setOnNavigationItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.menu_profile:
                    loadFragment(profileFragment);
                    return true;
                case R.id.menu_note:
                    loadFragment(noteFragment);
                    return true;
                case R.id.menu_information:
                    loadFragment(informationFragment);
                    return true;
            }
            return false;
        });
    }

    private void loadFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragmentContainer, fragment);
        fragmentTransaction.commit();
    }
}