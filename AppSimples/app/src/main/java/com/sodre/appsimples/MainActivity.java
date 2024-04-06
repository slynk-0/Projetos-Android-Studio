package com.sodre.appsimples;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    Button botaoApague;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        botaoApague = findViewById(R.id.botaoApague);

        botaoApague.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                botaoApague.setText("Voce é gay");
            }
        });

    }
}