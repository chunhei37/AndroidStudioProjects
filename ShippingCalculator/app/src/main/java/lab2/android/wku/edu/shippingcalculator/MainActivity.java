package lab2.android.wku.edu.shippingcalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Gravity;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    //Input text
    private String inputText;

    //Text Elements
    private TextView bcost;
    private TextView acost;
    private TextView tcost;

    //Cost
    private double baseCost;
    private double addCost;
    private double totalCost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText in = (EditText) findViewById(R.id.weighTextWatcher);

        //Define to object
        bcost = (TextView) findViewById(R.id.bcost);
        acost = (TextView) findViewById(R.id.acost);
        tcost = (TextView) findViewById(R.id.tcost);

        // edittext listener
        in.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                //Read user input text
                inputText = in.getText().toString();
                //Exception on convert string to double
                try {
                    calculateCost(Double.parseDouble(inputText));
                } catch (Exception e) {
                    inputText = "0";
                }
                //Update Text
                bcost.setText("$" + String.format("%.02f", baseCost));
                acost.setText("$" + String.format("%.02f", addCost));
                tcost.setText("$" + String.format("%.02f", totalCost));
            }

            @Override
            public void afterTextChanged(Editable editable) {}
        });
    }

    // Rest all cost to 0
    protected void reset() {
        baseCost = 0;
        totalCost = 0;
        addCost = 0;
    }

    // A method to calculate the shipping cost
    protected void calculateCost(double weight) {
        reset(); //rest all cost to 0
        if(weight > 0) {
            baseCost = 3; // weight less than 16 ounces will have only $3.00 base cost
            if(weight > 16) {
                if(weight > 30) {
                    baseCost = 4; // set base cost to $4.00, due to weight more than 30 ounces
                }
                addCost = (int)((weight - 17) / 4 + 1) * 0.5; // for each additional four ounces charge $0.5 more
            }
        }
        //sum up all cost
        totalCost += baseCost + addCost;
    }
}



