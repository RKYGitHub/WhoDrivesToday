package com.rky.whodrivestoday;

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
import android.content.Intent;
import android.media.MediaPlayer;

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

    public void GoToDecideDriver(View view) {
        PlaySound();

        Intent intent = new Intent(this, DecideDriver.class);
        startActivity(intent);
    }

    private void PlaySound() {
        MediaPlayer player = MediaPlayer.create(getBaseContext(), R.raw.drumroll);
        //player.setOnCompletionListener(Listener listener);
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
        player = null;
    }
}
