package com.example.applistavip.model;

public class Pessoa {
    public Pessoa() {
    } //Esse é o construtor da classe, do qual permite que a classe seja instanciada
    //por exemplo na MainActivity.

    //Definindo os atributos:
    private String primeiroNome;
    private String sobrenome;
    private String cursoDesejado;
    private String telefone;

/*
    Utilizando dos métodos de acesso Getter and Setter, podemos fazer os atributos ficarem
    acessíveis para outra classe. Basta clicar com o botão direito: Generate > Getter and Setter
    Selecionar todas os atributos e dar enter.
*/

    public String getPrimeiroNome() {
        return primeiroNome;
    }
    public void setPrimeiroNome(String primeiroNome) {
        this.primeiroNome = primeiroNome;
    }
    public String getSobrenome() {
        return sobrenome;
    }
    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }
    public String getCursoDesejado() {
        return cursoDesejado;
    }
    public void setCursoDesejado(String cursoDesejado) {
        this.cursoDesejado = cursoDesejado;
    }
    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "primeiroNome='" + primeiroNome + '\'' +
                ", sobrenome='" + sobrenome + '\'' +
                ", cursoDesejado='" + cursoDesejado + '\'' +
                ", telefone='" + telefone + '\'' +
                '}';
    }
}