package kz.lab3_kre17;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class Activity1 extends AppCompatActivity {
    private Button buttonNext1;
    private RadioGroup radioGroup;
    private RadioButton radioButtonSelected;
    private ImageView imageView;
    private EditText editTextWhatsYourName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_1);

        imageView = (ImageView) findViewById(R.id.imageView);
        radioGroup = (RadioGroup) findViewById(R.id.radioGroupSocialSet);
        radioGroupOnCheckedChangeListener();
        buttonNext1 = (Button) findViewById(R.id.buttonNext1);
        buttonNext1_OnClickListener();
        editTextWhatsYourName = (EditText) findViewById(R.id.editTextWhatsYourName);
    }

    private void radioGroupOnCheckedChangeListener() {
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch(checkedId){
                    case R.id.radioButtonInstagram:
                        imageView.setBackground(getResources().getDrawable(R.drawable.logo_instagram));
                        break;
                    case R.id.radioButtonVK:
                        imageView.setBackground(getResources().getDrawable(R.drawable.logo_vkontakte));
                        break;
                    case R.id.radioButtonFacebook:
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

                radioButtonSelected = (RadioButton) findViewById(radioGroup.getCheckedRadioButtonId());
                String myName = editTextWhatsYourName.getText().toString().trim();

                if (myName.equals("")) {
                    intent.putExtra("yourName", "нет имени");
                } else {
                    intent.putExtra("yourName", myName);
                }

                try {
                    intent.putExtra("socialSet", radioButtonSelected.getText().toString());
                } catch (Exception ex) {
                    intent.putExtra("socialSet", "не выбрано");
                }

                startActivity(intent);
            }
        });
    }
}