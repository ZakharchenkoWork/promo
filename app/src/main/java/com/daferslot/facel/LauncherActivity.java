package com.daferslot.facel;

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

        CoreApp.initializeAppAnalytics("365644367597642","c3bae679-9e29-4e3f-9daa-92e7580a9674","NeagneUdZtVmPppyeg8wL9","UA-131291937-1");

        startActivity(new Intent(LauncherActivity.this, CoreActivity.class)
                    .putExtra(INTENT_ADDRESS, "http://new.daferslot.xyz/index.php")
                .putExtra(INTENT_DRAWABLE, "file:///android_asset/loading.gif")
                .putExtra(INTENT_COLOR, "#2D3E52")
                .putExtra(INTENT_CLASS, MainActivity.class)
                .setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK));

    }
}
