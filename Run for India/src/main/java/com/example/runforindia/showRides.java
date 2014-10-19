package com.example.runforindia;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.davidmis.pushnewsfeed.*;

import java.util.jar.Attributes;

import parser.*;

public class showRides extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        System.out.println("Here5");
        setContentView(R.layout.activity_showrides);
        System.out.println("Here6");
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }
    }

    public void onSumbitShowRide(View view)
    {
        System.out.println("Need a Ride");
        MessageFetcher messageFetcher = new MessageFetcher();
        String str =  null;
        XMLDAO xmldao = null;
        try {

            str=messageFetcher.getXMLString();
            xmldao = new XMLDAO(40,10);
            xmldao.readXML(str);
            //str=xmldao.getMatx().;
        } catch ( Exception e) {
            e.printStackTrace();
        }
        boolean checked = true;
        //EditText ed = (EditText)findViewById(R.id.editText);
        //ed.setText(str);
        System.out.println("Prasan"+str);

        // Creating Table Rows

        TableLayout TL = (TableLayout) findViewById(R.id.tablelay);
        TableRow row = null;

        // create a new TextView

        for(int id=1;id<xmldao.getMaxR();id++){
                row = new TableRow(this);
                if(xmldao.getMatx()[id]!=null){

                    //System.out.print(xmldao.getMatx()[id][j]+ " " + id +j);
                    AddRowInTable(xmldao.getMatx()[id], xmldao.getMaxC(),row);

                    TL.addView(row,new
                            TableLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                            ViewGroup.LayoutParams.WRAP_CONTENT));
                }

            System.out.println();
        }


    }

    public void AddRowInTable(String[] arr , int max,TableRow row) {


            if(arr[0]!=null)
            {
                TextView name= new TextView(this);
                name.setText(arr[0]);
                row.addView(name);
                name.setInputType (InputType.TYPE_TEXT_FLAG_MULTI_LINE);

            }
        if(arr[1]!=null) {
                TextView address= new TextView(this);
                address.setText(arr[1]);
            address.setInputType (InputType.TYPE_TEXT_FLAG_MULTI_LINE);
               // row.addView(address);

        }
            if(arr[2]!=null)
            {
                TextView email= new TextView(this);
                email.setText(arr[2]);
                row.addView(email);
            }
                if(arr[3]!=null)
                {
                TextView phone= new TextView(this);
                phone.setText(arr[3]);
                row.addView(phone);
                }
                    if(arr[4]!=null)
                    {
                TextView need = new TextView(this);
                need.setText(arr[4]);
                row.addView(need);
                    }



            System.out.println();
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
