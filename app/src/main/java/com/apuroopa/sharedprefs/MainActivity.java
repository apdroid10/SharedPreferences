package com.apuroopa.sharedprefs;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView countText;
    private int mCount;
    int mcolor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        countText = (TextView) findViewById(R.id.countText);

        // restore saved instance
        if(savedInstanceState!=null){
            countText.setBackgroundColor(savedInstanceState.getInt("color"));
            countText.setText(String.format("%s",savedInstanceState.getInt("count")));
        }
    }


    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        // save color
        outState.putInt("color",mcolor);
        Log.d("Main ",String.format("%s",mcolor));
        // save count
        outState.putInt("count",mCount);
        Log.d("Main ",String.format("%s",mCount));

    }

    public void changeBackgroundColor(View view){
        // get the color of the button clicked
         mcolor = ((ColorDrawable) view.getBackground()).getColor();
        countText.setBackgroundColor(mcolor);
    }

    public void changeCount(View view){
        mCount++;
        countText.setText(String.format("%s", mCount));
    }

    public void reset(View view){

        mCount=0;
        countText.setText(String.format("%s", mCount));
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
