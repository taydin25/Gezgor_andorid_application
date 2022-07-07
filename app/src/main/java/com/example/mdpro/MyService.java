package com.example.mdpro;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class MyService extends Service {
    private MediaPlayer mMediaPlayer;
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
    public void onCreate(){
        Toast.makeText(this , "Service created", Toast.LENGTH_SHORT).show();
        mMediaPlayer =MediaPlayer.create(getApplicationContext(),R.raw.music);
        mMediaPlayer.setLooping(true);
    }

    public void onStart(Intent intent,int startid){
        Toast.makeText(this , "Sound started", Toast.LENGTH_SHORT).show();
        mMediaPlayer.start();
    }
    public void onDestroy(){
        Toast.makeText(this , "Sound stopped", Toast.LENGTH_SHORT).show();
        mMediaPlayer.pause();
    }
}
