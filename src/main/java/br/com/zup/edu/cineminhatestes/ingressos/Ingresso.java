package br.com.zup.edu.cineminhatestes.ingressos;

import br.com.zup.edu.cineminhatestes.filmes.Sessao;
import br.com.zup.edu.cineminhatestes.usuarios.Usuario;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
public class Ingresso {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @NotNull
    @ManyToOne
    private Sessao sessao;

    @NotNull
    @PastOrPresent
    private LocalDateTime horaDaCompra = LocalDateTime.now();

    @NotNull
    @Positive
    private BigDecimal preco;

    @NotNull
    @Enumerated(EnumType.STRING)
    private Tipo tipo;

    @NotNull
    @ManyToOne
    private Usuario usuario;


    /**
     * @deprecated para uso do hibernate
     */
    @Deprecated
    public Ingresso() { }

    public Ingresso(Sessao sessao,
                    Tipo tipo,
                    Usuario usuario) {

        this.sessao = sessao;
        this.tipo = tipo;

        this.preco = tipo.calculaPreco(sessao.getPreco());
        this.usuario = usuario;
    }

    public String getEmail() {
        return usuario.getEmail();
    }

}
