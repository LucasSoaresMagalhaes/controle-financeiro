package com.lucasmagalhaes.financas.controller;

import com.google.gson.Gson;
import com.lucasmagalhaes.financas.model.Transacao;
import com.lucasmagalhaes.financas.service.TransacaoService;

import static spark.Spark.*;

public class TransacaoController {
    private static TransacaoService service = new TransacaoService();
    private static Gson gson = new Gson();

    public static void routes() {
        path("/api", () -> {
            get("/transacoes", (req, res) -> {
                res.type("application/json");
                return gson.toJson(service.listAll());
            });

            post("/transacoes", (req, res) -> {
                res.type("application/json");
                Transacao t = gson.fromJson(req.body(), Transacao.class);
                Transacao criado = service.add(t);
                return gson.toJson(criado);
            });

            get("/saldo", (req, res) -> {
                res.type("application/json");
                return gson.toJson(service.getSaldo());
            });
        });
    }
}
