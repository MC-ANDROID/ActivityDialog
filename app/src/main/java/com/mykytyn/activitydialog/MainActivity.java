package com.mykytyn.activitydialog;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    private TextView eventsLog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        eventsLog = (TextView) findViewById(R.id.events_log);

    }

    public void showDialog(View view){

        SomeManager.getInstance().foo(null, new SomeManager.CallBack() {
            @Override
            public void done(String item, int index) {

                eventsLog.append(item+" "+index+"\n");
                Log.i(TAG, item + " " + index);
            }
        },getApplicationContext());

    }
}
