package com.george.vkode.ui.viewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.george.vkode.network.model.account.info.InfoResponse;
import com.george.vkode.network.model.account.profileInfo.ProfileInfoResponse;
import com.george.vkode.network.model.user.get.UserPhotoResponse;
import com.george.vkode.network.model.user.getFollowers.FollowersResponse;
import com.george.vkode.network.repository.AccountRepository;

public class AccountViewModel extends AndroidViewModel {

    AccountRepository repository;

    public AccountViewModel(@NonNull Application application, String token) {
        super(application);
        repository = new AccountRepository(token);
    }

    public MutableLiveData<ProfileInfoResponse> getProfileInfo() {
        return repository.getProfileInfo();
    }

    public MutableLiveData<UserPhotoResponse> getUserPhoto() {
        return repository.getProfilePhotos();
    }

    public MutableLiveData<FollowersResponse> getFollowers(String fields) {
        return repository.getFollowers(fields);
    }

    public MutableLiveData<InfoResponse> getInfo() {
        return repository.getInfo();
    }

}
