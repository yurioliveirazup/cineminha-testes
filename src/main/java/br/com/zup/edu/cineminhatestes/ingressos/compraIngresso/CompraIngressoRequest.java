package br.com.zup.edu.cineminhatestes.ingressos.compraIngresso;

import br.com.zup.edu.cineminhatestes.compartilhado.validacoes.ClassificacaoIndicativa;
import br.com.zup.edu.cineminhatestes.filmes.Sessao;
import br.com.zup.edu.cineminhatestes.filmes.SessaoRepository;
import br.com.zup.edu.cineminhatestes.ingressos.Ingresso;
import br.com.zup.edu.cineminhatestes.ingressos.Tipo;
import br.com.zup.edu.cineminhatestes.usuarios.Usuario;
import br.com.zup.edu.cineminhatestes.usuarios.UsuarioRepository;
import org.springframework.util.Assert;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.util.Optional;
import java.util.StringJoiner;

@ClassificacaoIndicativa
public class CompraIngressoRequest {

    @Email
    @NotBlank
    private String email;

    @NotNull
    @Positive
    private Long sessaoId;

    @NotNull
    private Tipo tipo;

    public CompraIngressoRequest(String email,
                                 Long sessaoId,
                                 Tipo tipo) {
        this.email = email;
        this.sessaoId = sessaoId;
        this.tipo = tipo;
    }

    public Ingresso paraIngresso(SessaoRepository sessaoRepository,
                                 UsuarioRepository usuarioRepository) {

        Optional<Sessao> possivelSessao = sessaoRepository.findById(sessaoId);
        if (possivelSessao.isEmpty()) {
            throw new IllegalStateException("Sessao nao cadastrada");
        }

        Optional<Usuario> possivelUsuario = usuarioRepository.findByEmail(email);
        if (possivelUsuario.isEmpty()) {
            throw new IllegalStateException("Usuario nao cadastrada");
        }

        Sessao sessao = possivelSessao.get();
        Usuario usuario = possivelUsuario.get();
        return new Ingresso(sessao, tipo, usuario);
    }


    public String getEmail() {
        return email;
    }

    public Long getSessaoId() {
        return sessaoId;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", CompraIngressoRequest.class.getSimpleName() + "[", "]")
                .add("email='" + email + "'")
                .add("sessaoId=" + sessaoId)
                .add("tipo=" + tipo)
                .toString();
    }
}
