package com.george.vkode.ui;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import com.george.vkode.R;
import com.george.vkode.data.prefereces.PreferencesViewModel;
import com.george.vkode.databinding.ActivityMainBinding;
import com.george.vkode.ui.login.LoginActivity;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        PreferencesViewModel preferencesViewModel =
                new ViewModelProvider(this).get(PreferencesViewModel.class);

        String token = preferencesViewModel.getToken();
        if (token == null)
            startActivity(new Intent(this, LoginActivity.class));

        NavController navController = Navigation.findNavController(this, R.id.navHostFragmentMain);
        NavigationUI.setupWithNavController(binding.navView, navController);
    }
}