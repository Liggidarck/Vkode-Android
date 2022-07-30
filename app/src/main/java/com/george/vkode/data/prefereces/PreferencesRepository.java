package com.george.vkode.data.prefereces;

import static com.george.vkode.utils.Keys.APP_PREFERENCES;
import static com.george.vkode.utils.Keys.APP_TOKEN;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;

public class PreferencesRepository implements PreferencesBehaviour {

    final SharedPreferences sharedPreferences;
    final SharedPreferences.Editor editor;

    public PreferencesRepository(Application app) {
        sharedPreferences = app.getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }

    @Override
    public void saveToken(String token) {
        editor.putString(APP_TOKEN, token).apply();
    }

    @Override
    public String getToken() {
        return sharedPreferences.getString(APP_TOKEN, null);
    }


}