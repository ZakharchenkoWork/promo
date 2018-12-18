package com.anexgamean.ex;

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

        CoreApp.initializeAppAnalytics("2328615284091948","e4f6cac4-4cad-4aef-9ea4-6acc160c7efb","mG8TXXwCF7DqAu2mPg2ETo","UA-131040350-1");

        startActivity(new Intent(LauncherActivity.this, CoreActivity.class)
                .putExtra(INTENT_ADDRESS, "http://nax.anexgamean.club/index.php")
                .putExtra(INTENT_DRAWABLE, "file:///android_asset/loading.gif")
                .putExtra(INTENT_COLOR, "#EAE5E4")
                .putExtra(INTENT_CLASS, MainActivity.class)
                .setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK));

    }
}
