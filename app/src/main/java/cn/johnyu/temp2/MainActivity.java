package cn.johnyu.temp2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.webkit.ValueCallback;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    private WebView webView;
    private BottomNavigationView navView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        navView=findViewById(R.id.nav_view);
        webView=findViewById(R.id.webView);
        WebSettings settings= webView.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setCacheMode(WebSettings.LOAD_NO_CACHE);
        webView.loadUrl("http://johnyu.cn/face1.html");
        webView.addJavascriptInterface(new MyService(this),"myService");


        navView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.navigation_home:
                        webView.evaluateJavascript("javascript:fun1('JohnYu')",
                                value-> Toast.makeText(MainActivity.this,value,Toast.LENGTH_LONG).show());
                        break;

                }
                return true;
            }
        });
    }

    public void nav(View view) {
        webView.evaluateJavascript("javascript:fun1('JohnYu')",
                value-> Toast.makeText(this,value,Toast.LENGTH_LONG).show());
    }
}
