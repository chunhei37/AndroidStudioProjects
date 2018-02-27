//Created by ChunHei yuen

package lab3.android.wku.edu.esportclub;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridLayout;
import android.widget.Spinner;

public class roster extends AppCompatActivity {

   private Spinner spinner;
   private GridLayout lol_list;
   private GridLayout ow_list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_roster);
        spinner = findViewById(R.id.spinner);
        //define the layout for visibility purposes
        lol_list = findViewById(R.id.lol_list);
        ow_list = findViewById(R.id.ow_list);
        //Loading an array of items from the spinner.xml
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.team_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        //load the array of items into the spinner
        spinner.setAdapter(adapter);
        //default the spinner to 0
        spinner.setSelection(0);
        // make the selected item visible
        lol_list.setVisibility(View.VISIBLE);

        //check what did user select to display correct information
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (i == 0) {
                    ow_list.setVisibility(View.GONE);
                    lol_list.setVisibility(View.VISIBLE);
                } else {
                    lol_list.setVisibility(View.GONE);
                    ow_list.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }
}
