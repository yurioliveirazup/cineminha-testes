package br.com.zup.edu.cineminhatestes.filmes;

import br.com.zup.edu.cineminhatestes.salas.Sala;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;
import java.time.LocalTime;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
public class Sessao {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    private LocalTime horario;

    @NotNull
    @ManyToOne
    private Sala sala;

    @NotNull
    @ManyToOne
    private Filme filme;

    @Positive
    private BigDecimal preco;

    /**
     * @deprecated hibernate apenas
     */
    @Deprecated
    public Sessao() {}

    public Sessao(LocalTime horario,
                  Sala sala,
                  Filme filme,
                  BigDecimal preco) {

        this.horario = horario;
        this.sala = sala;
        this.filme = filme;
        this.preco = preco;
    }

    public BigDecimal getPreco() {
        return preco;
    }
}