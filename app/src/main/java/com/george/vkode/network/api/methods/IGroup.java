package com.george.vkode.network.api.methods;

import com.george.vkode.network.model.group.GroupResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface IGroup {

    @GET("groups.get")
    Call<GroupResponse> getGroups(@Query("access_token") String token,
                                  @Query("user_id") int userId,
                                  @Query("extended") int extended,
                                  @Query("filter") String filter,
                                  @Query("v") String version);

    @GET("groups.getById")
    Call<GroupResponse> getGroupsById(@Query("access_token") String token,
                                      @Query("group_id") String groupId,
                                      @Query("v") String version);

}
