package com.example.dieseltrak;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //Declare our varibles

    EditText etOpName;
    EditText etMachCode;
    EditText etHours;
    EditText etOpen;
    EditText etClosing;
    Button btnDispense;
    Button btnCancel;
    TextView tvDisplay;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //connecting our buttons to activity_main
        etOpName = findViewById(R.id.etOpName);
        etMachCode = findViewById(R.id.etMachCode);
        etHours = findViewById(R.id.etHours);
        etOpen = findViewById(R.id.etOpen);
        etClosing = findViewById(R.id.etClosing);
        btnDispense = findViewById(R.id.btnDispense);
        btnCancel = findViewById(R.id.btnCancel);
        tvDisplay =  findViewById(R.id.tvDisplay);

        tvDisplay.setVisibility(View.GONE);

        btnDispense.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //if no values are populated

                if(etOpName.getText().toString().isEmpty() || etMachCode.getText().toString().isEmpty() || etHours.getText().toString().isEmpty() || etOpen.getText().toString().isEmpty() ||
                etClosing.getText().toString().isEmpty()){
                    Toast.makeText(MainActivity.this, "Please enter all fields", Toast.LENGTH_SHORT).show();
                }else{
                    String name = etOpName.getText().toString().trim();
                    String code = etMachCode.getText().toString().trim();
                    Double hours  = Double.parseDouble(etHours.getText().toString());
                    int opening = Integer.parseInt(etOpen.getText().toString());
                    int closing = Integer.parseInt(etClosing.getText().toString());

                    //to ensure that closing is not greater than opening
                    if(closing > opening){
                        int results = closing - opening;
                        String message = "Operator Name:"+name+"\n" + "Machine Code:" +code+ "\n" + "Total Fuel Dispensed:"+results+"\n"+ "machine hours :" +hours;

                        Intent intent = new Intent(MainActivity.this,com.example.dieseltrak.Dispense.class);
                        intent.putExtra("data",message);
                        startActivity(intent);
                        /*
                        tvDisplay.setText(message);
                        tvDisplay.setVisibility(View.VISIBLE);

                         */
                    }else {
                        Toast.makeText(MainActivity.this,"Invalid re-enter opening and closing meter",Toast.LENGTH_SHORT).show();
                    }





                }




            }
        });
    }
}