package br.com.local.listapersonagens;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class MostrarPersonagemActivity extends AppCompatActivity {
    TextView txtPersonagens;
    TextView descPersonagens;
    ImageView imgPersonagens;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mostrar_personagem_layout);

        txtPersonagens = findViewById(R.id.mtxtPersonagem);
        imgPersonagens = findViewById(R.id.mimgPersonagem);
        descPersonagens = findViewById(R.id.mdescPersonagem);

        Intent intent = getIntent();

        String nPersonagem = intent.getStringExtra("nomePersonagens");
        int mPersonagem = intent.getIntExtra("imgPersonagens", 0);
        String dPersonagem = intent.getStringExtra("descPersonagens");

        txtPersonagens.setText(nPersonagem);
        imgPersonagens.setImageResource(mPersonagem);
        descPersonagens.setText(dPersonagem);
    }


}