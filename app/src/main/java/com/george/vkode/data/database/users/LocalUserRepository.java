package com.george.vkode.data.database.users;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class LocalUserRepository {
    private final UsersDao usersDao;
    private final LiveData<List<LocalUser>> allUsers;
    final ExecutorService service = Executors.newSingleThreadExecutor();

    public LocalUserRepository(Application application) {
        UsersDatabase database = UsersDatabase.getInstance(application);
        usersDao = database.usersDao();
        allUsers = usersDao.getAllUsers();
    }

    public void insert(LocalUser user) {
        service.execute(() -> usersDao.insert(user));
    }

    public void update(LocalUser user) {
        service.execute(() -> usersDao.update(user));
    }

    public void delete(LocalUser user) {
        service.execute(() -> usersDao.delete(user));
    }

    public LiveData<List<LocalUser>> getAllUsers() {
        return allUsers;
    }

}
