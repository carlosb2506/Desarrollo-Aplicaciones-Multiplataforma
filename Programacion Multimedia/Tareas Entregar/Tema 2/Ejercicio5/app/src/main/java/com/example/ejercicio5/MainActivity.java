package com.example.ejercicio5;

import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    private RadioGroup rgOrg, rgDst;
    private TextInputEditText entrada;
    private TextView salida;

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

        rgOrg = findViewById(R.id.rgOrg);
        rgDst = findViewById(R.id.rgDst);
        salida = findViewById(R.id.salida);
        entrada = findViewById(R.id.entrada);
    }

    public void mostrar(View view){
        StringBuilder operaciones = new StringBuilder();
        RadioButton selectedRadioButtonOrg = findViewById(rgOrg.getCheckedRadioButtonId());
        RadioButton selectedRadioButtonDst = findViewById(rgDst.getCheckedRadioButtonId());
        String selectedTextOrg = selectedRadioButtonOrg.getText().toString();
        String selectedTextDst = selectedRadioButtonDst.getText().toString();

        double valor = Double.parseDouble(entrada.getText().toString());

        if (selectedTextOrg.equals(selectedTextDst)){
            salida.setText("Has seleccionado la misma escala origen que destino");
        }else
        {
            if (selectedTextOrg.equals("Celsius") && selectedTextDst.equals("Kelvin")) {
                operaciones.append(valor + 273.15).append(" ").append(selectedTextDst);
            }else if (selectedTextOrg.equals("Celsius") && selectedTextDst.equals("Fahrenheit")) {
                operaciones.append(((valor * 9) / 5) + 32).append(" ").append(selectedTextDst);
            }else if (selectedTextOrg.equals("Kelvin") && selectedTextDst.equals("Celsius")) {
                operaciones.append(valor - 273.15).append(" ").append(selectedTextDst);
            }else if (selectedTextOrg.equals("Kelvin") && selectedTextDst.equals("Fahrenheit")) {
                double celsius = (valor - 273.15);
                operaciones.append(((celsius * 9) / 5) + 32).append(" ").append(selectedTextDst);
            }else if (selectedTextOrg.equals("Fahrenheit") && selectedTextDst.equals("Celsius")) {
                operaciones.append(((valor - 32) * 5 / 9)).append(" ").append(selectedTextDst);
            }else if (selectedTextOrg.equals("Fahrenheit") && selectedTextDst.equals("Kelvin")) {
                operaciones.append(((valor - 32) * 5 / 9) + 273.15).append(" ").append(selectedTextDst);
            }

            salida.setText(operaciones);
        }

    }
}