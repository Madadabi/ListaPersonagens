package br.com.local.listapersonagens;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class MostrarPersonagemActivity extends AppCompatActivity {
    TextView txtPersonagens;
    ImageView imgPersonagens;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mostrar_personagem_layout);

        txtPersonagens = findViewById(R.id.mtxtPersonagem);
        imgPersonagens = findViewById(R.id.mimgPersonagem);

        Intent intent = getIntent();

        String nPersonagem = intent.getStringExtra("nomePersonagens");
        int mPersonagem = intent.getIntExtra("imgPersonagens", 0);

        txtPersonagens.setText(nPersonagem);
        imgPersonagens.setImageResource(mPersonagem);
    }


}