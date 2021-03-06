package br.com.zup.edu.cineminhatestes.usuarios;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import java.time.LocalDate;
import java.util.StringJoiner;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @NotBlank
    private String nome;

    @NotBlank
    @Email
    private String email;

    @Past
    private LocalDate dataDeNascimento;


    /**
     * @deprecated para uso do hibernate
     */
    @Deprecated
    public Usuario() { }

    public Usuario(String nome,
                   String email,
                   LocalDate dataDeNascimento) {
        this.nome = nome;
        this.email = email;
        this.dataDeNascimento = dataDeNascimento;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Usuario.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("nome='" + nome + "'")
                .add("email='" + email + "'")
                .add("dataDeNascimento=" + dataDeNascimento)
                .toString();
    }
}
