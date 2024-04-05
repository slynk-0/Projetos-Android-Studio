package com.example.applistavip.controller;

import android.content.SharedPreferences;
import android.util.Log;

import com.example.applistavip.model.Pessoa;
import com.example.applistavip.view.MainActivity;


public class PessoaController {


    SharedPreferences preferences;
    SharedPreferences.Editor listavip;
    public static final String PREFERENCE_REFERENCE = "ref listavip";

    public PessoaController(MainActivity mainActivity) {
        preferences = mainActivity.getSharedPreferences(PREFERENCE_REFERENCE, 0);
        listavip = preferences.edit();

    }

    public void salvar(Pessoa pessoa) {
        Log.i("MVC_CONTROLLER", "Salvo..." + pessoa.toString());

        listavip.putString("primeiroNome", pessoa.getPrimeiroNome());
        listavip.putString("sobrenome", pessoa.getSobrenome());
        listavip.putString("nomeCurso", pessoa.getCursoDesejado());
        listavip.putString("nomeTelefoneContato", pessoa.getTelefone());
        listavip.apply();
    }


    public Pessoa buscar(Pessoa pessoa) {
        //Obtendo as Strings do que está associado no preferences para ser exibidas.
        pessoa.setPrimeiroNome(preferences.getString("primeiroNome", ""));
        pessoa.setSobrenome(preferences.getString("sobrenome", ""));
        pessoa.setCursoDesejado(preferences.getString("nomeCurso", ""));
        pessoa.setTelefone(preferences.getString("nomeTelefoneContato", ""));

        return pessoa;

    }

    public void limpar(){
        listavip.clear();
        listavip.apply();
    }
}
