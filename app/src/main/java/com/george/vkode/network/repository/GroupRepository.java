package com.george.vkode.network.repository;

import static com.george.vkode.utils.Keys.API_VERSION;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;

import com.george.vkode.network.api.VkClient;
import com.george.vkode.network.api.methods.IGroup;
import com.george.vkode.network.model.group.GroupResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GroupRepository {

    IGroup group;
    String token;

    public GroupRepository(String token) {
        group = VkClient.getVkClient().create(IGroup.class);
        this.token = token;
    }

    public MutableLiveData<GroupResponse> getGroups(int userId, String filter) {
        MutableLiveData<GroupResponse> groupResponse = new MutableLiveData<>();
        group.getGroups(token, userId, 1, filter, API_VERSION).enqueue(new Callback<GroupResponse>() {
            @Override
            public void onResponse(@NonNull Call<GroupResponse> call, @NonNull Response<GroupResponse> response) {
                groupResponse.setValue(response.body());
            }

            @Override
            public void onFailure(@NonNull Call<GroupResponse> call, @NonNull Throwable t) {
                groupResponse.postValue(null);
            }
        });
        return groupResponse;
    }

    public MutableLiveData<GroupResponse> getGroupsById(String groupId) {
        MutableLiveData<GroupResponse> groupResponse = new MutableLiveData<>();
        group.getGroupsById(token, groupId, API_VERSION).enqueue(new Callback<GroupResponse>() {
            @Override
            public void onResponse(@NonNull Call<GroupResponse> call, @NonNull Response<GroupResponse> response) {
                groupResponse.setValue(response.body());
            }

            @Override
            public void onFailure(@NonNull Call<GroupResponse> call, @NonNull Throwable t) {
                groupResponse.postValue(null);
            }
        });
        return groupResponse;
    }

}
