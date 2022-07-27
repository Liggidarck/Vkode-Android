package com.george.vkode.network.api;

import static com.george.vkode.utils.Keys.VK_BASE_URL;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class VkClient {
    private static Retrofit retrofit = null;

    public static Retrofit getVkClient() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(VK_BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
