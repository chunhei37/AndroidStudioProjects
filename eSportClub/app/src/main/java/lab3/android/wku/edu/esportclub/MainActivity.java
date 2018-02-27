//Created by ChunHei yuen

package lab3.android.wku.edu.esportclub;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // Button
    private Button btn_wie;
    private Button btn_roster;
    private Button btn_contact;
    private Button btn_about;

    //Intent
    private Intent intent_wie;
    private Intent intent_about;
    private Intent intent_roster;
    private Intent intent_contact;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // define buttons
        btn_wie = (Button) findViewById(R.id.btn1);
        btn_roster = (Button) findViewById(R.id.button2);
        btn_contact = (Button) findViewById(R.id.button5);
        btn_about = (Button) findViewById(R.id.button);
        //define intents
        intent_wie = new Intent(this, whatisesport.class);
        intent_about = new Intent(this, about.class);
        intent_roster = new Intent(this, roster.class);
        intent_contact = new Intent(this, contact.class);

        // creating listener for each button and startActivity after onClicked
        btn_wie.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                startActivity(intent_wie);
            }
        });

        btn_roster.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intent_roster);
            }
        });
        btn_contact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {startActivity(intent_contact);
            }
        });
        btn_about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intent_about);
            }
        });


    }
}
