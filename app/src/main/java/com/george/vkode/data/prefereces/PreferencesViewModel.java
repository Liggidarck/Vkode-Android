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

    public void saveCode(String code) {
        preferencesRepository.saveCode(code);
    }

    public String getCode() {
        return preferencesRepository.getCode();
    }

    public void deleteToken() {
        preferencesRepository.deleteToken();
    }

    public void saveUserId(int userId) {
        preferencesRepository.saveUserId(userId);
    }

    public int getUserId() {
        return preferencesRepository.getUserId();
    }

}
