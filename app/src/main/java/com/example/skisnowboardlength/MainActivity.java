package com.example.skisnowboardlength;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText heightEditText = (EditText) findViewById(R.id.heightEditText);
        Button calculateButton = (Button) findViewById(R.id.calculateButton);
        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String heightStr = heightEditText.getText().toString();
                try {
                    double value = Double.parseDouble(heightStr);
                    Intent intent = new Intent(MainActivity.this, LengthActivity.class);
                    intent.putExtra("height", value);
                    startActivity(intent);
                } catch (NumberFormatException e) {
                    Toast.makeText(MainActivity.this, "That is not a number, try again", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
