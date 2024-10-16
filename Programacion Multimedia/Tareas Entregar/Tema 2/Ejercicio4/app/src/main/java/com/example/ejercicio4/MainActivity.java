package com.example.ejercicio4;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private TextView tvResultado;
    private Button btn0, btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9;

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

        tvResultado = findViewById(R.id.tvResultados);

        btn0 = findViewById(R.id.btn0);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btn9 = findViewById(R.id.btn9);



    }

    public void botonPulsado(View view){
        String cadena = "";
        if (view == btn0) {
            cadena = tvResultado.getText().toString() + btn0.getText().toString();
        } else if (view == btn1) {
            cadena = tvResultado.getText().toString() + btn1.getText().toString();
        } else if (view == btn2) {
            cadena = tvResultado.getText().toString() + btn2.getText().toString();
        } else if (view == btn3) {
            cadena = tvResultado.getText().toString() + btn3.getText().toString();
        } else if (view == btn4) {
            cadena = tvResultado.getText().toString() + btn4.getText().toString();
        } else if (view == btn5) {
            cadena = tvResultado.getText().toString() + btn5.getText().toString();
        } else if (view == btn6) {
            cadena = tvResultado.getText().toString() + btn6.getText().toString();
        } else if (view == btn7) {
            cadena = tvResultado.getText().toString() + btn7.getText().toString();
        } else if (view == btn8) {
            cadena = tvResultado.getText().toString() + btn8.getText().toString();
        } else if (view == btn9) {
            cadena = tvResultado.getText().toString() + btn9.getText().toString();
        }
        tvResultado.setText(cadena);
    }

}