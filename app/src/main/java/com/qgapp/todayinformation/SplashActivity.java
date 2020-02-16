package com.qgapp.todayinformation;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.VideoView;

import org.w3c.dom.Text;

/**
 * Created by ACER on 2020/2/15.
 */

public class SplashActivity extends AppCompatActivity{

    private VideoView videoview;
    private TextView tv_drump;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        videoview = findViewById(R.id.videoview);
        tv_drump = findViewById(R.id.tv_drump);
        videoview.setVideoURI(
                Uri.parse("android.resource://" + getPackageName() + "/raw/" +
                        R.raw.splash));
        videoview.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                videoview.start();
            }
        });

        videoview.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                videoview.start();
            }
        });

        CustomerCountDown customerCountDown = new CustomerCountDown(5, new CustomerCountDown.ICountDownListener() {
            @Override
            public void onTick(int currentTime) {
                tv_drump.setText(currentTime+"秒");
            }

            @Override
            public void onFinish() {
                tv_drump.setText("跳过");
            }
        });

        customerCountDown.start();
    }
}
