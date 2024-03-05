package br.com.wilmeccontroller.model;

import java.util.Random;

public record Categoria(Long id, String nome_prod, String descricao_prod, String cat_prod, String prateleira,
        int qnt_prod) {

    public Categoria(Long id, String nome_prod, String descricao_prod, String cat_prod, String prateleira,
            int qnt_prod) {
        // Refazendo a mesma solucao do CashFlowPro por enquanto
        var key = (id != null) ? id : Math.abs(new Random().nextLong());
        this.id = key;
        this.nome_prod = nome_prod;
        this.descricao_prod = descricao_prod;
        this.cat_prod = cat_prod;
        this.prateleira = prateleira;
        this.qnt_prod = qnt_prod;
    }
}
