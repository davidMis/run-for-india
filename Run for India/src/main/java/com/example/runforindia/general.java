package com.example.runforindia;

import android.app.TabActivity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;
import android.widget.EditText;
import android.widget.TabHost;

public class general extends TabActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        System.out.println("Here2");
        //setContentView(R.layout.activity_gen);
        TabHost tabHost = getTabHost();
        tabHost.setup();

        TabHost.TabSpec spec1=tabHost.newTabSpec("Exercise");
        Intent in1=new Intent(this, Exercise.class);
        spec1.setContent(in1);
        spec1.setIndicator("Exercise");

        TabHost.TabSpec spec2=tabHost.newTabSpec("Nutrition");
        Intent in2=new Intent(this, Nutrition.class);
        spec2.setContent(in2);
        spec2.setIndicator("Nutrition");

        TabHost.TabSpec spec3=tabHost.newTabSpec("Routes");
        spec3.setIndicator("Routes");
        Intent in3=new Intent(this, Routes.class);
        spec3.setContent(in3);

        TabHost.TabSpec spec4=tabHost.newTabSpec("Projects");
        spec4.setIndicator("Projects");
        Intent in4=new Intent(this, Projects.class);
        spec4.setContent(in4);

        tabHost.addTab(spec1);
        tabHost.addTab(spec2);
        tabHost.addTab(spec3);
        tabHost.addTab(spec4);

        //tabHost.setCurrentTab(0);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.

        return true;
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);
            return rootView;
        }
    }

}
