package com.example.t00569969.unitconverter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Spinner;


public class MainActivity extends AppCompatActivity {
    private Spinner spin1,spin2;
    private Button button;
    private TextView res;
    private EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
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
                //if selectors are same
                CharSequence text = "No conversion to be done!";
                CharSequence empty="Please enter a value";
                if(spin1.getSelectedItem()==spin2.getSelectedItem()){
                    Toast.makeText(getApplicationContext(),text,Toast.LENGTH_LONG).show();
                }
                if(editText.getText().toString().isEmpty()){
                    Toast.makeText(getApplicationContext(),empty,Toast.LENGTH_LONG).show();
                }
                if(spin1.getSelectedItem().toString()=="Fahrenheit"&&spin2.getSelectedItem().toString()=="Celsius"){
                    String num= editText.getText().toString();
                    double d=Double.parseDouble(num);
                    d=((d-32)*(5/9));
                    res.setText(String.valueOf(d));
            }


            }
        });

    }

}
