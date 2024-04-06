package com.example.blocodenotas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnAddNota;
        TextView CaixaDeTexto;

        btnAddNota = findViewById(R.id.btnAddNota);
        CaixaDeTexto = findViewById(R.id.CaixaDeTexto);

        btnAddNota.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CaixaDeTexto.setText("Insira o texto!");
            }
        });





    }
}