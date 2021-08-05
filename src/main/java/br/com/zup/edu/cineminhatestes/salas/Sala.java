package br.com.zup.edu.cineminhatestes.salas;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
public class Sala {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @NotBlank
    private String nome;

    /**
     * @deprecated hibernate apenas
     */
    @Deprecated
    public Sala() { }

    public Sala(@NotBlank String nome) {
        this.nome = nome;
    }
}