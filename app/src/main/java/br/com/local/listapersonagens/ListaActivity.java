package br.com.local.listapersonagens;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class ListaActivity extends AppCompatActivity {

    ListView listView;

    String nomePersonagens[] = {
            "Luffy",
            "Zoro",
            "Sanji",
            "Nami",
            "Usopp",
            "Chopper",
            "Robin",
            "Franky",
            "Brook"
    };
    int imgPersonagens[] = {
            R.drawable.luffy,
            R.drawable.zoro,
            R.drawable.sanji,
            R.drawable.nami,
            R.drawable.usopp,
            R.drawable.chopper,
            R.drawable.robin,
            R.drawable.franky,
            R.drawable.brook
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lista_layout);

        listView = findViewById(R.id.listaLayout);

        CustomAdapter customAdapter = new CustomAdapter();

        listView.setAdapter(customAdapter);

        //Evento de click
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent = new Intent(getApplicationContext(), MostrarPersonagemActivity.class);

                intent.putExtra("nomePersonagens", nomePersonagens[position]);
                intent.putExtra("imgPersonagens", imgPersonagens[position]);

                startActivity(intent);
            }
        });
    }

    public class CustomAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return imgPersonagens.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        //Modelo listaView
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            TextView txtNomePersonagem;
            ImageView imgPersonagem;

            View carregaView = getLayoutInflater().inflate(R.layout.modelo_lista_layout, null);

            txtNomePersonagem = carregaView.findViewById(R.id.txtListaPersonagem);
            imgPersonagem = carregaView.findViewById(R.id.imgListaPersonagem);

            txtNomePersonagem.setText(nomePersonagens[position]);
            imgPersonagem.setImageResource(imgPersonagens[position]);

            return carregaView;
        }
    }
}