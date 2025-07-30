package com.lucasmagalhaes.financas.service;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.lucasmagalhaes.financas.model.Transacao;

import java.io.FileReader;
import java.io.FileWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class TransacaoService {
    private List<Transacao> lista = new ArrayList<>();
    private Gson gson = new Gson();
    private final String ARQUIVO = "src/main/resources/data.json";

    public TransacaoService() {
        load();
    }

    public List<Transacao> listAll() {
        return lista;
    }

    public Transacao add(Transacao t) {
        int nextId = lista.stream().mapToInt(Transacao::getId).max().orElse(0) + 1;
        t.setId(nextId);
        lista.add(t);
        save();
        return t;
    }

    public double getSaldo() {
        return lista.stream()
            .mapToDouble(t -> t.getTipo().equals("entrada") ? t.getValor() : -t.getValor())
            .sum();
    }

    private void load() {
        try (FileReader reader = new FileReader(ARQUIVO)) {
            Type listType = new TypeToken<ArrayList<Transacao>>(){}.getType();
            lista = gson.fromJson(reader, listType);
            if (lista == null) lista = new ArrayList<>();
        } catch (Exception e) {
            lista = new ArrayList<>();
        }
    }

    private void save() {
        try (FileWriter writer = new FileWriter(ARQUIVO)) {
            gson.toJson(lista, writer);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
