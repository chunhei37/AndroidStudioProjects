//Created By ChunHei yuen
package lab4.android.wku.edu.autopurchase;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    //declare obj(s)
    private EditText[] editText = new EditText[3];
    private Intent loanPage;
    private Button submit;
    private RadioButton[] radioButton = new RadioButton[3];
    private int year = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //execute the transition
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out); //fade in and fade out animation, it's hard to spot. But it will make the app looks smoother.
        //button to submit
        submit = (Button) findViewById(R.id.submit_btn);
        //new intent to display the report
        loanPage = new Intent(this, loanReport.class);
        //Assign edittext in a loop
        for(int i = 0; i < 3; i++) {
            String name = "editText" + (i + 1);
            int id = getResources().getIdentifier(name, "id", getPackageName());
            editText[i] = (EditText) findViewById(id);
        }
        //Assign radiobutton in a loop
        for(int i = 0; i < 3; i++) {
            String name = "radioButton" + (i + 1);
            int id = getResources().getIdentifier(name, "id", getPackageName());
            radioButton[i] = (RadioButton) findViewById(id);
        }
        //listener for the submit button
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int err = 0;
                //put the data into intent
                for(int i = 0; i < 3; i++) {
                    String name = "value" + i;
                    String temp = editText[i].getText().toString();
                    //prevent blank and non-digit input
                    if(!temp.matches("")) {
                        loanPage.putExtra(name, editText[i].getText().toString());
                    } else {
                        err++;
                    }
                }
                if(err > 0) {
                    //Display error msg
                    Toast errMsg = Toast.makeText(getApplicationContext(), "Invalid Input! Check Your Input.", Toast.LENGTH_LONG);
                    errMsg.setGravity(Gravity.CENTER, 0, 0); // make it show in middle
                    errMsg.show();
                } else {
                    //passing the radio value
                    loanPage.putExtra("terms", ""+year);
                    startActivity(loanPage); //loading to the new page
                    //execute the transition
                    overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the main_menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    //control the menu item in the action bar
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()) {
            case R.id.quit:
                //quit the application
                finish();
                System.exit(0);
                break;
            default:
                return super.onOptionsItemSelected(item);
        }

        return true;
    }

    // listener for the radion buttons, will call this function for each click
    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();
        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.radioButton1:
                if(checked) {
                    year = 2;
                    break;
                }
            case R.id.radioButton2:
                if(checked) {
                    year = 3;
                    break;
                }
            case R.id.radioButton3:
                if(checked) {
                    year = 5;
                    break;
                }
        }
    }
}
