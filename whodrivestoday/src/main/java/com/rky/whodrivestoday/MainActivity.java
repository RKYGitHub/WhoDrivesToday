package com.rky.whodrivestoday;

/**
 * Created by RKY on 1/20/14.
 */

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.content.Intent;
import android.media.MediaPlayer;
import android.view.View;

/**
 * Displays an image on the whole app's face.
 * When touched, plays a drumroll and then goes to the next screen
 */
public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    /**
     * Plays the sound then goes to the decide activity
     */
    public void goToDecideDriver(View view) {
        playSound();

        Intent intent = new Intent(this, DecideDriver.class);
        startActivity(intent);
    }

    /**
     * Plays the drumroll sound
     */
    private void playSound() {
        MediaPlayer player = MediaPlayer.create(getBaseContext(), R.raw.drumroll);
        player.start();

        while (player.isPlaying()) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        player.reset();
        player.release();
        player = null; // developer.android says to do this
    }
}
