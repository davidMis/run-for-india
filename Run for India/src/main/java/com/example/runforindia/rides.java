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

public class rides extends TabActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        System.out.println("Here2");

        TabHost tabHost = getTabHost();
        tabHost.setup();

        TabHost.TabSpec spec1=tabHost.newTabSpec("SignUp");
        Intent in1=new Intent(this, signup.class);
        spec1.setContent(in1);
        spec1.setIndicator("SignUp");

        TabHost.TabSpec spec2=tabHost.newTabSpec("Assigned Rides");
        Intent in2=new Intent(this, showRides.class);
        spec2.setContent(in2);
        spec2.setIndicator("Assigned Rides");


        tabHost.addTab(spec1);
        tabHost.addTab(spec2);
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
