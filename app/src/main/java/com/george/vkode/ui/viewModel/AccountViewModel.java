package com.george.vkode.ui.viewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.george.vkode.network.model.account.info.InfoResponse;
import com.george.vkode.network.model.account.profileInfo.ProfileInfoResponse;
import com.george.vkode.network.model.common.user.User;
import com.george.vkode.network.model.common.user.UserPhoto;
import com.george.vkode.network.model.common.user.UserPhotoResponse;
import com.george.vkode.network.repository.AccountRepository;

public class AccountViewModel extends AndroidViewModel {

    AccountRepository accountRepository;

    public AccountViewModel(@NonNull Application application, String token) {
        super(application);
        accountRepository = new AccountRepository(token);
    }

    public MutableLiveData<ProfileInfoResponse> getProfileInfo() {
        return accountRepository.getProfileInfo();
    }

    public MutableLiveData<UserPhotoResponse> getUserPhoto() {
        return accountRepository.getProfilePhotos();
    }

    public MutableLiveData<InfoResponse> getInfo() {
        return accountRepository.getInfo();
    }

}
