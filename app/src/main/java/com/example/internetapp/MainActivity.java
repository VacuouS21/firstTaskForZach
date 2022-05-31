package com.example.internetapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.net.Network;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class MainActivity extends AppCompatActivity {
    private WebView webView;
    private PopupMenu popupMenu;
    private SwipeRefreshLayout refreshLayout;
    public EditText name;
private String siteName="https://yandex.ru/";
//"https://yandex.ru/"
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        refreshLayout = findViewById(R.id.swiperefresh);
        webView = findViewById(R.id.webView);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setCacheMode(WebSettings.LOAD_DEFAULT);
        webView.setWebViewClient(new WebViewClient());
        Button btnFetch = findViewById(R.id.downloadBtn);
        Bundle arguments = getIntent().getExtras();
        siteName = arguments.get("hello").toString();
        new PageLoader(findViewById(R.id.downloadBtn), findViewById(R.id.name), webView,siteName).start();

            btnFetch.setOnClickListener(v -> {
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
               /* name=findViewById(R.id.name);
                siteName=name.getText().toString();
                Uri address = Uri.parse(siteName);
                Intent openLinkIntent = new Intent(Intent.ACTION_VIEW, address);


                if (openLinkIntent.resolveActivity(getPackageManager()) != null) {
                    webView.getContext().startActivity(openLinkIntent);
                } else {
                    Log.d("Intent", "Не получается обработать намерение!");
                }*/
                /*if(btnFetch.getText().equals("На главную")){
                    btnFetch.setText("На главную");
                    webView.destroy();
                    startActivity(new Intent(this, MainActivity.class));
                }
                if (btnFetch.getText().equals("Загрузка")) {
                    btnFetch.setText("На главную");
                    name=findViewById(R.id.name);
                    siteName=name.getText().toString();

                }*/
            });


      /*  refreshLayout.setOnRefreshListener(
                () -> {
                    refreshLayout.setRefreshing(false);
                    if (btnFetch.getText().equals("Загрузка"))
                        Toast.makeText(MainActivity.this.getApplicationContext(),
                                "Обновлять нечего", Toast.LENGTH_SHORT).show();
                    else {
                        Toast.makeText(MainActivity.this.getApplicationContext(),
                                "Обновление...", Toast.LENGTH_SHORT).show();
                        webView.reload();
                    }
                }
        );*/
    }

    /*public void back(View v) {
        webView.goBack();
    }

    public void forward(View v) {
        webView.goForward();
    }
    public void zumPlus(View v){ webView.zoomIn();}
    public void zumMinus(View v){webView.zoomOut();}
    public void getURL(View v){String url = webView.getUrl();
        ClipboardManager clipboard = (ClipboardManager) getApplicationContext().getSystemService(Context.CLIPBOARD_SERVICE);
        ClipData clip = ClipData.newPlainText("", url);
        clipboard.setPrimaryClip(clip);
        Toast.makeText(MainActivity.this.getApplicationContext(),
                "URL " + url + " скопирован в буфер обмена", Toast.LENGTH_SHORT).show();}
    public void clearCash(View v){
        webView.clearCache(true);
    }
    public void update(View v){
        Toast.makeText(MainActivity.this.getApplicationContext(),
                "Обновление...", Toast.LENGTH_SHORT).show();
        webView.reload();
    }
*/
}