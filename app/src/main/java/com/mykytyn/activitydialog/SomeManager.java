package com.mykytyn.activitydialog;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.content.LocalBroadcastManager;

/**
 * Created by Misha on 2/23/16.
 */
public class SomeManager {

    public static final String ITEM_CHOSEN = "ItemChosen";

    private static SomeManager ourInstance = new SomeManager();

    public static SomeManager getInstance() {
        return ourInstance;
    }

    private SomeManager() {
    }

    public void foo(Intent unused,final CallBack callBack, final Context appContext){
        Intent theIntent = new Intent(appContext, DialogActivity.class);
        theIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

        appContext.startActivity(theIntent);

        LocalBroadcastManager.getInstance(appContext).registerReceiver(new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent in) {
                LocalBroadcastManager.getInstance(appContext).unregisterReceiver(this);
                callBack.done(in.getStringExtra("item"),in.getIntExtra("index", -1));

            }
        },new IntentFilter(ITEM_CHOSEN));
    }

    public interface CallBack{
        void done(String item,int index);
    }
}
