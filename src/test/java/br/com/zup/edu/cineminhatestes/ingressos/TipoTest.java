package br.com.zup.edu.cineminhatestes.ingressos;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

class TipoTest {

    // O que vai acontecer - Dado uma ação
    @Test
    @DisplayName("Deve retornar zero quando o Tipo for CORTESIA")
    public void deveRetornarZeroQuandoOTipoForCortesia() {

        Tipo cortesia = Tipo.CORTESIA;

        BigDecimal valorDoIngresso = cortesia.calculaPreco(BigDecimal.TEN);

        Assertions.assertEquals(BigDecimal.ZERO, valorDoIngresso);
    }


    @Test
    @DisplayName("Deve retornar a metade do valor quando o Tipo for MEIA_ENTRADA")
    public void deveRetornarAMetadeDoValorQuandoOTipoForMeiaEntrada() {

        Tipo meiaEntrada = Tipo.MEIA_ENTRADA;

        BigDecimal valorDoIngresso = meiaEntrada.calculaPreco(BigDecimal.TEN);

        Assertions.assertEquals(new BigDecimal("5"), valorDoIngresso);
    }

    @Test
    @DisplayName("Deve retornar o valor total quando o Tipo for INTEIRA")
    public void deveRetornarOValorTotalDoIngressoQuandoOTipoForInteira() {
        Tipo inteira = Tipo.INTEIRA;

        BigDecimal valorDoIngresso = inteira.calculaPreco(BigDecimal.TEN);

        Assertions.assertEquals(BigDecimal.TEN, valorDoIngresso);
    }
}

