package com.george.vkode.data.prefereces;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

public class PreferencesViewModel extends AndroidViewModel {

    PreferencesRepository preferencesRepository;

    public PreferencesViewModel(@NonNull Application application) {
        super(application);
        preferencesRepository = new PreferencesRepository(application);
    }

    public void saveToken(String token) {
        preferencesRepository.saveToken(token);
    }

    public String getToken() {
        return preferencesRepository.getToken();
    }

}
