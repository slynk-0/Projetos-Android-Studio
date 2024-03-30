package com.example.applistavip.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.applistavip.R;
import com.example.applistavip.controller.PessoaController;
import com.example.applistavip.model.Pessoa;

public class MainActivity extends AppCompatActivity {


    //Instanciando a classe SharedPreferences que é nativa do Android e também o object preferences.
    SharedPreferences preferences;

    //Definindo um atributo que contém o nome que é a referência para os dados serem armazenados.
    public static final String NOME_PREFERENCES = "pref listavip";

    Pessoa pessoa; //Instanciando a Classe Pessoa através do Construtor e definindo o objeto pessoa.
    Pessoa outraPessoa; //Definindo o objeto outraPessoa.

    PessoaController controller;

    //Através da declaração da Classe EditText, estão sendo criados os objetos do Layout, que antes
    //eram apenas elementos no XML.

    EditText editPrimeiroNome;
    EditText editSobreNomeAluno;
    EditText editNomeCurso;
    EditText editTelefoneContato;

    //Fazendo a mesma coisa, porém com os botões, mas utilizando a classe Button.
    Button btnSalvar;
    Button btnLimpar;
    Button btnFinalizar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Instanciando o SharedPreferences e logo em seguida a criação da listavip para o armazenamento dos dados.
        preferences = getSharedPreferences(NOME_PREFERENCES, 0);
        SharedPreferences.Editor listavip = preferences.edit();

        pessoa = new Pessoa(); //Criando um objeto para a classe Pessoa.
        outraPessoa = new Pessoa();
        controller = new PessoaController();

        String dadosOutraPessoa;

        //Definindo valores para os atributos criados na classe Pessoa e outraPessoa:

        pessoa.setPrimeiroNome("Breno");
        pessoa.setSobrenome("Sodré Bertunes");
        pessoa.setCursoDesejado("Desenvolvimento Android");
        pessoa.setTelefone("4002-8922");

        outraPessoa.setPrimeiroNome("John");
        outraPessoa.setSobrenome("Doe");
        outraPessoa.setCursoDesejado("Desenvolvimento em C#");
        outraPessoa.setTelefone("2934-2445");

        //Associando os ids dos componentes do Layout e associando aos objetos em si.
        editPrimeiroNome = findViewById(R.id.editPrimeiroNome);
        editSobreNomeAluno = findViewById(R.id.editSobreNomeAluno);
        editNomeCurso = findViewById(R.id.editNomeCurso);
        editTelefoneContato = findViewById(R.id.editTelefoneContato);

        btnFinalizar = findViewById(R.id.btnFinalizar);
        btnLimpar = findViewById(R.id.btnLimpar);
        btnSalvar = findViewById(R.id.btnSalvar);

        //Definindo os campos preenchíveis do Layout com o setText utilizando do método get.

        editPrimeiroNome.setText(pessoa.getPrimeiroNome());
        editSobreNomeAluno.setText(pessoa.getSobrenome());
        editTelefoneContato.setText(pessoa.getTelefone());
        editNomeCurso.setText(pessoa.getCursoDesejado());

        //Método que aciona uma ação ao clicar no btnLimpar. No caso a ação é redefinir
        //os campos preenchíveis.
        btnLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editPrimeiroNome.setText("");
                editSobreNomeAluno.setText("");
                editNomeCurso.setText("");
                editTelefoneContato.setText("");
            }
        });

        btnFinalizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Obrigado" +
                        "por utilizar!", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listavip.putString("primeiroNome", pessoa.getPrimeiroNome());
                listavip.putString("sobrenome", pessoa.getSobrenome());
                listavip.putString("nomeCurso", pessoa.getCursoDesejado());
                listavip.putString("nomeTelefoneContato", pessoa.getTelefone());
                listavip.apply();

                Toast.makeText(MainActivity.this, "Salvo" + pessoa.toString(), Toast.LENGTH_SHORT).show();

                controller.salvar(pessoa);
            }
        });

        //Checando no Logcat se os objetos estão com seus atributos.
        Log.i("POO Android", "Objeto pessoa: " + pessoa.toString());
        Log.i("POO Android", "Objeto outraPessoa: " + outraPessoa.toString());
    }
}