package com.example.testprefs.preferences_app;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceFragment;
import android.view.View;

/**
 * @author Antonio López.
 */
public class MainSettingsFragment
        extends PreferenceFragment
        implements SharedPreferences.OnSharedPreferenceChangeListener {

    private View.OnClickListener clickListener;

    public MainSettingsFragment(View.OnClickListener clickListener) {
        this.clickListener = clickListener;
    }

    private final static String RATE_PREFERENCE = "rate";
    private final static String SHARE_PREFERENCE = "share";
    //etc...
    private final static String INFO_PREFERENCE = "info";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.preferences);

        Preference rate = findPreference(RATE_PREFERENCE);
        //etc...

        Preference info = findPreference(INFO_PREFERENCE);
        info.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            @Override
            public boolean onPreferenceClick(Preference preference) {
                if (clickListener != null){
                    clickListener.onClick(null);
                }
                return false;
            }
        });
    }

    @Override
    public void onResume() {
        super.onResume();
        getPreferenceScreen().getSharedPreferences()
                .registerOnSharedPreferenceChangeListener(this);
    }

    @Override
    public void onPause() {
        super.onPause();
        getPreferenceScreen().getSharedPreferences()
                .unregisterOnSharedPreferenceChangeListener(this);
    }

    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
        if (key.equals("sample_preference")) {
            Preference foodPref = findPreference(key);
            foodPref.setSummary(sharedPreferences.getString(key, ""));
        }
    }
}