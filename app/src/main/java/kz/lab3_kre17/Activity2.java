package kz.lab3_kre17;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Activity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
    }

    public void onClickButtonPreviously2(View view) {
        setResult(RESULT_OK);
        finish();
    }

    public void onClickButtonNext2(View view) {
        Intent intent = new Intent(Activity2.this, Activity3.class);
        startActivity(intent);
    }
}