package com.example.croe10.preferencestutorial.activities;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.preference.PreferenceManager;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.croe10.preferencestutorial.R;

public class Preferences extends AppCompatActivity {

    private String TAG = Preferences.class.getCanonicalName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preferences);
        Fragment preferenceFragment = new PreferencesFragment();
        FragmentTransaction ft = getSupportFragmentManager()
                .beginTransaction();

        ft.add(R.id.helloWorld, preferenceFragment)
                .commit();

//        getFragmentManager().beginTransaction()
//                .replace(android.R.id.content, new PreferencesFragment())
//                .commit();
    }

    @Override
    protected void onStart() {
        System.out.println("ON_START:PREFERENCES (MAIN WINDOW):");
        showPreferences();
        System.out.flush();
        super.onStart();
    }

    @Override
    protected void onResume() {
        System.out.println("ON_RESUME:PREFERENCES (MAIN WINDOW):");
        showPreferences();
        System.out.flush();
        super.onResume();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Log.d(TAG, "CALLED onOptionsItemSelected" + item);
        Toast.makeText(this, "Settings Fragment SELECTED",
                Toast.LENGTH_LONG).show();
        return super.onOptionsItemSelected(item);
    }


    private void showPreferences() {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        String port = sharedPreferences.getString("portKey", null);
        Boolean switchPreference = sharedPreferences.getBoolean("localremoteKey", false);
        String server = sharedPreferences.getString("serverKey", null);

        System.out.println();
        if (null != switchPreference)
            System.out.println(":ISCHECKED: " + switchPreference);
        else
            System.out.println("SwitchPreference is NULL");
        if (null != server)
            System.out.println("SERVER:" + server);
        else
            System.out.println("SERVER is NULL");
        if (null != port)
            System.out.println("PORT:" + port);
        else
            System.out.println("PORT is NULL");
        System.out.println();

    }
}
//pref_container