package com.george.vkode.network.repository;

import static com.george.vkode.utils.Keys.API_VERSION;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;

import com.george.vkode.network.api.VkClient;
import com.george.vkode.network.api.methods.IAccount;
import com.george.vkode.network.api.methods.IUser;
import com.george.vkode.network.model.account.info.InfoResponse;
import com.george.vkode.network.model.account.profileInfo.ProfileInfoResponse;
import com.george.vkode.network.model.common.user.User;
import com.george.vkode.network.model.common.user.UserPhotoResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AccountRepository {

    IAccount account;
    IUser user;
    String token;

    public AccountRepository(String token) {
        account = VkClient.getVkClient().create(IAccount.class);
        user = VkClient.getVkClient().create(IUser.class);
        this.token = token;
    }

    public MutableLiveData<ProfileInfoResponse> getProfileInfo() {
        MutableLiveData<ProfileInfoResponse> profileInfo = new MutableLiveData<>();
        account.getProfileInfo(token, API_VERSION).enqueue(new Callback<ProfileInfoResponse>() {
            @Override
            public void onResponse(@NonNull Call<ProfileInfoResponse> call, @NonNull Response<ProfileInfoResponse> response) {
                profileInfo.setValue(response.body());
            }

            @Override
            public void onFailure(@NonNull Call<ProfileInfoResponse> call, @NonNull Throwable t) {
                profileInfo.postValue(null);
            }
        });

        return profileInfo;
    }


    public MutableLiveData<UserPhotoResponse> getProfilePhotos() {
        MutableLiveData<UserPhotoResponse> userPhoto = new MutableLiveData<>();
        user.getUser(token, "photo_100, photo_200, photo_200_orig, photo_400_orig, photo_50", API_VERSION)
                .enqueue(new Callback<UserPhotoResponse>() {
                    @Override
                    public void onResponse(@NonNull Call<UserPhotoResponse> call,
                                           @NonNull Response<UserPhotoResponse> response) {
                        userPhoto.setValue(response.body());
                    }

                    @Override
                    public void onFailure(@NonNull Call<UserPhotoResponse> call, @NonNull Throwable t) {
                        userPhoto.postValue(null);
                    }
                });

        return userPhoto;
    }

    public MutableLiveData<InfoResponse> getInfo() {
        MutableLiveData<InfoResponse> info = new MutableLiveData<>();
        account.getInfo(token, API_VERSION).enqueue(new Callback<InfoResponse>() {
            @Override
            public void onResponse(@NonNull Call<InfoResponse> call, @NonNull Response<InfoResponse> response) {
                info.setValue(response.body());
            }

            @Override
            public void onFailure(@NonNull Call<InfoResponse> call, @NonNull Throwable t) {
                info.postValue(null);
            }
        });

        return info;
    }

}
