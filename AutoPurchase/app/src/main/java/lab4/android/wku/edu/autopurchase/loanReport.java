//Created By ChunHei yuen
package lab4.android.wku.edu.autopurchase;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class loanReport extends AppCompatActivity {
    //declare the obj(s)
    Intent loanPage;
    private final double fees = 300; // Current title cost 300
    private final double salesTaxRate = 0.06;
    private double rate;
    private double carPrice;
    private double downPmt;
    int term;
    private TextView[] tv = new TextView[11];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loan_report);
        loanPage = getIntent();
        //Find all the obj by ID
        tv[0] = findViewById(R.id.tv_mPayment);
        tv[1] = findViewById(R.id.tv_carPrice);
        tv[2] = findViewById(R.id.tv_saleTax);
        tv[3] = findViewById(R.id.tv_fees);
        tv[4] = findViewById(R.id.tv_yCost);
        tv[5] = findViewById(R.id.tv_dPayment);
        tv[6] = findViewById(R.id.tv_borAmount);
        tv[7] = findViewById(R.id.tv_rate);
        tv[8] = findViewById(R.id.tv_term);
        tv[9] = findViewById(R.id.tv_totalLoan);
        tv[10] = findViewById(R.id.tv_totalCost);

        // transfer data to double
        rate = Double.parseDouble(loanPage.getStringExtra("value2"));
        carPrice = Double.parseDouble(loanPage.getStringExtra("value0"));
        downPmt = Double.parseDouble(loanPage.getStringExtra("value1"));
        term = Integer.parseInt(loanPage.getStringExtra("terms"));
        //start displays data
        tv[1].setText("$" + String.format("%.2f", carPrice));
        //calculate the salestax
        double salesTax = carPrice * salesTaxRate;
        tv[2].setText("$" + String.format("%.2f", salesTax));
        tv[3].setText("$" + String.format("%.2f", fees));
        //calculate your cost
        double totalYourCost = carPrice + salesTax + fees;
        tv[4].setText("$" + String.format("%.2f", totalYourCost));
        tv[5].setText("$" + String.format("%.2f", downPmt));
        //calculate how much to borrow
        double borrowed = totalYourCost - downPmt;
        tv[6].setText("$" + String.format("%.2f", borrowed));
        tv[7].setText(String.format("%.2f", rate*100) + "%");
        tv[8].setText(term + " years");
        //calculate the monthly payment by calling function calculateLoan
        double monthlyPMT = calculateLoan(borrowed, rate, term);
        tv[0].setText("$" + String.format("%.2f", monthlyPMT));
        //calculate the loan interest
        double loanInterest = monthlyPMT * term * 12 - borrowed;
        tv[9].setText("$" + String.format("%.2f", loanInterest));
        //calcualte the fianl cost
        double totalCost = totalYourCost + loanInterest;
        tv[10].setText("$" + String.format("%.2f", totalCost));

    }
    /*
    A = the monthly payment
    P = the principle
    R = the interest rate per month, which equals the annual interest rate divided by 12
    n = the total numbers of months
     */
    public double calculateLoan(double P, double r, int n) {
        double A; //result
        // Formula
        r = r / 12; // yearly rate divided into monthly
        n = n * 12; // transfer term from year to month
        // Formula to calculate monthly payment
        A = P * (r * Math.pow((1 + r), n)) / (Math.pow((1 + r), n) - 1);
        return A;

    }
}
