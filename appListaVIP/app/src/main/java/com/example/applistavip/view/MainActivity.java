package com.example.applistavip.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.example.applistavip.R;
import com.example.applistavip.model.Pessoa;

public class MainActivity extends AppCompatActivity {

    Pessoa pessoa; //Instanciando a Classe Pessoa através do Construtor e definindo o objeto pessoa.
    Pessoa outraPessoa; //Definindo o objeto outraPessoa.

    Pessoa dados;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pessoa = new Pessoa(); //Criando um objeto para a classe Pessoa.
        outraPessoa = new Pessoa();
        String dados; //Definindo uma String para ser usada para captar todos os dados de um objeto.
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

        /*

        dados = "Primeiro nome: ";
                dados += pessoa.getPrimeiroNome();
                dados += "Sobrenome: ";
                dados += pessoa.getSobrenome();
                dados += "Curso desejado: ";
                dados += pessoa.getCursoDesejado();
                dados += "Telefone: ";
                dados += pessoa.getTelefone();

        dadosOutraPessoa = "Primeiro nome: ";
                dadosOutraPessoa += outraPessoa.getPrimeiroNome();
                dadosOutraPessoa += " Sobrenome: ";
                dadosOutraPessoa += outraPessoa.getSobrenome();
                dadosOutraPessoa += " Curso desejado: ";
                dadosOutraPessoa += outraPessoa.getCursoDesejado();
                dadosOutraPessoa += " Telefone: ";
                dadosOutraPessoa += outraPessoa.getTelefone();

         */

        Log.i("POO Android", "Objeto pessoa: " + pessoa.toString());
        Log.i("POO Android", "Objeto outraPessoa: " + outraPessoa.toString());

    }
}