package br.com.diastecnologia.calculadoradegorjeta;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    private EditText editValor;
    private TextView textPorcentagem, textGorjeta, textTotal;
    private SeekBar seekBarGorjeta;

    private double porcentagem = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editValor = findViewById(R.id.editValor);
        textGorjeta = findViewById(R.id.textGorjeta);
        textPorcentagem = findViewById(R.id.textPorcentagem);
        textTotal = findViewById(R.id.textTotal);
        seekBarGorjeta = findViewById(R.id.seekBarGorjeta);

        //Adicionar Listener SeekBar
        seekBarGorjeta.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                porcentagem = progress;
                textPorcentagem.setText(Math.round(porcentagem) + " %");
                calcular();

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }
    public void calcular(){
        String valorRecuperado = editValor.getText().toString();
        if (valorRecuperado == null || valorRecuperado.equals("")){
            Toast.makeText(
                    getApplicationContext(),
                    "Digite um valor primeiro!",
                    Toast.LENGTH_SHORT
            ).show();

        }else{
            //Converter String para Double
            double valorDigitado = Double.parseDouble(valorRecuperado);

            //calcula a gorgeta.
            double gorjeta = valorDigitado * (porcentagem/100);
            double total = gorjeta + valorDigitado;

            //exibe gorjeta e o total
            textGorjeta.setText("R$ " + Math.round(gorjeta));
            textTotal.setText("R$ " + total);


        }

    }
}