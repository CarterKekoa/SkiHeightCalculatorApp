package com.example.skisnowboardlength;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.text.DecimalFormat;

// <div>Icons made by <a href="https://www.flaticon.com/authors/freepik" title="Freepik">Freepik</a> from <a href="https://www.flaticon.com/"             title="Flaticon">www.flaticon.com</a></div>

public class LengthActivity extends AppCompatActivity {

    private static final double CM_PER_INCH = 2.54;
    private static final double SKI_LENGTH_MULTIPLIER = 0.95;
    private static final double SNOWBOARD_LENGTH_MULTIPLIER = 0.88;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_length);


        Button backButton = (Button) findViewById(R.id.backButton);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LengthActivity.this.finish();
            }
        });

        // alternative to using XML onClick for checkbox state change
//        CheckBox checkBox = (CheckBox) findViewById(R.id.snowboardCheckBox);
//        checkBox.setOnCheckedChangeListener(new CheckBox.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
//                if (b) {
//                    computeSnowboardLength();
//                }
//                else {
//                    computeSkiLength();
//                }
//            }
//        });
        computeSnowboardLength();

    }

    public void onClick(View view) {
        CheckBox box = (CheckBox) view;
        boolean b = box.isChecked();
        if (b) {
            computeSnowboardLength();
        }
        else {
            computeSkiLength();
        }
        // bonus solution
//        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
//        int id = radioGroup.getCheckedRadioButtonId();
//        switch (id) {
//            case R.id.skiRadioButton:
//                computeSkiLength();
//                break;
//            case R.id.snowboardRadioButton:
//                computeSnowboardLength();
//                break;
//        }
    }

    private double getCM() {
        double heightCM = 0.0;
        Intent intent = getIntent();
        if (intent != null) {
            double heightInches = intent.getDoubleExtra("height", 0.0);
            heightCM = CM_PER_INCH * heightInches;
        }
        return heightCM;
    }

    private void computeSnowboardLength() {
        double heightCM = getCM();
        double snowboardLength = SNOWBOARD_LENGTH_MULTIPLIER * heightCM;

        TextView snowboardTextView = (TextView) findViewById(R.id.snowboardLengthTextView);
        DecimalFormat df = new DecimalFormat("0"); // alternative is to use Math.round()
        snowboardTextView.setText("You should ride a snowboard that is roughly " + df.format(snowboardLength) + "cm long");
        ImageView snowboardImageView = (ImageView) findViewById(R.id.snowboardImageView);
        snowboardImageView.setImageResource(R.drawable.snowboard);

    }

    private void computeSkiLength() {
        double heightCM = getCM();
        double skiLength = SKI_LENGTH_MULTIPLIER * heightCM;

        TextView snowboardTextView = (TextView) findViewById(R.id.snowboardLengthTextView);
        DecimalFormat df = new DecimalFormat("0"); // alternative is to use Math.round()
        snowboardTextView.setText("You should ride skis that are roughly " + df.format(skiLength) + "cm long");
        ImageView snowboardImageView = (ImageView) findViewById(R.id.snowboardImageView);
        snowboardImageView.setImageResource(R.drawable.skiing);
    }
}
