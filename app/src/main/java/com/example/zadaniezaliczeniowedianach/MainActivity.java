package com.example.zadaniezaliczeniowedianach;

import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {


    EditText nameET = findViewById(R.id.name);
    EditText lastNameET = findViewById(R.id.lastName);
    Spinner spinner = findViewById(R.id.spinner);
    CheckBox checkBox1 = findViewById(R.id.checkbox1);
    CheckBox checkBox2 = findViewById(R.id.checkbox2);
    CheckBox checkBox3 = findViewById(R.id.checkbox3);
    Button generatePasswordBTN = findViewById(R.id.gereratePasswordBTN);
    Button commitBTN = findViewById(R.id.commitBTN);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
}