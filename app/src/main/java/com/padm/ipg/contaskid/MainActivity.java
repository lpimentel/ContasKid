package com.padm.ipg.contaskid;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //** Declaração dos objetos para cada campo **//

    private EditText et_nome;
    private ImageView iv_personagem;
    private TextView tv_bestscore;
    private MediaPlayer mp;

    //** Declaração de variavel tipo inteiro com casting **//

    int num_aleatorio = (int) (Math.random() * 10);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //** Relação entre a parte lógica e gráfica **//

        et_nome = (EditText)findViewById(R.id.txt_nome);
        iv_personagem = (ImageView)findViewById(R.id.imageView_Personagem);
        tv_bestscore = (TextView)findViewById(R.id.textView_BestScore);


        //** Coloca icons na barra action bar **//

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.ic_launcher);

        //** Condição para implemenação de números aleatórios na atividade principal**//

        int id;
        if (num_aleatorio == 0 || num_aleatorio == 10){
            id = getResources().getIdentifier("ini1", "drawable", getPackageName());
            iv_personagem.setImageResource(id);
        }   else if (num_aleatorio == 1 || num_aleatorio == 9){
            id = getResources().getIdentifier("ini2", "drawable", getPackageName());
            iv_personagem.setImageResource(id);
        }   else if (num_aleatorio == 2 || num_aleatorio == 8){
            id = getResources().getIdentifier("ini3", "drawable", getPackageName());
            iv_personagem.setImageResource(id);
        }   else if (num_aleatorio == 3 || num_aleatorio == 7){
            id = getResources().getIdentifier("ini4", "drawable", getPackageName());
            iv_personagem.setImageResource(id);
        }   else if (num_aleatorio == 4 || num_aleatorio == 5 || num_aleatorio == 6){
            id = getResources().getIdentifier("ini5", "drawable", getPackageName());
            iv_personagem.setImageResource(id);
        }

        //** Implementa sons na atividade inicial **//

        mp = MediaPlayer.create(this, R.raw.alphabet_song);
        mp.start();
        mp.setLooping(true);
    }

    public void Jogar (View view){
        String nome = et_nome.getText().toString();

        //** Libera recursos **//
        if (!nome.equals("")){
            mp.stop();
            mp.release();

         //** Implementa uma nova atividade **//
             Intent intent = new Intent(this, Main2Activity_Nivel1.class);

             intent.putExtra("jogador", nome);
             startActivity(intent);;
             finish();
        } else {
            Toast.makeText(this, "Primeiro introduz o teu nome", Toast.LENGTH_SHORT).show();

            et_nome.requestFocus();
            InputMethodManager imm = (InputMethodManager)getSystemService(this.INPUT_METHOD_SERVICE);
            imm.showSoftInput(et_nome, InputMethodManager.SHOW_IMPLICIT);
        }


    }

    @Override
    //** evitua utiliação de função regresso*//
    public void onBackPressed(){

    }

}
