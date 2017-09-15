package com.example.t00569969.unitconverter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Spinner;

import java.text.DecimalFormat;


public class MainActivity extends AppCompatActivity {
    private Spinner spin1,spin2;
    private Button button;
    private TextView res;
    private EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
       final DecimalFormat df = new DecimalFormat("#.##");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         button = (Button) findViewById(R.id.button);
         spin1 = (Spinner) findViewById(R.id.spinner);
         spin2= (Spinner)  findViewById(R.id.spinner2);
        res= (TextView)  findViewById(R.id.textView5);
        editText = (EditText) findViewById(R.id.editText);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //if selectors are same//works
                if (spin1.getSelectedItem() == spin2.getSelectedItem()) {
                    Toast.makeText(getApplicationContext(), "No conversion to be done!", Toast.LENGTH_LONG).show();
                }
                //works
                if (editText.getText().toString().isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Please enter a value", Toast.LENGTH_LONG).show();
                }
                //idk
                double input = 0.0;
                if (!editText.getText().toString().isEmpty()) {
                    input = Double.parseDouble(editText.getText().toString());


                    if (spin1.getSelectedItem().toString().contains("Celsius") && spin2.getSelectedItem().toString().contains("Fahrenheit")) {
                        res.setText(df.format(cToF(input)));
                    }
                    if (spin1.getSelectedItem().toString().contains("Fahrenheit") && spin2.getSelectedItem().toString().contains("Celsius")) {
                        res.setText(df.format(fToC(input)));
                    }

                }
            }
        });

    }
    private double fToC (double input)
    {
        return (5.0 / 9 * ( input - 32));
    }

    private double cToF (double input)
    {
        return (9.0 / 5 * input + 32);
    }
}
