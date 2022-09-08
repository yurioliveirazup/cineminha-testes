package br.com.zup.edu.cineminhatestes.filmes;

import java.time.LocalDate;
import java.time.Period;

public enum Classificacao {

    LIVRE(0),
    MAIORES_DE_10_ANOS(10),
    MAIORES_DE_14_ANOS(14),
    MAIORES_DE_16_ANOS(16),
    MAIORES_DE_18_ANOS(18);

    private final int idade;

    Classificacao(int idade) {
        this.idade = idade;
    }

    public boolean comporta(LocalDate dataDeNascimento) {
        LocalDate hoje = LocalDate.now();

        Period periodo = Period.between(dataDeNascimento, hoje);
        int idadeDoUsuario = periodo.getYears();

        return idadeDoUsuario >= this.idade;

    }
}