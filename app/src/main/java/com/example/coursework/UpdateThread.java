package com.example.coursework;

import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.util.Pair;

import java.util.ArrayList;
import java.util.List;

public class UpdateThread extends Thread {
    private Handler handler;
    List<Pair<String, Integer>> data = new ArrayList<>();

    public UpdateThread(Handler handler){
        this.handler = handler;
        for(int i = 0; i < 30; ++i){
            data.add(new Pair("Downloading", i));
        }
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; ++i){
            try {

                Thread.sleep(5000);
                Message message = new Message();
                message.obj = data;
                handler.sendMessage(message);
                data.clear();
                for(int j = 0; j < 30; ++j){
                    data.add(new Pair("Downloading", i+j));
                }
                if(isInterrupted()){
                    break;
                }
            } catch (InterruptedException interEx){
                Log.e("Update thread", "Interrupted!!!");
            }
        }
    }
}
