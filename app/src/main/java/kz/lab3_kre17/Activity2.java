package kz.lab3_kre17;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Activity2 extends AppCompatActivity {
    private Button buttonPreviously2;
    private Button buttonNext2;

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

                intent.putExtra("yourName", getIntent().getStringExtra("yourName"));
                intent.putExtra("socialSet", getIntent().getStringExtra("socialSet"));

                startActivity(intent);
            }
        });
    }


}