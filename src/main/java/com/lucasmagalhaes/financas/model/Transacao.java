package com.lucasmagalhaes.financas.model;

public class Transacao {
    private int id;
    private String tipo;       // "entrada" ou "saida"
    private double valor;
    private String descricao;
    private String data;       // YYYY-MM-DD

    public Transacao() { }

    public Transacao(int id, String tipo, double valor, String descricao, String data) {
        this.id = id;
        this.tipo = tipo;
        this.valor = valor;
        this.descricao = descricao;
        this.data = data;
    }

    // getters e setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }

    public double getValor() { return valor; }
    public void setValor(double valor) { this.valor = valor; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    public String getData() { return data; }
    public void setData(String data) { this.data = data; }
}
