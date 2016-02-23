package com.example.testprefs.preferences_app;

import android.app.Activity;
import android.os.Bundle;
import android.preference.PreferenceFragment;
import android.view.View;


/*
displays the main settings in PrefsFragment - uses preferences.xml
- contained intent starts HeadersActivity

            www.101apps.co.za
*/


public class MainActivity extends Activity implements View.OnClickListener{

    private boolean isMainSettings;
    private MainSettingsFragment mainSettingsFragment;
    private InfoSettingsFragment infoSettingsFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mainSettingsFragment = new MainSettingsFragment(this);
        infoSettingsFragment = new InfoSettingsFragment();

        showFragment(mainSettingsFragment);
        isMainSettings = true;
    }

    /**
     * On info preference click listener.
     *
     * @param v
     */
    @Override
    public void onClick(View v) {
        showFragment(infoSettingsFragment);
        isMainSettings = false;
    }

    @Override
    public void onBackPressed() {
        if (isMainSettings){
            super.onBackPressed();
        }else{
            showFragment(new MainSettingsFragment(this));
            isMainSettings = true;
        }
    }

    private void showFragment(PreferenceFragment preferenceFragment) {
        getFragmentManager()
                .beginTransaction()
                .replace(android.R.id.content,preferenceFragment)
                .commit();
    }
}
