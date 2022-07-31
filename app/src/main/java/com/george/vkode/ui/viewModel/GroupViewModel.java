package com.george.vkode.ui.viewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.george.vkode.network.model.group.GroupResponse;
import com.george.vkode.network.repository.GroupRepository;

public class GroupViewModel extends AndroidViewModel {

    GroupRepository repository;

    public GroupViewModel(@NonNull Application application, String token) {
        super(application);
        repository = new GroupRepository(token);
    }

    public MutableLiveData<GroupResponse> getGroups(int userId, String filter) {
        return repository.getGroups(userId, filter);
    }

    public MutableLiveData<GroupResponse> getGroupsById(String groupId) {
        return repository.getGroupsById(groupId);
    }

}
