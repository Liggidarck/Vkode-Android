package com.george.vkode.network.api.methods;

import com.george.vkode.network.model.friends.get.Friends;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface IFriends {
    @GET("friends.get")
    Call<Friends> getFriends(@Query("access_token") String access_token,
                             @Query("order") String order,
                             @Query("fields") String fields,
                             @Query("v") String version);

}
