// Created by ChunHei Yuen

package lab3.android.wku.edu.esportclub;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

public class about extends AppCompatActivity {

    private WebView sponsors;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        sponsors = findViewById(R.id.sponsors);
        //Display a gif image by using Webview
        sponsors.loadUrl("https://www.wku.edu/esports/images/sponsors.gif");
    }
}
