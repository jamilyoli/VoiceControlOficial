package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.widget.Button;
import android.widget.EditText;

import java.util.Locale;

public class Tela2 extends AppCompatActivity {
    private TextToSpeech ttsFalar;
    private EditText nome;
    private EditText nomeAssistente;
    private Button entrar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela2);
        ttsFalar = new TextToSpeech(this,this::onInit);
        initComponentes();
    }
        private void initComponentes(){
            nome = findViewById(R.id.nome_usuario);
            nomeAssistente = findViewById(R.id.nome_assistente);
            entrar = findViewById(R.id.button);
        }
    public void onInit(int status) {
        if (status == TextToSpeech.SUCCESS) {
            int resultado = ttsFalar.setLanguage(Locale.getDefault());
            if (resultado == TextToSpeech.LANG_MISSING_DATA || resultado == TextToSpeech.LANG_NOT_SUPPORTED) {

            } else {
                String texto = "Tela de cadastro, porfavro insira";
                ttsFalar.speak(texto, TextToSpeech.QUEUE_FLUSH, null, "1");
            }
        } else {
            //Falha
        }

    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (ttsFalar != null) {
            ttsFalar.stop();
            ttsFalar.shutdown();
        }
    }

}
