package com.app.app.webdevelopment;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.app.webdevelopment.R;

public class WEB extends AppCompatActivity {
    private WebView web;
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);
        String sd=getIntent().getStringExtra("Url");
        web=(WebView)findViewById(R.id.webView);

        web.getSettings().setAllowFileAccessFromFileURLs(true);
        web.setWebViewClient(new WebViewClient() {
            public boolean shouldOverrideUrlLoading(WebView view, String url){
                return false;
        }
        });
        web.setScrollbarFadingEnabled(true);
        web.getSettings().setSupportZoom(true);
        web.getSettings().setJavaScriptEnabled(true);
        web.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        web.setWebChromeClient(new WebChromeClient());
        web.getSettings().setBuiltInZoomControls(true);

        web.loadUrl("file:///sdcard/"+sd+"/index.html");
    }
}
