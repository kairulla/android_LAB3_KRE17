package kz.lab3_kre17;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Activity2 extends AppCompatActivity {
    Button buttonPreviously2;
    Button buttonNext2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        buttonPreviously2 = (Button) findViewById(R.id.buttonPreviously2);
        buttonPreviously2_OnClickListener();
        buttonNext2 = (Button) findViewById(R.id.buttonNext2);
        buttonNext2_OnClickListener();
    }

    private void buttonPreviously2_OnClickListener() {
        buttonPreviously2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(RESULT_OK);
                finish();
            }
        });
    }

    private void buttonNext2_OnClickListener() {
        buttonNext2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Activity2.this, Activity3.class);
                startActivity(intent);
            }
        });
    }


}