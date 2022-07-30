package com.george.vkode.network.repository;

import static com.george.vkode.utils.Keys.API_VERSION;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;

import com.george.vkode.network.api.VkClient;
import com.george.vkode.network.api.methods.IAccount;
import com.george.vkode.network.model.account.info.InfoResponse;
import com.george.vkode.network.model.account.profileInfo.ProfileInfoResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AccountRepository {

    IAccount account;
    String token;

    public AccountRepository(String token) {
        account = VkClient.getVkClient().create(IAccount.class);
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
