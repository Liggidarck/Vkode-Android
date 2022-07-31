package com.george.vkode.ui.viewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.george.vkode.data.database.users.LocalUser;
import com.george.vkode.data.database.users.LocalUserRepository;

import java.util.List;

public class LocalUserViewModel extends AndroidViewModel {

    private final LocalUserRepository repository;
    private final LiveData<List<LocalUser>> allUsers;

    public LocalUserViewModel(@NonNull Application application) {
        super(application);
        repository = new LocalUserRepository(application);
        allUsers = repository.getAllUsers();
    }

    public void insert(LocalUser user) {
        repository.insert(user);
    }

    public void update(LocalUser user) {
        repository.update(user);
    }

    public void delete(LocalUser user) {
        repository.delete(user);
    }

    public LiveData<List<LocalUser>> getAllUsers() {
        return allUsers;
    }

}
