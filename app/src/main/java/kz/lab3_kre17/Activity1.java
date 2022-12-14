package kz.lab3_kre17;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;

public class Activity1 extends AppCompatActivity {
    private Button buttonNext1;
    private RadioGroup radioGroup;
    private RadioButton radioButtonSelected;
    private ImageView imageView;
    private EditText editTextWhatsYourName;
    private Spinner spinnerOnlineGameList;
    private Switch switchGender;
    private ImageView imageViewMan, imageViewWoman;

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
        spinnerOnlineGameList = (Spinner) findViewById(R.id.spinnerOnlineGameList);
        switchGender = (Switch) findViewById(R.id.switchGender);
        imageViewMan = (ImageView) findViewById(R.id.imageViewMan);
        imageViewWoman = (ImageView) findViewById(R.id.imageViewWoman);

        switchGenderOnCheckedChangeListener();
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

    private void switchGenderOnCheckedChangeListener() {
        switchGender.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Log.v("Switch state = ", String.valueOf(isChecked));
                if(isChecked){
                    imageViewMan.setVisibility(View.VISIBLE);
                    imageViewWoman.setVisibility(View.GONE);
                } else {
                    imageViewWoman.setVisibility(View.VISIBLE);
                    imageViewMan.setVisibility(View.GONE);
                }
            }
        });
    }

    private void buttonNext1_OnClickListener() {
        buttonNext1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Activity1.this, Activity2.class);

                String myName = (String) editTextWhatsYourName.getText().toString().trim();
                if (myName.equals("")) {
                    intent.putExtra("editTextWhatsYourName", "?????? ??????????");
                } else {
                    intent.putExtra("editTextWhatsYourName", myName);
                }

                radioButtonSelected = (RadioButton) findViewById(radioGroup.getCheckedRadioButtonId());
                try {
                    intent.putExtra("radioButtonSelected", radioButtonSelected.getText().toString());
                } catch (Exception ex) {
                    intent.putExtra("radioButtonSelected", "???? ??????????????");
                }

                intent.putExtra("spinnerOnlineGameList", spinnerOnlineGameList.getSelectedItem().toString());

                if (switchGender.isChecked()) {
                    intent.putExtra("switchGender", getResources().getString(R.string.Man));
                } else {
                    intent.putExtra("switchGender", getResources().getString(R.string.Woman));
                }

                startActivity(intent);
            }
        });
    }
}