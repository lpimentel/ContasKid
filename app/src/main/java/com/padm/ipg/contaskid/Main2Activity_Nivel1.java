package com.padm.ipg.contaskid;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Main2Activity_Nivel1 extends AppCompatActivity {

    //** Declaração dos objetos**//
    private TextView tv_nome, tv_score;
    private ImageView iv_Aum, iv_Adois, iv_vidas;
    private EditText et_resposta;
    private MediaPlayer mp, mp_great, mp_bad;


    //**Declaração de variáveis e vetor de correspondência às operações**//

    int score, numAleatorio_um, numAleatorio_dois, resultado, vidas = 3;
    String nome_jogador, string_score, sting_vidas;

    String numero [] = {"zero", "um", "dois", "tres", "quatro", "cinco", "seis", "sete", "oito","nove"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2__nivel1);


        Toast.makeText(this, "Nivel 1", Toast.LENGTH_SHORT).show();

        //** Cricão das relações entre a parte lógica e gráfica **//

        tv_nome = (TextView)findViewById(R.id.textView_nome);
        tv_score = (TextView)findViewById(R.id.textView_score);
        iv_vidas = (ImageView)findViewById(R.id.imageView_vidas);
        iv_Aum = (ImageView)findViewById(R.id.imageView_NumUn);
        iv_Adois = (ImageView)findViewById(R.id.imageView_NumDois);
        et_resposta = (EditText)findViewById(R.id.editText_resultado);

        //** Obtenção do nome do jogar proveniente da primeira atividade **//

        nome_jogador = getIntent().getStringExtra("jogador");
        tv_nome.setText("Jogador: " + nome_jogador);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.ic_launcher);

        //** Colocalão dos sons **//
        mp = MediaPlayer.create(this, R.raw.goats);
        mp.start();
        mp.setLooping(true);

        //** Carregamento de dados relativos sons de certo ou errado **//
        mp_great = MediaPlayer.create(this, R.raw.wonderful);
        mp_bad = MediaPlayer.create(this, R.raw.bad);
        







    }
}
