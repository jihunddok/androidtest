package com.example.asynctask;

import android.os.AsyncTask;
import android.widget.TextView;

public class MyAsyncTask extends AsyncTask<String,Integer,Boolean> {
    TextView tv_async;

    public MyAsyncTask(TextView viewById) {
        this.tv_async = viewById;
    }

    @Override
    protected Boolean doInBackground(String... strings) {

        for(int i = 0; i < 10000; i++){
            publishProgress(i);
            try{
                Thread.sleep(100);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        return true;
    }
    @Override
    protected void onProgressUpdate(Integer...values){
        tv_async.setText(values[0].toString());
        super.onProgressUpdate(values);
    }

    @Override
    protected void onPostExecute(Boolean s){
        super.onPostExecute(s);
    }

    @Override
    protected  void onCancelled(Boolean s){
        super.onCancelled(s);
    }
}
