package br.com.zup.edu.cineminhatestes.filmes;

import br.com.zup.edu.cineminhatestes.usuarios.Usuario;

import java.time.LocalDate;
import java.time.Period;

public enum Classificacao {

    LIVRE(0),
    MAIORES_DE_10_ANOS(10),
    MAIORES_DE_14_ANOS(14),
    MAIORES_DE_16_ANOS(16),
    MAIORES_DE_18_ANOS(18),
    ;

    private int classificacao;

    Classificacao(int classificacao) {
        this.classificacao = classificacao;
    }

    public boolean comporta(Usuario usuario) {
        LocalDate dataDeNascimento = usuario.getDataDeNascimento();
        LocalDate hoje = LocalDate.now();

        Period periodo = Period.between(dataDeNascimento, hoje);
        int idade = periodo.getYears();

        return idade >= this.classificacao;
    }
}
