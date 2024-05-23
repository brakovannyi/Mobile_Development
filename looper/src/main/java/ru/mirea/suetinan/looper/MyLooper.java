package ru.mirea.suetinan.looper;


import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.util.Log;


import android.os.Handler;

import java.util.concurrent.TimeUnit;

public class MyLooper extends Thread{
    public Handler mHandler;
    private Handler mainHandler;
    public MyLooper(Handler mainThreadHandler){
        mainHandler = mainThreadHandler;
    }

    public void	run() {
        Log.d("MyLooper", "run");
        Looper.prepare();
        mHandler = new	Handler(Looper.myLooper()) {
            public void	handleMessage(Message msg) {
                String	age = msg.getData().getString("AGE");
                String	occupation = msg.getData().getString("OCCUPATION");
                Log.d("MyLooper	get	message: ", age);
                Log.d("MyLooper	get	message: ", occupation);
                Message	message	= new Message();
                Bundle bundle =	new	Bundle();
                bundle.putString("result", String.format("Age is: %s, occupation is: %s",age, occupation));
                message.setData(bundle);
                //	Send the message back to main thread message queue use main thread message Handler.
                try{
                    TimeUnit.SECONDS.sleep(Integer.parseInt(age));
                    mainHandler.sendMessage(message);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }

            }
        };
        Looper.loop();
    }
}
