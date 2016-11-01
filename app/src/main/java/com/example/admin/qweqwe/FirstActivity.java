package com.example.admin.qweqwe;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * <hr><pre>
 * Class Document Comment
 * </pre><hr>
 *
 * @author Created by Lee on 2016-07-04.
 */
public class FirstActivity extends AppCompatActivity implements View.OnClickListener{

    private Button main, second;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_activity);
        addShortcut(this);
        main = (Button) findViewById(R.id.main);
        second = (Button) findViewById(R.id.second);

        main.setOnClickListener(this);
        second.setOnClickListener(this);
    }
    private void addShortcut(Context context) {
        Intent shortcutIntent = new Intent(Intent.ACTION_MAIN);
        shortcutIntent.addCategory(Intent.CATEGORY_LAUNCHER);
        shortcutIntent.setClassName(context, getClass().getName());
        shortcutIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK
                | Intent.FLAG_ACTIVITY_RESET_TASK_IF_NEEDED);

        Intent intent = new Intent();
        intent.putExtra(Intent.EXTRA_SHORTCUT_INTENT, shortcutIntent);
        intent.putExtra(Intent.EXTRA_SHORTCUT_NAME, getResources().getString(R.string.app_name));
        intent.putExtra(Intent.EXTRA_SHORTCUT_ICON_RESOURCE,
                Intent.ShortcutIconResource.fromContext(context,
                        R.mipmap.ic_launcher));
        intent.putExtra("duplicate", false);
        intent.setAction("com.android.launcher.action.INSTALL_SHORTCUT");

        sendBroadcast(intent);
    }
    @Override
    public void onClick(View view) {
        int id = view.getId();

        if(id == main.getId()){
            Intent intent = new Intent(FirstActivity.this, MainActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP|Intent.FLAG_ACTIVITY_SINGLE_TOP);
            startActivity(intent);
            finish();
        }else{
            Intent intent = new Intent(FirstActivity.this, SecondActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP|Intent.FLAG_ACTIVITY_SINGLE_TOP);
            startActivity(intent);
            finish();
        }
    }
}
