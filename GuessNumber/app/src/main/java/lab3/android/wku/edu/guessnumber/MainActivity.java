package lab3.android.wku.edu.guessnumber;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private Button submit;
    private Intent result_page;
    private EditText ans;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        submit = findViewById(R.id.button);
        ans = findViewById(R.id.editText);
        result_page = new Intent(this, result.class);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                result_page.putExtra("ans", ans.getText().toString());
                startActivity(result_page);
            }
        });


    }
}
