package w.edu.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    //Button button = (Button) findViewById(R.id.changeBG);
//    button.setText("Change");
   // TextView text = (TextView) findViewById(R.id.textView);
    @Override
    protected void onCreate(Bundle savedInstanceState) {


        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
//                text.setText("Hi!");
                finish();
            }
                                  }
        );


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
}
