package kz.lab3_kre17;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class Activity1 extends AppCompatActivity {
    private Button buttonNext1;
    private RadioGroup radioGroup;
    private RadioButton radioButtonSelected;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_1);

        imageView = (ImageView) findViewById(R.id.imageView);
        radioGroup = (RadioGroup) findViewById(R.id.radioGroupSocialSet);
        radioGroupOnCheckedChangeListener();
        buttonNext1 = (Button) findViewById(R.id.buttonNext1);
        buttonNext1_OnClickListener();
    }

    private void radioGroupOnCheckedChangeListener() {
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
//                Log.d("MyDebug", String.valueOf(checkedId));
                switch(checkedId){
                    case 2131231070:
                        imageView.setBackground(getResources().getDrawable(R.drawable.logo_instagram));
                        break;
                    case 2131231071:
                        imageView.setBackground(getResources().getDrawable(R.drawable.logo_vkontakte));
                        break;
                    case 2131231069:
                        imageView.setBackground(getResources().getDrawable(R.drawable.logo_facebook));
                        break;
                }
            }
        });
    }

    private void buttonNext1_OnClickListener() {
        buttonNext1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Activity1.this, Activity2.class);
                startActivity(intent);
            }
        });
    }
}