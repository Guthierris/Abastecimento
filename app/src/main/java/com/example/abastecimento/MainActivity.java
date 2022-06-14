package com.example.abastecimento;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    private EditText PreçoAlcool, PreçoGasolina;
    private TextView resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        PreçoAlcool = findViewById(R.id.textalcool);
        PreçoGasolina = findViewById(R.id.textgasolina);
        resultado = findViewById(R.id.resultado);

    }

    public void CalcularPreço(View view) {

        String EdittextAlcool = PreçoAlcool.getText().toString();
        String EdittextGasolina = PreçoGasolina.getText().toString();
        boolean CamposValidos = validarCampos(EdittextAlcool, EdittextGasolina);
        if (CamposValidos) {
            Double ValorAlcool = Double.parseDouble(EdittextAlcool);
            Double ValorGasolina = Double.parseDouble(EdittextGasolina);
            Double resul = ValorAlcool / ValorGasolina;
            if (resul >= 0.7) {
                resultado.setText("É melhor utilizar gasolina");
            } else {
                resultado.setText("É melhor utilizar Etanol");
            }
        } else {
            resultado.setText("Preencha os campos primeiro");
        }
    }

    public boolean validarCampos(String pAlcool, String pGasolina) {
        boolean camposValidos = true;
        if (pAlcool == null || pAlcool.equals("")) {
            camposValidos = false;
        } else if (pGasolina == null || pGasolina.equals("")) {
            camposValidos = false;
        }
        return camposValidos;
    }
}