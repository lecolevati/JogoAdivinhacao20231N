package br.edu.fateczl.jogoadivinhacao20231n;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ResActivity extends AppCompatActivity {

    private TextView tvTextoRes;
    private Button btnVoltar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_res);

        tvTextoRes = findViewById(R.id.tvTextoRes);
        btnVoltar = findViewById(R.id.btnVoltar);

        Intent i = getIntent();
        Bundle b = i.getExtras();
        int valor = b.getInt("valor");

        String msg = getResources().getString(R.string.acertou);
        msg = msg + " " + valor;
        tvTextoRes.setText(msg);

        btnVoltar.setOnClickListener(y -> voltar());

        Toast.makeText(this, R.string.parabens, Toast.LENGTH_LONG).show();
    }

    private void voltar() {
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
        finish();
    }
}