//Created by ChunHei yuen

package lab3.android.wku.edu.esportclub;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class contact extends AppCompatActivity {

    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);
        //Load the contact page from the esport club
        webView = findViewById(R.id.webView);
        webView.loadUrl("https://www.wku.edu/esports/contact.php");
    }
}
