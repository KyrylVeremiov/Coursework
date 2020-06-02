package com.example.coursework;

import android.os.Handler;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import retrofit2.Response;

public class UpdateThread extends Thread {
    private Handler handler;
    private Search data;
    Response<Search> response;
    MutableLiveData<Search> liveData = new MutableLiveData<Search>();

    public LiveData<Search> getLiveData(){
        return liveData;
    }

    public UpdateThread(Handler handler){
        this.handler = handler;
        data= new Search();
//        for(int i = 0; i < 30; ++i){
//            data.add(new Pair("Downloading", i));
//        }
    }

    @Override
    public void run() {
//        try {
//            response = App.getSearchApi().search().execute();
//            Log.d("myLogs: ", "response is received");
//            data=response.body();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        liveData.postValue(data);
//        Message message = new Message();
//        message.obj = data;
//        handler.sendMessage(message);
//        data=null;

    }
}