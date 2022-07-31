package com.george.vkode.ui.viewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.george.vkode.network.model.newsfeed.get.NewsfeedResponse;
import com.george.vkode.network.repository.NewsfeedRepository;

public class NewsfeedViewModel extends AndroidViewModel {

    NewsfeedRepository repository;

    public NewsfeedViewModel(@NonNull Application application, String token) {
        super(application);
        repository = new NewsfeedRepository(token);
    }

    public MutableLiveData<NewsfeedResponse> getNewsfeed(String filters, String startFrom) {
        return repository.getNewsfeed(filters, startFrom);
    }

}
