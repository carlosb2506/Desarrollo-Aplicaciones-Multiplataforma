package com.example.ejercicio1;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private RadioGroup rgOpc;

    private TextView tvSalida;
    private CheckBox cbAndorid, cbIphone;

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

        rgOpc = findViewById(R.id.rgOpc);
        tvSalida = findViewById(R.id.tvSalida);
        cbAndorid = findViewById(R.id.cbAndroid);
        cbIphone = findViewById(R.id.cbIphone);
    }

    public void mostrar(View view){

        StringBuilder cadena = new StringBuilder();
        RadioButton selectedRgOpc = findViewById(rgOpc.getCheckedRadioButtonId());

        String selectedTextOpc = selectedRgOpc.getText().toString();

        if (cbIphone.isChecked()) {
            cadena.append(cbIphone.getText()).append("\n");
        } if (cbAndorid.isChecked()){
            cadena.append(cbAndorid.getText()).append("\n");
        }
        cadena.append(selectedTextOpc);
        tvSalida.setText(cadena);
    }
}