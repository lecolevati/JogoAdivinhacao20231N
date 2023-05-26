package br.edu.fateczl.jogoadivinhacao20231n;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText etNumero;
    private Button btnJogar;
    private TextView tvResultado;
    private int valor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNumero = findViewById(R.id.etNumero);
        etNumero.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        btnJogar = findViewById(R.id.btnJogar);
        tvResultado = findViewById(R.id.tvResultado);

        valor = (int)((Math.random() * 100) + 1);
        Log.println(Log.INFO, "Valor gerado", String.valueOf(valor));

        btnJogar.setOnClickListener(x -> jogo());
    }

    private void jogo() {
        String numero = etNumero.getText().toString();
        int num = Integer.parseInt(numero);
        Log.println(Log.INFO, "Valor Digitado", String.valueOf(num));
        if (valor > num) {
            tvResultado.setText(R.string.num_maior);
        } else if (valor < num) {
            tvResultado.setText(R.string.num_menor);
        } else { //Acertou
            Bundle b = new Bundle();
            b.putInt("valor", valor);

            Intent i = new Intent(this, ResActivity.class);
            i.putExtras(b);
            startActivity(i);
            finish();
        }

    }
}