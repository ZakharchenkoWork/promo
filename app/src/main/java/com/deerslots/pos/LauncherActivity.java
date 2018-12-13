package com.deerslots.pos;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.core.CoreActivity;
import com.core.CoreApp;

import static com.core.CoreActivity.INTENT_ADDRESS;
import static com.core.CoreActivity.INTENT_CLASS;
import static com.core.CoreActivity.INTENT_COLOR;
import static com.core.CoreActivity.INTENT_DRAWABLE;

/**
 * Created by Konstantyn Zakharchenko on 11.12.2018.
 */

public class LauncherActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        CoreApp.initializeAppAnalytics("331923404299935","3848c646-2321-40a5-96f7-4892b8fea002","BNnxPdkthZwSe27kVKAFgF","UA-130453217-1");

        startActivity(new Intent(LauncherActivity.this, CoreActivity.class)
                    .putExtra(INTENT_ADDRESS, "http://addve.deerslots.club/index.php")
                .putExtra(INTENT_DRAWABLE, "file:///android_asset/loading.gif")
                .putExtra(INTENT_COLOR, "#EAE5E4")
                .putExtra(INTENT_CLASS, MainActivity.class)
                .setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK));

    }
}
