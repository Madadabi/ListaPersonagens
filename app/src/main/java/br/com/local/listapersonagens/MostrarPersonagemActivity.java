package br.com.local.listapersonagens;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class MostrarPersonagemActivity extends AppCompatActivity {
    TextView textoPersonagem;
    TextView descricaoPersonagem;
    ImageView imagemPersonagem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mostrar_personagem_layout);

        boolean isClickedMugiwara = getIntent().getExtras().getBoolean("isClickedMugiwara");
        boolean isClickedBigMom = getIntent().getExtras().getBoolean("isClickedBigMom");

        textoPersonagem = findViewById(R.id.mtxtPersonagem);
        imagemPersonagem = findViewById(R.id.mimgPersonagem);
        descricaoPersonagem = findViewById(R.id.mdescPersonagem);

        Intent intent = getIntent();

        if (isClickedMugiwara) {
            String nPersonagem = intent.getStringExtra("nomesMugiwara");
            int iPersonagem = intent.getIntExtra("imagensMugiwara", 0);
            String dPersonagem = intent.getStringExtra("descricoesMugiwara");

            textoPersonagem.setText(nPersonagem);
            imagemPersonagem.setImageResource(iPersonagem);
            descricaoPersonagem.setText(dPersonagem);
        }

        if (isClickedBigMom) {
            String nPersonagem = intent.getStringExtra("nomesBigMom");
            int iPersonagem = intent.getIntExtra("imagensBigMom", 0);
            String dPersonagem = intent.getStringExtra("descricoesBigMom");

            textoPersonagem.setText(nPersonagem);
            imagemPersonagem.setImageResource(iPersonagem);
            descricaoPersonagem.setText(dPersonagem);
        }
    }
}