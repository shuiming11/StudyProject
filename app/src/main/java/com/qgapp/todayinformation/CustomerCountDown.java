package com.qgapp.todayinformation;


import android.os.Handler;

import java.util.logging.LogRecord;

/**
 * Created by ACER on 2020/2/15.
 */

public class CustomerCountDown implements Runnable{
    private int totalTime;
    private ICountDownListener countDownListener;
    private int currentTime;
    private final Handler handler;
    private boolean isRun;

    public CustomerCountDown(int totalTime,ICountDownListener countDownListener){
        this.totalTime = totalTime;
        this.countDownListener = countDownListener;
        this.currentTime = totalTime;
        handler = new Handler();
    }

    @Override
    public void run() {
        if(isRun){
            if(countDownListener !=null){
                countDownListener.onTick(currentTime);
                if(currentTime==0){
                    countDownListener.onFinish();
                }else {
                    currentTime--;

                    handler.postDelayed(this,1000);
                }

            }
        }

    }

    public void start(){
        isRun = true;
        handler.post(this);
    }

    public void cancel(){
        isRun = false;
        handler.removeCallbacks(this);
    }

    public interface ICountDownListener{
        void onTick(int currentTime);
        void onFinish();
    }

}
