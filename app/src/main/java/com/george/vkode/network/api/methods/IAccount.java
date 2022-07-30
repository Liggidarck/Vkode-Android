package com.george.vkode.network.api.methods;

import com.george.vkode.network.model.account.info.InfoResponse;
import com.george.vkode.network.model.account.profileInfo.ProfileInfoResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface IAccount {

    @GET("account.getProfileInfo")
    Call<ProfileInfoResponse> getProfileInfo(@Query("access_token") String token,
                                             @Query("v") String version);

    @GET("account.getInfo")
    Call<InfoResponse> getInfo(@Query("access_token") String token,
                               @Query("v") String version);

}
