package lab4.android.wku.edu.BMICalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class ans extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ans);
    }

    @Override
    protected void onStart() {
        super.onStart();
        overridePendingTransition(R.anim.question_out, R.anim.answer_in);
        }

}
