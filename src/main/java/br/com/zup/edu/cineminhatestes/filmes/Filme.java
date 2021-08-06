package br.com.zup.edu.cineminhatestes.filmes;

import br.com.zup.edu.cineminhatestes.usuarios.Usuario;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.Duration;
import java.util.StringJoiner;

import static javax.persistence.EnumType.STRING;
import static javax.persistence.GenerationType.IDENTITY;

@Entity
public class Filme {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @NotBlank
    private String nome;

    @NotNull
    private Duration duracao;

    @NotNull
    @Enumerated(STRING)
    private Classificacao classificacao;

    /**
     * @deprecated hibernate apenas
     */
    public Filme() { }

    public Filme(String nome,
                 Duration duracao,
                 Classificacao classificacao) {
        this.nome = nome;
        this.duracao = duracao;
        this.classificacao = classificacao;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Filme.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("nome='" + nome + "'")
                .add("duracao=" + duracao)
                .toString();
    }

    public boolean podeSerAssistido(Usuario usuario) {
        return classificacao.comporta(usuario);
    }
}