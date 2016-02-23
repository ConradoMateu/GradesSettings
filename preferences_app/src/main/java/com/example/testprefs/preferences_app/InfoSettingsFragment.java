package com.example.testprefs.preferences_app;

import android.os.Bundle;
import android.preference.PreferenceFragment;

/**
 * @author Antonio López.
 */
public class InfoSettingsFragment extends PreferenceFragment {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.info_preferences);
    }
}