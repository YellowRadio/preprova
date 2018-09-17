package com.example.arakit.preprova;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class temperatura extends AppCompatActivity {
    TextView jtxtRkel,jtxtRFah;
    Button jbtnExibir,jbtnLimpar;
    EditText jedtCelsius;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        inicializar();
    }

    private void inicializar(){
        setContentView(R.layout.activity_temperatura);
        jbtnExibir=findViewById(R.id.btnExibir);
        jtxtRFah=findViewById(R.id.txtRFah);
        jtxtRkel=findViewById(R.id.txtRKel);
        jedtCelsius=findViewById(R.id.edtCelsius);
        jbtnLimpar=findViewById(R.id.btnLimpar);
        standby();
    }

    private void standby(){
        jbtnExibir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double celsius;
                try{
                    celsius =Double.parseDouble(jedtCelsius.getText().toString());
                }catch(Exception e){
                    Toast.makeText(getApplicationContext(),"Preencha o campo celsius", Toast.LENGTH_LONG).show();
                    return;
                }
                double fahrenheit,kelvin;
                fahrenheit=(celsius*9/5)+32;
                kelvin=(celsius+273.15);
                jtxtRFah.setText(String.valueOf(fahrenheit));
                jtxtRkel.setText(String.valueOf(kelvin));
            }
        });

        jbtnLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inicializar();
            }
        });
    }


}
