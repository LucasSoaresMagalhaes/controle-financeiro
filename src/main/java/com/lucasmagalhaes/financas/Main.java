package com.lucasmagalhaes.financas;

import static spark.Spark.*;

public class Main {
    public static void main(String[] args) {
        port(4567); // Porta padrão

        get("/ping", (req, res) -> "Servidor rodando!");

        // Teste inicial
        System.out.println("Servidor iniciado em http://localhost:4567/ping");
    }
}
