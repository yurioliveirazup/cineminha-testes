package br.com.zup.edu.cineminhatestes.ingressos;

import java.math.BigDecimal;
import java.math.RoundingMode;

public enum Tipo {

    CORTESIA {

        @Override
        public BigDecimal calculaPrecoPara(BigDecimal preco) {
            return BigDecimal.ZERO;
        }
    },

    MEIA_ENTRADA {

        @Override
        public BigDecimal calculaPrecoPara(BigDecimal preco) {

            return preco.divide(new BigDecimal("2.0"), RoundingMode.HALF_UP);
        }

    },

    INTEIRA {

        @Override
        public BigDecimal calculaPrecoPara(BigDecimal preco) {
            return preco;
        }

    },

    ZUPPERS {

        @Override
        public BigDecimal calculaPrecoPara(BigDecimal preco) {
            return preco.multiply(new BigDecimal("0.75"));
        }
    };


    public abstract BigDecimal calculaPrecoPara(BigDecimal preco);
}