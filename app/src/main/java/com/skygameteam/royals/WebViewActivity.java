package com.skygameteam.royals;

import android.Manifest;
import android.app.Activity;
import android.app.DownloadManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.util.Log;
import android.webkit.WebSettings;
import android.webkit.WebView;

/**
 * Created by Konstantyn Zakharchenko on 11.12.2018.
 */

public class WebViewActivity extends Activity{
    public static final String GAME_NAME = "game_name";
    private String game;
    WebView webView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);

        webView = findViewById(R.id.webView);
        game = getIntent().getExtras().getString(GAME_NAME);
        webView.getSettings().setJavaScriptEnabled(true);

        webView.loadUrl("file://" + Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS) + "/games/"+game+".htm");
       // webView.loadUrl("file:///android_asset/" + getIntent().getExtras().getString(GAME_NAME) + ".htm");
        //registerReceiver(onComplete, new IntentFilter(DownloadManager.ACTION_DOWNLOAD_COMPLETE));
        // проверяем дал ли пользователь разрешение на запись данных в память телефона
        //checkStoragePermission();
    }

        private BroadcastReceiver onComplete = new BroadcastReceiver() {
            public void onReceive(Context context, Intent intent) {
                webView.loadUrl("file://" + Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS) + "/games/"+game+".htm");

            }
        };

    private void checkStoragePermission() {
        if (Build.VERSION.SDK_INT >= 23) {
            if (checkSelfPermission(android.Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) {
                // разрешение есть, можно качать файл
                downloadGame();
            } else {
                // разрешения нет, просим его предоставить
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
            }
        }
        else {
            // на Android ниже 6.0 просить не нужно, можно сразу качать
            downloadGame();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            // пользователь предоставил разрешение на запись, качаем
            downloadGame();
        } else {
            // пользователь не предоставил разрешения, просим повторно
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
        }
    }

    public static final String URL_START = "http://games-cv.com/";
    public static final String URL_END = "?refCode=wp_w14623p143_\" width=\"800\" height=\"600\"";

    // Скачиваем и сохраняем файл в папку Downloads/games/game_index.html

    private void downloadGame() {
        DownloadManager downloadManager = (DownloadManager) getSystemService(Context.DOWNLOAD_SERVICE);
        // указываем путь откуда качать .html файл
        DownloadManager.Request request = new DownloadManager.Request(Uri.parse(URL_START + game + URL_END));
        request.setAllowedNetworkTypes(DownloadManager.Request.NETWORK_WIFI | DownloadManager.Request.NETWORK_MOBILE);
        request.setAllowedOverRoaming(false);
        request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
        request.setVisibleInDownloadsUi(false);
        // указываем путь куда сохранять .html файл
        request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, "/games/" + game + ".htm");

        Log.d("path0", "" + Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS) + "/games/"+game+".htm" );
        downloadManager.enqueue(request);


    }
}
