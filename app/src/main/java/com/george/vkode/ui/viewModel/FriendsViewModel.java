package com.george.vkode.ui.viewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.george.vkode.network.model.friends.get.Friends;
import com.george.vkode.network.repository.FriendsRepository;

public class FriendsViewModel extends AndroidViewModel {

    FriendsRepository repository;

    public FriendsViewModel(@NonNull Application application, String token) {
        super(application);
        repository = new FriendsRepository(token);
    }

    public MutableLiveData<Friends> getUserFriends(String order, String fields) {
        return repository.getUserFriends(order, fields);
    }

}
