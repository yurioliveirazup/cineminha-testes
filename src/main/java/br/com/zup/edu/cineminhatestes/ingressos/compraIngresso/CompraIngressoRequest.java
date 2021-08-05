package br.com.zup.edu.cineminhatestes.ingressos.compraIngresso;

import br.com.zup.edu.cineminhatestes.filmes.Sessao;
import br.com.zup.edu.cineminhatestes.filmes.SessaoRepository;
import br.com.zup.edu.cineminhatestes.ingressos.Ingresso;
import br.com.zup.edu.cineminhatestes.ingressos.Tipo;
import br.com.zup.edu.cineminhatestes.usuarios.Usuario;
import br.com.zup.edu.cineminhatestes.usuarios.UsuarioRepository;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.util.Optional;
import java.util.StringJoiner;

public class CompraIngressoRequest {

    @Email
    @NotBlank
    private String email;

    @NotNull
    @Positive
    private Long sessaoId;

    private Tipo tipo;

    @NotNull
    @Positive
    private Long usuarioId;

    public CompraIngressoRequest(String email,
                                 Long sessaoId,
                                 Tipo tipo,
                                 Long usuarioId) {
        this.email = email;
        this.sessaoId = sessaoId;
        this.tipo = tipo;
        this.usuarioId = usuarioId;
    }

    public Ingresso paraIngresso(SessaoRepository sessaoRepository,
                                 UsuarioRepository usuarioRepository) {

        Optional<Sessao> possivelSessao = sessaoRepository.findById(sessaoId);
        if (possivelSessao.isEmpty()) {
            throw new IllegalStateException("Sessao nao cadastrada");
        }

        Optional<Usuario> possivelUsuario = usuarioRepository.findById(usuarioId);
        if (possivelUsuario.isEmpty()) {
            throw new IllegalStateException("Usuario nao cadastrada");
        }

        Sessao sessao = possivelSessao.get();
        Usuario usuario = possivelUsuario.get();
        return new Ingresso(sessao, tipo, usuario);
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
