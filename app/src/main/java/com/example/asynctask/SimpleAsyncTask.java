package com.example.asynctask;

import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.widget.TextView;
import java.lang.ref.WeakReference;

public class SimpleAsyncTask extends AsyncTask<Void, Void, String> {
    private WeakReference<TextView> mTextView;

    SimpleAsyncTask(TextView tv) {
        mTextView = new WeakReference<>(tv);
    }

    @Override
    protected String doInBackground(Void... voids) {
        int n = (int)(Math.random() * 10 + 1);
        int s = n * 200;
        try{
            Thread.sleep(s);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "Awake at last after sleeping for " + s  + " milliseconds";
    }

    protected void onPostExecute(String result)
    {
        mTextView.get().setText(result);
    }

}
