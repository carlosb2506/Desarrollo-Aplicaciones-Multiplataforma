package com.example.ejercicio2;

import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private Button btn_Conectar;
    private EditText Usuario;
    private EditText Contrasenia;
    private TextView txt_intentos;
    private TextView txt_intentosCorrectos;
    private int numIntentos = 0;
    private int conexionesCorrectas = 0;


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

         btn_Conectar = findViewById(R.id.btn_conectar);
         Usuario = findViewById(R.id.Usuario);
         Contrasenia = findViewById(R.id.Password);
         txt_intentos = findViewById(R.id.txt_intentos);
         txt_intentosCorrectos = findViewById(R.id.txt_intentosCorrectos);

    }



    public void pulsarConectar(View view){


        Log.d("Debug", "pulsarConectar: por aqui entra");
        if (Usuario.getText().toString().equals("cbarlop2506@g.educaand.es") && Contrasenia.getText().toString().equals("carlos1234"))
        {
            conexionesCorrectas++;
            Log.d("Debug", "pulsarConectar: Login correcto");
            txt_intentos.setText("Num intentos : " + numIntentos);
            txt_intentosCorrectos.setText("Num Conexiones : " + conexionesCorrectas);
        }
        else {
            numIntentos++;
            txt_intentos.setText("Num intentos : " + numIntentos);
        }
    }
}