package com.example.applistavip.controller;

import com.example.applistavip.model.Curso;

import java.util.ArrayList;
import java.util.List;

public class CursoController {

    private List listCursos;

    public List getListaDeCursos(){
        listCursos = new ArrayList<Curso>();

        listCursos.add(new Curso("Java"));
        listCursos.add(new Curso("Kotlin"));
        listCursos.add(new Curso("Dart"));
        listCursos.add(new Curso("C#"));
        listCursos.add(new Curso("C++"));
        listCursos.add(new Curso("Ruby"));

        return listCursos;
    }

    public ArrayList<String> dadosParaSpinner(){
        ArrayList<String> dados =  new ArrayList<>();

        for (int i = 0; i < getListaDeCursos().size(); i++) {

            Curso objeto = (Curso) getListaDeCursos().get(i);
            dados.add(objeto.getNomeDoCursoDesejado());
            
        }
        return dados;
    }

}
