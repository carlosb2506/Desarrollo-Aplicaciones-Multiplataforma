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

    private TextView tv_pantalla;
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

        tv_pantalla = findViewById(R.id.tv_pantalla);

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

    public void boton1(View view){
        tv_pantalla.setText(btn1.getText().toString());
    }
    public void boton2(View view){
        tv_pantalla.setText(btn2.getText().toString());
    }
    public void boton3(View view){
        tv_pantalla.setText(btn3.getText().toString());
    }
    public void boton4(View view){
        tv_pantalla.setText(btn4.getText().toString());
    }
    public void boton5(View view){
        tv_pantalla.setText(btn5.getText().toString());
    }
    public void boton6(View view){
        tv_pantalla.setText(btn6.getText().toString());
    }
    public void boton7(View view){
        tv_pantalla.setText(btn7.getText().toString());
    }
    public void boton8(View view){
        tv_pantalla.setText(btn8.getText().toString());
    }
    public void boton9(View view){
        tv_pantalla.setText(btn9.getText().toString());
    }
    public void boton0(View view){
        tv_pantalla.setText(btn0.getText().toString());
    }

    public void opereciones(){
    }

}