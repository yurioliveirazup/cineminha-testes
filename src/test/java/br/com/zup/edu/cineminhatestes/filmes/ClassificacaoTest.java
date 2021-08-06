package br.com.zup.edu.cineminhatestes.filmes;

import br.com.zup.edu.cineminhatestes.usuarios.Usuario;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

class ClassificacaoTest {

    @Test
    @DisplayName("deve poder assistir quando Idade for LIVRE")
    public void devePoderAssistirQuandoIdadeForMaiorQueLivre() {

        LocalDate dataDeNascimento = LocalDate.now().minus(1, ChronoUnit.YEARS);
        Usuario usuario = new Usuario("Rafael Ponte", "rafael.ponte@zup.com.br", dataDeNascimento);
        Classificacao maioresDe10Anos = Classificacao.LIVRE;

        boolean comporta = maioresDe10Anos.comporta(usuario);

        Assertions.assertTrue(comporta);
    }

    @Test
    @DisplayName("deve poder assistir quando Idade for MAIOR_QUE_10")
    public void devePoderAssistirQuandoIdadeForMaiorQueDez() {

        LocalDate dataDeNascimento = LocalDate.now().minus(10, ChronoUnit.YEARS);
        Usuario usuario = new Usuario("Rafael Ponte", "rafael.ponte@zup.com.br", dataDeNascimento);
        Classificacao maioresDe10Anos = Classificacao.MAIORES_DE_10_ANOS;

        boolean comporta = maioresDe10Anos.comporta(usuario);

        Assertions.assertTrue(comporta);
    }

    @Test
    @DisplayName("Não deve poder assistir quando Idade for MENOR_QUE_10")
    public void naoDevePoderAssistirQuandoIdadeForMenorQueDez() {

        LocalDate dataDeNascimento = LocalDate.now().minus(9, ChronoUnit.YEARS);
        Usuario usuario = new Usuario("Rafael Ponte", "rafael.ponte@zup.com.br", dataDeNascimento);
        Classificacao maioresDe10Anos = Classificacao.MAIORES_DE_10_ANOS;

        boolean naoComporta = maioresDe10Anos.comporta(usuario);

        Assertions.assertFalse(naoComporta);
    }

    @Test
    @DisplayName("deve poder assistir quando Idade for MAIOR_QUE_14")
    public void devePoderAssistirQuandoIdadeForMaiorQueQuatorze() {

        LocalDate dataDeNascimento = LocalDate.now().minus(14, ChronoUnit.YEARS);
        Usuario usuario = new Usuario("Rafael Ponte", "rafael.ponte@zup.com.br", dataDeNascimento);
        Classificacao maioresDe10Anos = Classificacao.MAIORES_DE_14_ANOS;

        boolean comporta = maioresDe10Anos.comporta(usuario);

        Assertions.assertTrue(comporta);
    }

    @Test
    @DisplayName("Não deve poder assistir quando Idade for MENOR_QUE_14")
    public void naoDevePoderAssistirQuandoIdadeForMenorQueQuatorze() {

        LocalDate dataDeNascimento = LocalDate.now().minus(13, ChronoUnit.YEARS);
        Usuario usuario = new Usuario("Rafael Ponte", "rafael.ponte@zup.com.br", dataDeNascimento);
        Classificacao maioresDe10Anos = Classificacao.MAIORES_DE_14_ANOS;

        boolean naoComporta = maioresDe10Anos.comporta(usuario);

        Assertions.assertFalse(naoComporta);
    }

    @Test
    @DisplayName("deve poder assistir quando Idade for MAIOR_QUE_16")
    public void devePoderAssistirQuandoIdadeForMaiorQueDezesseis() {

        LocalDate dataDeNascimento = LocalDate.now().minus(16, ChronoUnit.YEARS);
        Usuario usuario = new Usuario("Rafael Ponte", "rafael.ponte@zup.com.br", dataDeNascimento);
        Classificacao maioresDe10Anos = Classificacao.MAIORES_DE_16_ANOS;

        boolean comporta = maioresDe10Anos.comporta(usuario);

        Assertions.assertTrue(comporta);
    }

    @Test
    @DisplayName("Não deve poder assistir quando Idade for MENOR_QUE_16")
    public void naoDevePoderAssistirQuandoIdadeForMenorQueDezesseis() {

        LocalDate dataDeNascimento = LocalDate.now().minus(15, ChronoUnit.YEARS);
        Usuario usuario = new Usuario("Rafael Ponte", "rafael.ponte@zup.com.br", dataDeNascimento);
        Classificacao maioresDe10Anos = Classificacao.MAIORES_DE_16_ANOS;

        boolean naoComporta = maioresDe10Anos.comporta(usuario);

        Assertions.assertFalse(naoComporta);
    }

    @Test
    @DisplayName("deve poder assistir quando Idade for MAIOR_QUE_18")
    public void devePoderAssistirQuandoIdadeForMaiorQueDezoito() {

        LocalDate dataDeNascimento = LocalDate.now().minus(18, ChronoUnit.YEARS);
        Usuario usuario = new Usuario("Rafael Ponte", "rafael.ponte@zup.com.br", dataDeNascimento);
        Classificacao maioresDe10Anos = Classificacao.MAIORES_DE_18_ANOS;

        boolean comporta = maioresDe10Anos.comporta(usuario);

        Assertions.assertTrue(comporta);
    }

    @Test
    @DisplayName("Não deve poder assistir quando Idade for MENOR_QUE_18")
    public void naoDevePoderAssistirQuandoIdadeForMenorQueDezoito() {

        LocalDate dataDeNascimento = LocalDate.now().minus(17, ChronoUnit.YEARS);
        Usuario usuario = new Usuario("Rafael Ponte", "rafael.ponte@zup.com.br", dataDeNascimento);
        Classificacao maioresDe10Anos = Classificacao.MAIORES_DE_18_ANOS;

        boolean naoComporta = maioresDe10Anos.comporta(usuario);

        Assertions.assertFalse(naoComporta);
    }

}