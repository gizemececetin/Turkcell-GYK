package com.ornek.webview;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private WebView webview ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        webview = findViewById(R.id.Webview1);

        webview.getSettings().setJavaScriptEnabled(true);
        //setJavaScriptEnable Javascript kodlarının çalıştırılmasını onaylamak için kullanılır.
        //Eğer kullanıcının WebView üzerinden görüntüleyeceği sayfalar güvenmediğimiz ve bilmediğimiz
        // sayfalarsa, uygulamanın ve kullanıcının güvenliği için Javascript kodlarının çalıştırılmamasını seçebiliriz.

        webview.getSettings().setUserAgentString("Mozilla/5.0 (Windows NT 6.1; rv:15.0) Gecko/20120716 Firefox/15.0a2");
        //WebView içerisinde mobil uyumlu siteler yerine web sayfalarının normal halini görüntülemek istiyorsak, UserAgent değerini değiştirmemiz gerekir
        webview.loadUrl("https://www.facebook.com");
        final ProgressDialog progressDialog = ProgressDialog.show(
                this,
                "GYK19",
                "sayfa yükleniyor..",
                true);
        progressDialog.show();
        webview.setWebViewClient(new WebViewClient()
        {
            @Override
            public void onPageFinished (WebView view, String url)
            { //sayfayı yüklemeyi tamamladığında harekete geçen metot
                super.onPageFinished(view, url);
                Toast.makeText(getApplicationContext(), url, Toast.LENGTH_SHORT).show();
                progressDialog.dismiss();
            }
        });


    }
}
