package com.example.ejercicio6;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private ImageView ivTesoro;
    private Button btnConfirmar;
    private TextView tvRestantes, tvPista;
    private EditText tpNumMax, tpNumMin, tpNumAdv;
    int intentosMax = 10;
    boolean numadivinado;
    int numAdivinar;


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

        ivTesoro = findViewById(R.id.ivTesoro);
        tvRestantes = findViewById(R.id.tvRestantes);
        tpNumMax = findViewById(R.id.tpNumMax);
        tpNumMin = findViewById(R.id.tpNumMin);
        tpNumAdv = findViewById(R.id.tpNumAdv);
        btnConfirmar = findViewById(R.id.btnConfirmar);
        tvPista = findViewById(R.id.tvPista);
        numadivinado = false;


    }

    public void comprobar(View view){
        int numero = 0;
        numAdivinar = Integer.parseInt(tpNumAdv.getText().toString());
        if (numadivinado == false)
        {
            numero = (int) (Math.random() * Integer.parseInt(tpNumMax.getText().toString())) + Integer.parseInt(tpNumMin.getText().toString());
            numadivinado = true;
        }

        if (intentosMax > 0)
        {
            if (numero != numAdivinar) {
                if (numAdivinar < numero) {
                    tvPista.setText("Pista: El numero a adivinar es menor");
                } else {
                    tvPista.setText("Pista: El numero a adivinar es mayor");
                }
            } else
            {
                ivTesoro.setVisibility(View.VISIBLE);
            }
            intentosMax --;
            tvRestantes.setText("Intentos Restantes: " + intentosMax);
        }else {
            btnConfirmar.setEnabled(false);
        }






    }
}