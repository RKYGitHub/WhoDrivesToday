package com.rky.whodrivestoday;

/**
 * Created by RKY on 1/20/14.
 */
import java.util.Random;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class DecideDriver extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_decide_driver);
        // Show the Up button in the action bar.
        getActionBar().setDisplayHomeAsUpEnabled(true);

        // randomly decide who drives
        Random randomGenerator = new Random();
        int driverNumber = randomGenerator.nextInt(2);
        String driverName = "UNINITIALIZED";

        switch (driverNumber){
            case 0:
                driverName = "Robbie";
                break;
            case 1:
                driverName = "Sarah";
                break;
            default:
                driverName = "ERROR";
        }



        TextView textView = new TextView(this);
        textView.setTextSize(50);
        textView.setTextColor(-16711936);
        textView.setText(driverName + " drives today!");
        textView.setBackgroundResource(R.drawable.alyx_demands);

        setContentView(textView);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_decide_driver, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                // This ID represents the Home or Up button. In the case of this
                // activity, the Up button is shown. Use NavUtils to allow users
                // to navigate up one level in the application structure. For
                // more details, see the Navigation pattern on Android Design:
                //
                // http://developer.android.com/design/patterns/navigation.html#up-vs-back
                //
                NavUtils.navigateUpFromSameTask(this);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

}