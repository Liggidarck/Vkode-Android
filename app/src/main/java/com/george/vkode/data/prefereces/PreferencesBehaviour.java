package com.george.vkode.data.prefereces;

public interface PreferencesBehaviour {

    void saveToken(String token);

    String getToken();

    void saveUserId(int userId);

    String getUserId();

}
