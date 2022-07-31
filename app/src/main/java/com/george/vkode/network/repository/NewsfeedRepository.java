package com.george.vkode.network.repository;

import static com.george.vkode.utils.Keys.API_VERSION;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;

import com.george.vkode.network.api.VkClient;
import com.george.vkode.network.api.methods.INewsfeed;
import com.george.vkode.network.model.newsfeed.get.NewsfeedResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NewsfeedRepository {

    INewsfeed newsfeed;
    String token;

    public NewsfeedRepository(String token) {
        this.token = token;
        newsfeed = VkClient.getVkClient().create(INewsfeed.class);
    }

    public MutableLiveData<NewsfeedResponse> getNewsfeed(String filters, String startFrom) {
        MutableLiveData<NewsfeedResponse> newsfeedResponse = new MutableLiveData<>();
        newsfeed.getNewsfeed(token, filters, startFrom, API_VERSION).enqueue(new Callback<NewsfeedResponse>() {
            @Override
            public void onResponse(@NonNull Call<NewsfeedResponse> call, @NonNull Response<NewsfeedResponse> response) {
                newsfeedResponse.setValue(response.body());
            }

            @Override
            public void onFailure(@NonNull Call<NewsfeedResponse> call, @NonNull Throwable t) {
                newsfeedResponse.postValue(null);
            }
        });
        return newsfeedResponse;
    }

}