package com.george.vkode.data.prefereces;

public interface PreferencesBehaviour {

    void saveToken(String token);

    void deleteToken();

    String getToken();

    void saveUserId(int userId);

    int getUserId();

    void saveCode(String code);

    String getCode();

}
