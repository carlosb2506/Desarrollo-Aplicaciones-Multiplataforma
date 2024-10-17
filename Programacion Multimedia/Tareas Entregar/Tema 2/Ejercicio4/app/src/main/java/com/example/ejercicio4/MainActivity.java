package com.example.ejercicio4;

import android.os.Bundle;
import android.util.Log;
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
    private Button btn0, btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9, btnSumar, btnRestar, btnMultiplicar, btnDividir, btnIgual;
    private  int visor,resultado;
    private  String opAnterior;
    String cadena ;
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
        btnSumar = findViewById(R.id.btnSumar);
        btnDividir = findViewById(R.id.btnDividir);
        btnRestar = findViewById(R.id.btnRestar);
        btnMultiplicar = findViewById(R.id.btnMultiplicar);
        btnIgual = findViewById(R.id.btnIgual);
        resultado = 0;
        visor = 0;
        cadena="";
        opAnterior = null;

    }

    public void botonPulsado(View view){
        Log.d("TAG", "debug: por aqui pasa " + cadena);
        if (view == btn0) {
            cadena = cadena + btn0.getText().toString();
        } else if (view == btn1) {
            cadena = cadena + btn1.getText().toString();
        } else if (view == btn2) {
            cadena = cadena + btn2.getText().toString();
        } else if (view == btn3) {
            cadena = cadena + btn3.getText().toString();
        } else if (view == btn4) {
            cadena = cadena + btn4.getText().toString();
        } else if (view == btn5) {
            cadena = cadena + btn5.getText().toString();
        } else if (view == btn6) {
            cadena = cadena + btn6.getText().toString();
        } else if (view == btn7) {
            cadena = cadena + btn7.getText().toString();
        } else if (view == btn8) {
            cadena = cadena + btn8.getText().toString();
        } else if (view == btn9) {
            cadena = cadena + btn9.getText().toString();
        }
        tvResultado.setText(cadena);
    }

    public void operaciones(View view){
        visor = Integer.parseInt(tvResultado.getText().toString());

        if (opAnterior == null){
            resultado = visor;
        }
        else if (opAnterior.equals(btnSumar.getText().toString())){
            resultado = visor + resultado;
        } else if (opAnterior.equals(btnRestar.getText().toString())){
            resultado = resultado - visor;
        } else if (opAnterior.equals(btnMultiplicar.getText().toString())){
            resultado = resultado * visor;
        }
        else if (opAnterior.equals(btnDividir.getText().toString())){
            resultado = resultado / visor;
        }



        if (view == btnSumar) {
            opAnterior = btnSumar.getText().toString();
        } else if (view == btnRestar) {
            opAnterior = btnRestar.getText().toString();
        }
        else  if (view == btnMultiplicar) {
            opAnterior = btnMultiplicar.getText().toString();
        }
        else if (view == btnDividir) {
            opAnterior = btnDividir.getText().toString();
        }
        else if (view == btnIgual){
            opAnterior = null;
        }
        cadena = "";
        tvResultado.setText(Integer.toString(resultado));
    }

}