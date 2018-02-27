package lab4.android.wku.edu.autopurchase;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by chunh on 2/26/2018.
 */
//Splash Activity
public class splashActivity extends AppCompatActivity {
    private Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        //Delay for 1 second
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                //load main app
                intent = new Intent(splashActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        }, 1000);

    }
}
