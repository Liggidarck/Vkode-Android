package com.george.vkode.ui;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.splashscreen.SplashScreen;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import com.george.vkode.R;
import com.george.vkode.data.database.users.LocalUser;
import com.george.vkode.data.prefereces.PreferencesViewModel;
import com.george.vkode.databinding.ActivityMainBinding;
import com.george.vkode.ui.login.LoginKotlinActivity;
import com.george.vkode.ui.viewModel.AccountViewModel;
import com.george.vkode.ui.viewModel.LocalUserViewModel;
import com.george.vkode.ui.viewModel.ViewModelFactory;
import com.vk.api.sdk.VK;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = MainActivity.class.getSimpleName();

    ActivityMainBinding binding;

    private PreferencesViewModel preferencesViewModel;
    private LocalUserViewModel localUserViewModel;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SplashScreen.installSplashScreen(this);

        preferencesViewModel = new ViewModelProvider(this).get(PreferencesViewModel.class);

        if (!VK.isLoggedIn()) {
            finish();
            startActivity(new Intent(MainActivity.this, LoginKotlinActivity.class));
        }

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        NavController navController = Navigation.findNavController(this, R.id.navHostFragmentMain);
        NavigationUI.setupWithNavController(binding.navView, navController);

        getUserData();
    }


    void getUserData() {
        localUserViewModel = new ViewModelProvider(this)
                .get(LocalUserViewModel.class);

        localUserViewModel.getAllUsers().observe(this, localUsers -> {
            Log.d(TAG, "getUserData: " + localUsers.size());
            if (localUsers.size() == 0) {
                Log.d(TAG, "getUserData: SAVE " + localUsers.size());
                saveUser();
            }
        });
    }

    private void saveUser() {
        progressDialog = new ProgressDialog(this);
        progressDialog.setTitle("Загрузка...");
        progressDialog.show();

        AccountViewModel accountViewModel = new ViewModelProvider(
                this,
                new ViewModelFactory(this.getApplication(), preferencesViewModel.getToken())
        ).get(AccountViewModel.class);

        accountViewModel.getProfileInfo().observe(this, profileInfoResponse -> {
            int id = profileInfoResponse.getResponse().getId();
            String firstName = profileInfoResponse.getResponse().getFirst_name();
            String lastName = profileInfoResponse.getResponse().getLast_name();
            String maidenName = profileInfoResponse.getResponse().getMaiden_name();
            String screenName = profileInfoResponse.getResponse().getScreen_name();
            int sex = profileInfoResponse.getResponse().getSex();
            int relation = profileInfoResponse.getResponse().getRelation();
            String birthday = profileInfoResponse.getResponse().getBdate();
            int birthdayVisibility = profileInfoResponse.getResponse().getBdate_visibility();
            String homeTown = profileInfoResponse.getResponse().getHome_town();
            String status = profileInfoResponse.getResponse().getStatus();
            String phone = profileInfoResponse.getResponse().getPhone();

            LocalUser user = new LocalUser(id, firstName, lastName, maidenName,
                    screenName, sex, relation, birthday, birthdayVisibility,
                    homeTown, status, phone);

            localUserViewModel.insert(user);

            progressDialog.dismiss();
        });
    }
}