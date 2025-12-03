package com.example.zadaniezaliczeniowedianach;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class MainActivity extends AppCompatActivity {


    EditText nameET;
    EditText lastNameET;
    Spinner spinner;
    EditText charAmountET;
    CheckBox checkBox1;
    CheckBox checkBox2;
    CheckBox checkBox3;
    Button generatePasswordBTN;
    Button submitBTN;
    String generatedPassword = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        nameET = findViewById(R.id.name);
        lastNameET = findViewById(R.id.lastName);
        spinner = findViewById(R.id.spinner);
        charAmountET = findViewById(R.id.charAmount);
        checkBox1 = findViewById(R.id.checkbox1);
        checkBox2 = findViewById(R.id.checkbox2);
        checkBox3 = findViewById(R.id.checkbox3);
        generatePasswordBTN = findViewById(R.id.gereratePasswordBTN);
        submitBTN = findViewById(R.id.submitBTN);


        String[] positions = {"Kierownik", "Starszy programista", "Młodszy programista", "Tester"};
        ArrayAdapter<String> spinnerPosition = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, positions);
        spinner.setAdapter(spinnerPosition);

        String lowerLetters = "abcdefghijklmnopqrstuvwxyz";
        String upperLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String digits = "0123456789";
        String specialChars = "!@#$%^&*()_+-=";

        generatePasswordBTN.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                int length = Integer.parseInt(charAmountET.getText().toString());
                String password = "";
                Random random = new Random();

                for (int i = 0; i < length; i++) {
                    int index = random.nextInt(lowerLetters.length());
                    char c = lowerLetters.charAt(index);
                    password = password + c;
                }

                if (checkBox1.isChecked()) {
                    int index = random.nextInt(upperLetters.length());
                    char c = upperLetters.charAt(index);
                    password = password + c;
                }
                if (checkBox2.isChecked()) {
                    int index = random.nextInt(digits.length());
                    char c = digits.charAt(index);
                    password = password + c;
                }
                if (checkBox3.isChecked()) {
                    int index = random.nextInt(specialChars.length());
                    char c = specialChars.charAt(index);
                    password = password + c;
                }

                generatedPassword = password;
                AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
                dialog.setTitle("Wygenerowane hasło");
                dialog.setMessage(generatedPassword);
                dialog.setPositiveButton("OK", null);
                dialog.show();

            }
        });

        submitBTN.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {

                String name = nameET.getText().toString();
                String lastName = lastNameET.getText().toString();
                String position = spinner.getSelectedItem().toString();

                AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
                dialog.setTitle("Dane pracownika");
                dialog.setMessage("Imię: "+ name + "\n" +
                        "Nazwisko: " + lastName + "\n" +
                        "Stanowisko: " + position + "\n" +
                        "Hasło: " + generatedPassword
                        );
                dialog.setPositiveButton("OK", null);
                dialog.show();


            }
        });


    }
}