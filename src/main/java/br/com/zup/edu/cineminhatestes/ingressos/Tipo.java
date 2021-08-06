package br.com.zup.edu.cineminhatestes.ingressos;

import java.math.BigDecimal;
import java.math.RoundingMode;

public enum Tipo {

    CORTESIA {

        @Override
        public BigDecimal calculaPreco(BigDecimal preco) {
            return BigDecimal.ZERO;
        }

    },
    MEIA_ENTRADA {

        @Override
        public BigDecimal calculaPreco(BigDecimal preco) {
            return preco.divide(new BigDecimal("2.0"), RoundingMode.HALF_UP);
        }

    },
    INTEIRA {

        @Override
        public BigDecimal calculaPreco(BigDecimal preco) {
            return preco;
        }

    };


    public abstract BigDecimal calculaPreco(BigDecimal preco);
}
