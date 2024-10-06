package com.example.calculadoranueva;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText mostrador;
    private String operacion_actual = "";
    private double primer_numero = 0;
    private boolean operador_presionado = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mostrador = findViewById(R.id.mostrador);


        findViewById(R.id.button0).setOnClickListener(this::numeroPresionado);
        findViewById(R.id.button1).setOnClickListener(this::numeroPresionado);
        findViewById(R.id.button2).setOnClickListener(this::numeroPresionado);
        findViewById(R.id.button3).setOnClickListener(this::numeroPresionado);
        findViewById(R.id.button4).setOnClickListener(this::numeroPresionado);
        findViewById(R.id.button5).setOnClickListener(this::numeroPresionado);
        findViewById(R.id.button6).setOnClickListener(this::numeroPresionado);
        findViewById(R.id.button7).setOnClickListener(this::numeroPresionado);
        findViewById(R.id.button8).setOnClickListener(this::numeroPresionado);
        findViewById(R.id.button9).setOnClickListener(this::numeroPresionado);

        findViewById(R.id.buttonSumar).setOnClickListener(this::operadorPresionado);
        findViewById(R.id.buttonRestar).setOnClickListener(this::operadorPresionado);
        findViewById(R.id.buttonMultiplicar).setOnClickListener(this::operadorPresionado);
        findViewById(R.id.buttonDividir).setOnClickListener(this::operadorPresionado);

        findViewById(R.id.buttonLimpiar).setOnClickListener(v -> limpiar());

        findViewById(R.id.buttonIgual).setOnClickListener(v -> calcularResultado());
    }

    private void numeroPresionado(View view) {
        if (operador_presionado) {
            mostrador.setText("");
            operador_presionado = false;
        }

        Button button = (Button) view;
        String texo_actual = mostrador.getText().toString();
        mostrador.setText(texo_actual + button.getText().toString());
    }

    private void operadorPresionado(View view) {
        Button button = (Button) view;
        operacion_actual = button.getText().toString();
        primer_numero = Double.parseDouble(mostrador.getText().toString());
        operador_presionado = true;
    }

    private void calcularResultado() {
        double segundo_numero = Double.parseDouble(mostrador.getText().toString());
        double resultado = 0;

        switch (operacion_actual) {
            case "+":
                resultado = primer_numero + segundo_numero;
                break;
            case "-":
                resultado = primer_numero - segundo_numero;
                break;
            case "*":
                resultado = primer_numero * segundo_numero;
                break;
            case "/":
                if (segundo_numero != 0) {
                    resultado = primer_numero / segundo_numero;
                } else {
                    mostrador.setText("Error");
                    return;
                }
                break;
        }

        mostrador.setText(String.valueOf(resultado));
    }

    private void limpiar() {
        mostrador.setText("");
        primer_numero = 0;
        operador_presionado = false;
    }
}
