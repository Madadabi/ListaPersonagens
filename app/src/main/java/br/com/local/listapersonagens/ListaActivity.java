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

    String nomesMugiwara[] = {
            "Monkey D. Luffy",
            "Roronoa Zoro",
            "Vinsmoke Sanji",
            "Nami",
            "Usopp",
            "Tony Tony Chopper",
            "Nico Robin",
            "Franky",
            "Brook"
    };
    int imagensMugiwara[] = {
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
    String descricoesMugiwara[] = {
            "Capitão dos Piratas do Chapéu de Palha",
            "Espadachim e primeiro integrante dos Piratas do Chapéu de Palha",
            "Cozinheiro dos Piratas do Chapéu de Palha",
            "Navegadora dos Piratas do Chapéu de Palha",
            "Franco-atirador dos Piratas do Chapéu de Palha",
            "Médico dos Piratas do Chapéu de Palha",
            "Arqueóloga dos Piratas do Chapéu de Palha",
            "Carpinteiro e construtor do Thousand Sunny (navio) dos Piratas do Chapéu de Palha",
            "Músico dos Piratas do Chapéu de Palha"
    };

    String nomesBigMom[] = {
            "Charlotte Linlin",
            "Charlotte Cracker",
            "Charlotte Smoothie",
            "Charlotte Katakuri",
    };
    int imagensBigMom[] = {
            R.drawable.bigmom,
            R.drawable.cracker,
            R.drawable.smoothie,
            R.drawable.katakuri,
    };
    String descricoesBigMom[] = {
            "Capitã dos Piratas da Big Mom",
            "Um dos Três Comandantes Doces dos Piratas da Big Mom e em Totto Land atua como Ministro do Biscoito",
            "Ela atua como uma das Três Generais da Doçura dos Piratas da Big Mom e como Ministro do Suco em Totto Land",
            "Um dos Três Generais da Doçura dos Piratas da Big Mom e atua como Ministro da Farinha em Totto Land",
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lista_layout);

        boolean isClickedMugiwara = getIntent().getExtras().getBoolean("isClickedMugiwara");
        boolean isClickedBigMom = getIntent().getExtras().getBoolean("isClickedBigMom");

        listView = findViewById(R.id.listaLayout);

        CustomAdapter customAdapter = new CustomAdapter();

        listView.setAdapter(customAdapter);

        //Evento de click
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent = new Intent(getApplicationContext(), MostrarPersonagemActivity.class);

                //Informações dos Chapéus de Palha
                if (isClickedMugiwara) {
                    intent.putExtra("nomesMugiwara", nomesMugiwara[position]);
                    intent.putExtra("imagensMugiwara", imagensMugiwara[position]);
                    intent.putExtra("descricoesMugiwara", descricoesMugiwara[position]);

                    intent.putExtra("isClickedMugiwara", true);

                    startActivity(intent);
                }

                //Informações do Bando da Big Mom
                if (isClickedBigMom) {
                    intent.putExtra("nomesBigMom", nomesBigMom[position]);
                    intent.putExtra("imagensBigMom", imagensBigMom[position]);
                    intent.putExtra("descricoesBigMom", descricoesBigMom[position]);

                    intent.putExtra("isClickedBigMom", true);

                    startActivity(intent);
                }
            }
        });
    }

    public class CustomAdapter extends BaseAdapter {

        boolean isClickedMugiwara = getIntent().getExtras().getBoolean("isClickedMugiwara");
        boolean isClickedBigMom = getIntent().getExtras().getBoolean("isClickedBigMom");

        @Override
        public int getCount() {
            if (isClickedMugiwara)
                return imagensMugiwara.length;
            if (isClickedBigMom)
                return imagensBigMom.length;
            return 0;
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

            //Fazer dinâmico, verificar qual button foi pressionado
            if (isClickedMugiwara) {
                txtNomePersonagem.setText(nomesMugiwara[position]);
                imgPersonagem.setImageResource(imagensMugiwara[position]);
            }

            if (isClickedBigMom) {
                txtNomePersonagem.setText(nomesBigMom[position]);
                imgPersonagem.setImageResource(imagensBigMom[position]);
            }

            return carregaView;
        }
    }
}