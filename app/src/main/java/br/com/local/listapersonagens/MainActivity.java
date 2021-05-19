package br.com.local.listapersonagens;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
    }

    public void openMugiwara(View view) {
        Intent intent = new Intent(this, ListaActivity.class);
        intent.putExtra("isClickedMugiwara", true);
        startActivity(intent);
    }

    public void openBigMom(View view) {
        Intent intent = new Intent(this, ListaActivity.class);
        intent.putExtra("isClickedBigMom", true);
        startActivity(intent);
    }
}