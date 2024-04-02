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
    public static final String NOME_PREFERENCES = "pref listavip"; //pref listavip é o nome de referência
    //da SharedPreferences

    Pessoa pessoa; //Instanciando a Classe Pessoa através do Construtor e definindo o objeto pessoa.
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

        // Instanciando o SharedPreferences e logo em seguida a referência listavip para o armazenamento dos dados.
        preferences = getSharedPreferences(NOME_PREFERENCES, 0);
        SharedPreferences.Editor listavip = preferences.edit();

        pessoa = new Pessoa(); //Criando um objeto para a classe Pessoa.
        controller = new PessoaController();


        //Obtendo as Strings do que está associado no preferences para ser exibidas.
        pessoa.setPrimeiroNome(preferences.getString("primeiroNome", ""));
        pessoa.setSobrenome(preferences.getString("sobrenome", ""));
        pessoa.setCursoDesejado(preferences.getString("nomeCurso", ""));
        pessoa.setTelefone(preferences.getString("nomeTelefoneContato", ""));

        /*
        editPrimeiroNome.setText(pessoa.getPrimeiroNome());
        editSobreNomeAluno.setText(pessoa.getSobrenome());
        editNomeCurso.setText(pessoa.getCursoDesejado());
        editTelefoneContato.setText(pessoa.getTelefone());
         */


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

                pessoa.setPrimeiroNome(editPrimeiroNome.getText().toString());
                pessoa.setSobrenome(editSobreNomeAluno.getText().toString());
                pessoa.setCursoDesejado(editNomeCurso.getText().toString());
                pessoa.setTelefone(editTelefoneContato.getText().toString());
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
    }
}
