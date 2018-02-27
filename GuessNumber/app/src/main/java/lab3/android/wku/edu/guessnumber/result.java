package lab3.android.wku.edu.guessnumber;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class result extends AppCompatActivity {
    private int ans;
    private int guess;

    private TextView guessT;
    private TextView ansT;
    private TextView text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        final Intent intent = getIntent();
        text= findViewById(R.id.text);
        ansT = findViewById(R.id.ans);
        guessT = findViewById(R.id.guess);
        ans = randomGen();
        guess = Integer.parseInt(intent.getStringExtra("ans"));
        guessT.setText("" + guess);
        ansT.setText("" + ans);
        if (ans == guess) {
            text.setText("You Are Correct!");
        } else {
            text.setText("Sorry! Nice Try!");
        }
    }


    public int randomGen() {
        return (int)(Math.random() * 10) + 1;
    }
}
