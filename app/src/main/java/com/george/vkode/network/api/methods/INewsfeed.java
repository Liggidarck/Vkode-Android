package com.george.vkode.network.api.methods;

import com.george.vkode.network.model.newsfeed.get.NewsfeedResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface INewsfeed {

    @GET("newsfeed.get")
    Call<NewsfeedResponse> getNewsfeed(@Query("access_token") String access_token,
                                       @Query("filters") String filters,
                                       @Query("max_photos") int max_photos,
                                       @Query("start_from") String start_from,
                                       @Query("v") String version);

}
