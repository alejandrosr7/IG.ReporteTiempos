package com.intergrupo.reportedetiemposig.Helper;

import android.content.Context;
import android.content.SharedPreferences;

import com.intergrupo.reportedetiemposig.Util.Constants;

/**
 * Created by mauricio on 28/11/15.
 */
public class SecurePreferences {


    private final SharedPreferences preferences;

    public SecurePreferences(Context context) {

        this.preferences = context.getSharedPreferences(Constants.PREFS, context.MODE_PRIVATE);

    }

    public String getString(String key) {
        if (preferences.contains(key)) {
            String value = preferences.getString(key, null);
            return value;
        }
        return null;
    }

    public void put(String key, String value) {
        if (value == null) {
            deleteValue(key);
        } else {
            putValue(key, value);
        }
    }

    public void deleteValue(String key) {
        preferences.edit().remove(key).commit();
    }

    private void putValue(String key, String value) {
        preferences.edit().putString(key, value).commit();
    }
}
