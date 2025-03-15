package com.example.unitconverter;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private Spinner sourceUnit;
    private Spinner destinationUnit;
    private EditText inputValue;
    private TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sourceUnit = findViewById(R.id.source_unit);
        destinationUnit = findViewById(R.id.destination_unit);
        inputValue = findViewById(R.id.input_value);
        result = findViewById(R.id.result);

        Button convertButton = findViewById(R.id.convert_button);
        convertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                convertUnits();
            }
        });
    }

    private void convertUnits() {
        String source = sourceUnit.getSelectedItem().toString();
        String destination = destinationUnit.getSelectedItem().toString();
        String input = inputValue.getText().toString();

        if (input.isEmpty()) {
            Toast.makeText(this, "Please enter a value", Toast.LENGTH_SHORT).show();
            return;
        }
        if(!input.matches("\\d+"))
        {
            Toast.makeText(this, "Invalid input", Toast.LENGTH_SHORT).show();
            return;
        }
        double value = Double.parseDouble(input);
        double convertedValue;

        // Length conversions
        if (source.equals("Meter") && destination.equals("Kilometer")) {
            convertedValue = value / 1000;
        } else if (source.equals("Kilometer") && destination.equals("Meter")) {
            convertedValue = value * 1000;
        } else if (source.equals("Mile") && destination.equals("Kilometer")) {
            convertedValue = value * 1.60934;
        } else if (source.equals("Kilometer") && destination.equals("Mile")) {
            convertedValue = value / 1.60934;
        } else if (source.equals("Meter") && destination.equals("Centimeter")) {
            convertedValue = value * 100;
        } else if (source.equals("Centimeter") && destination.equals("Meter")) {
            convertedValue = value / 100;
        } else if (source.equals("Inch") && destination.equals("Centimeter")) {
            convertedValue = value * 2.54;
        } else if (source.equals("Centimeter") && destination.equals("Inch")) {
            convertedValue = value / 2.54;
        } else if (source.equals("Foot") && destination.equals("Meter")) {
            convertedValue = value * 0.3048;
        } else if (source.equals("Meter") && destination.equals("Foot")) {
            convertedValue = value / 0.3048;
        } else if (source.equals("Yard") && destination.equals("Meter")) {
            convertedValue = value * 0.9144;
        } else if (source.equals("Meter") && destination.equals("Yard")) {
            convertedValue = value / 0.9144;
        }
        else if (source.equals("Gram") && destination.equals("Kilogram")) {
            convertedValue = value / 1000;
        } else if (source.equals("Kilogram") && destination.equals("Gram")) {
            convertedValue = value * 1000;
        } else if (source.equals("Pound") && destination.equals("Kilogram")) {
            convertedValue = value * 0.453592;
        } else if (source.equals("Kilogram") && destination.equals("Pound")) {
            convertedValue = value / 0.453592;
        } else if (source.equals("Ounce") && destination.equals("Gram")) {
            convertedValue = value * 28.3495;
        } else if (source.equals("Gram") && destination.equals("Ounce")) {
            convertedValue = value / 28.3495;
        }
        else if (source.equals("Liter") && destination.equals("Milliliter")) {
            convertedValue = value * 1000;
        } else if (source.equals("Milliliter") && destination.equals("Liter")) {
            convertedValue = value / 1000;
        } else if (source.equals("Gallon") && destination.equals("Liter")) {
            convertedValue = value * 3.78541;
        } else if (source.equals("Liter") && destination.equals("Gallon")) {
            convertedValue = value / 3.78541;
        }
        else if (source.equals("Celsius") && destination.equals("Fahrenheit")) {
            convertedValue = (value * 9/5) + 32;
        } else if (source.equals("Fahrenheit") && destination.equals("Celsius")) {
            convertedValue = (value - 32) * 5/9;
        } else {
            Toast.makeText(this, "Not a possible conversion", Toast.LENGTH_SHORT).show();
            return;
        }

        result.setText(String.valueOf(convertedValue));
    }
}
