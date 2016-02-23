package com.mykytyn.activitydialog;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

public class DialogActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);

        ListView listView = (ListView) findViewById(R.id.items_list);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent = new Intent(SomeManager.ITEM_CHOSEN);

                intent.putExtra("item",((TextView)view).getText());
                intent.putExtra("index",position);

                finish();

                LocalBroadcastManager.getInstance(DialogActivity.this)
                        .sendBroadcast(intent);
            }
        });
    }
}
