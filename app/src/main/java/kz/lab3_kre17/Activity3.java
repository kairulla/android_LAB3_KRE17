package kz.lab3_kre17;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Activity3 extends AppCompatActivity {
    private Button buttonPreviously3;
    private Button buttonExit3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);

        buttonPreviously3 = (Button) findViewById(R.id.buttonPreviously3);
        buttonPreviously3_OnClickListener();
        buttonExit3 = (Button) findViewById(R.id.buttonExit3);
        buttonExit3_OnClickListener();
    }

    private void buttonPreviously3_OnClickListener() {
        buttonPreviously3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(RESULT_OK);
                finish();
            }
        });
    }

    private void buttonExit3_OnClickListener() {
        buttonExit3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finishAffinity();
            }
        });
    }

}
