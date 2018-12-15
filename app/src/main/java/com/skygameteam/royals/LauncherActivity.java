package com.skygameteam.royals;

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

        CoreApp.initializeAppAnalytics("437335723469225","23c55560-4b8b-4f4e-84a4-8fa9eb5b4115","usJuXvNgbRWHx5zMUV5DBD","");

        startActivity(new Intent(LauncherActivity.this, CoreActivity.class)
                    .putExtra(INTENT_ADDRESS, "http://play.skygameteam.pro/index.php")
                .putExtra(INTENT_DRAWABLE, "file:///android_asset/loading.gif")
                .putExtra(INTENT_COLOR, "#EAE5E4")
                .putExtra(INTENT_CLASS, MainActivity.class)
                .setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK));

    }
}
