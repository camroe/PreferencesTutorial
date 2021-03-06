package com.example.croe10.preferencestutorial.activities;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.preference.PreferenceManager;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Toast;

public class SettingsActivity extends AppCompatActivity {

    private String TAG = SettingsActivity.class.getCanonicalName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_preferences);
        Log.d(TAG + ".onCreate()", "About to add to helloWorld with Fragment");
//        Fragment preferenceFragment = new SettingsFragment();
//        FragmentTransaction ft = getSupportFragmentManager()
//                .beginTransaction();
////        ft.add(R.id.helloWorld, preferenceFragment)
////                .commit();
//    ft.replace(R.id.helloWorld,preferenceFragment).commit();
        getSupportFragmentManager().beginTransaction()
                .replace(android.R.id.content, new SettingsFragment())
                .commit();
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
        System.out.println(":ISCHECKED: " + switchPreference);
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