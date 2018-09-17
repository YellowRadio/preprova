package com.example.arakit.preprova;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import java.lang.reflect.Array;

public class jankenpon extends AppCompatActivity {
    Spinner jspinnerPlayer1,jspinnerPlayer2;
    TextView jtxtResult;
    Button jbtnVerificar;
    ArrayAdapter<CharSequence> jAdapPlayers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        inicializacao();
    }

    private void inicializacao(){
        setContentView(R.layout.activity_jankenpon);
        jAdapPlayers=ArrayAdapter.createFromResource(this,R.array.jankenponspin,android.R.layout.simple_spinner_item);
        jtxtResult = findViewById(R.id.txtResult);
        jbtnVerificar=findViewById(R.id.btnVerificar);
        jspinnerPlayer1 = findViewById(R.id.spinnerPlayer1);
        jspinnerPlayer2 = findViewById(R.id.spinnerPlayer2);
        jAdapPlayers.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        jspinnerPlayer1.setAdapter(jAdapPlayers);
        jspinnerPlayer2.setAdapter(jAdapPlayers);
        jspinnerPlayer1.setSelection(0);
        jspinnerPlayer2.setSelection(0);
        standby();
    }

    private void standby(){
        jbtnVerificar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int choice1,choice2,winner;
                choice1=(int)jspinnerPlayer1.getSelectedItemId();
                choice2=(int)jspinnerPlayer2.getSelectedItemId();
                winner = -1;

                switch(choice1){
                    case 0:
                        if(choice2 == choice1){
                            winner=0;
                        }else if(choice2 ==1) {
                            winner = 2;
                        }else if(choice2 ==2) {
                            winner =1;
                        }
                        break;
                    case 1:
                        if(choice2 == choice1){
                            winner=0;
                        }else if(choice2 ==0) {
                            winner = 1;
                        }else if(choice2 ==2) {
                            winner =2;
                        }
                        break;
                    case 2:
                        if(choice2 == choice1){
                            winner=0;
                        }else if(choice2 ==0) {
                            winner = 2;
                        }else if(choice2 ==1) {
                            winner =1;
                        }
                        break;
                    default:
                        winner=10;
                        break;
                }
                if(winner>0){
                    jtxtResult.setText("Jogador " + winner + " foi o vencedor");
                }else{
                    jtxtResult.setText("Empate");
                }

            }
        });
    }
}
