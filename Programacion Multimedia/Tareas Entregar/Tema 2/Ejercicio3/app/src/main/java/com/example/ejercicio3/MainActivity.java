package com.example.ejercicio3;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private TextView tv_resul;
    private RadioButton rbt_tabla1, rbt_tabla2,rbt_tabla3,rbt_tabla4,rbt_tabla5,rbt_tabla6,rbt_tabla7,rbt_tabla8,rbt_tabla9,rbt_tabla10;
    private Button btn_mostrarResultado;

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

        tv_resul = findViewById(R.id.tv_result);
        btn_mostrarResultado = findViewById(R.id.btn_mostrarResultado);
        rbt_tabla1 = findViewById(R.id.rbt_tabla1);
        rbt_tabla2 = findViewById(R.id.rbt_tabla2);
        rbt_tabla3 = findViewById(R.id.rbt_tabla3);
        rbt_tabla4 = findViewById(R.id.rbt_tabla4);
        rbt_tabla5 = findViewById(R.id.rbt_tabla5);
        rbt_tabla6 = findViewById(R.id.rbt_tabla6);
        rbt_tabla7 = findViewById(R.id.rbt_tabla7);
        rbt_tabla8 = findViewById(R.id.rbt_tabla8);
        rbt_tabla9 = findViewById(R.id.rbt_tabla9);
        rbt_tabla10 = findViewById(R.id.rbt_tabla10);
    }

    public void  mostrarResultado(View view){
        int num = 0;
        StringBuilder resultados = new StringBuilder();

        if (rbt_tabla1.isChecked())
        {
            do{
                num++;
                int resul = 1 * num;
                resultados.append("1 x ").append(num).append(" = ").append(resul).append("\n");
            } while (num < 10);

        } else if (rbt_tabla2.isChecked())
        {
            do{
                num++;
                int resul = 2 * num;
                resultados.append("2 x ").append(num).append(" = ").append(resul).append("\n");
            } while (num < 10);

        }
        else if (rbt_tabla3.isChecked())
        {
            do{
                num++;
                int resul = 3 * num;
                resultados.append("3 x ").append(num).append(" = ").append(resul).append("\n");
            } while (num < 10);

        }
        else if (rbt_tabla4.isChecked())
        {
            do{
                num++;
                int resul = 4 * num;
                resultados.append("4 x ").append(num).append(" = ").append(resul).append("\n");
            } while (num < 10);

        }else if (rbt_tabla5.isChecked())
        {
            do{
                num++;
                int resul = 5 * num;
                resultados.append("5 x ").append(num).append(" = ").append(resul).append("\n");
            } while (num < 10);

        }else if (rbt_tabla6.isChecked())
        {
            do{
                num++;
                int resul = 6 * num;
                resultados.append("6 x ").append(num).append(" = ").append(resul).append("\n");
            } while (num < 10);

        }else if (rbt_tabla7.isChecked())
        {
            do{
                num++;
                int resul = 7 * num;
                resultados.append("7 x ").append(num).append(" = ").append(resul).append("\n");
            } while (num < 10);

        }else if (rbt_tabla8.isChecked())
        {
            do{
                num++;
                int resul = 8 * num;
                resultados.append("8 x ").append(num).append(" = ").append(resul).append("\n");
            } while (num < 10);

        }else if (rbt_tabla9.isChecked())
        {
            do{
                num++;
                int resul = 9 * num;
                resultados.append("9 x ").append(num).append(" = ").append(resul).append("\n");
            } while (num < 10);

        }else if (rbt_tabla10.isChecked())
        {
            do{
                num++;
                int resul = 10 * num;
                resultados.append("10 x ").append(num).append(" = ").append(resul).append("\n");
            } while (num < 10);

        }
        tv_resul.setText(resultados);
    }
}