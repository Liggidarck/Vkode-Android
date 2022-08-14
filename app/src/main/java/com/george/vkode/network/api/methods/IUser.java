package com.george.vkode.network.api.methods;


import com.george.vkode.network.model.common.user.UserPhotoResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;


public interface IUser {

    @GET("users.get")
    Call<UserPhotoResponse> getUser(@Query("access_token") String token,
                                    @Query("fields") String fields,
                                    @Query("v") String version);

}
