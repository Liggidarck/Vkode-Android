package com.george.vkode.network.repository;

import static com.george.vkode.utils.Keys.API_VERSION;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;

import com.george.vkode.network.api.VkClient;
import com.george.vkode.network.api.methods.IFriends;
import com.george.vkode.network.model.friends.get.Friends;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FriendsRepository {

    IFriends friends;
    String token;

    public FriendsRepository(String token) {
        friends = VkClient.getVkClient().create(IFriends.class);
        this.token = token;
    }

    public MutableLiveData<Friends> getUserFriends(String order, String fields) {
        MutableLiveData<Friends> friendsMutableLiveData = new MutableLiveData<>();

        friends.getFriends(token, order, fields, API_VERSION).enqueue(new Callback<Friends>() {
            @Override
            public void onResponse(@NonNull Call<Friends> call, @NonNull Response<Friends> response) {
                friendsMutableLiveData.setValue(response.body());
            }

            @Override
            public void onFailure(@NonNull Call<Friends> call, @NonNull Throwable t) {
                friendsMutableLiveData.postValue(null);
            }
        });

        return friendsMutableLiveData;
    }

}
