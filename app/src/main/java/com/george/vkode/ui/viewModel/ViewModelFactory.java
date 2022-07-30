package com.george.vkode.ui.viewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

public class ViewModelFactory implements ViewModelProvider.Factory {

    private final Application application;
    private final String token;

    public ViewModelFactory(Application application, String token) {
        this.application = application;
        this.token = token;
    }

    @SuppressWarnings("unchecked")
    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) new AccountViewModel(application, token);
    }

}
