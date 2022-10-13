package kz.lab3_kre17;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Activity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);
    }

    public void onClickButtonPreviously3(View view) {
        setResult(RESULT_OK);
        finish();
    }

    public void onClickButtonExit3(View view) {
        finishAffinity();
    }
}