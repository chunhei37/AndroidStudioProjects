package lab1.android.wku.edu.helloworld;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;


//ChunHei Yuen
public class HelloworldActivity extends AppCompatActivity {
    String resumeMsg = "on resume";

    private void initializeMsg() {
        

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_helloworld);
    }

    @Override
    protected void onPause(Bundle savedInstanceState) {
        super.onPause();
        Toast.makeText(this, "", Toast.LENGTH_SHORT).show();

    }
}
