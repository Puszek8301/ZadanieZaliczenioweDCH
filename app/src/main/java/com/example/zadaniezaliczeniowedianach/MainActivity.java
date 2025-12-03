package com.example.zadaniezaliczeniowedianach;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {


    EditText nameET;
    EditText lastNameET;
    Spinner spinner;
    EditText charAmountET;
    CheckBox checkBox1;
    CheckBox checkBox2;
    CheckBox checkBox3;
    Button generatePasswordBTN;
    Button commitBTN;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        nameET = findViewById(R.id.name);
        lastNameET = findViewById(R.id.lastName);
        spinner = findViewById(R.id.spinner);
        charAmountET = findViewById(R.id.charAmount);
        checkBox1 = findViewById(R.id.checkbox1);
        checkBox2 = findViewById(R.id.checkbox2);
        checkBox3 = findViewById(R.id.checkbox3);
        generatePasswordBTN = findViewById(R.id.gereratePasswordBTN);
        commitBTN = findViewById(R.id.commitBTN);
        String[] positions = {"Kierownik", "Starszy programista", "Młodszy programista", "Tester"};
        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, positions);
        spinner.setAdapter(spinnerAdapter);


    }
}