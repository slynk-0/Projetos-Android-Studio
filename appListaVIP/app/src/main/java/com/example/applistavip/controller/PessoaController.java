package com.example.applistavip.controller;

import android.util.Log;

import com.example.applistavip.model.Pessoa;

public class PessoaController {
    public void salvar(Pessoa pessoa) {
        Log.i("MVC_CONTROLLER", "Salvo..." + pessoa.toString());
    }
}
