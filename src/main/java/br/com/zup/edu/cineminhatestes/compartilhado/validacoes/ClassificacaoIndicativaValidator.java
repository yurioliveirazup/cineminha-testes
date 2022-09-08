package br.com.zup.edu.cineminhatestes.compartilhado.validacoes;

import br.com.zup.edu.cineminhatestes.filmes.Sessao;
import br.com.zup.edu.cineminhatestes.filmes.SessaoRepository;
import br.com.zup.edu.cineminhatestes.ingressos.compraIngresso.CompraIngressoRequest;
import br.com.zup.edu.cineminhatestes.usuarios.Usuario;
import br.com.zup.edu.cineminhatestes.usuarios.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Optional;

public class ClassificacaoIndicativaValidator implements ConstraintValidator<ClassificacaoIndicativa,
                                                                             CompraIngressoRequest> {

    @Autowired
    private SessaoRepository sessaoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;



    @Override
    public boolean isValid(CompraIngressoRequest request,
                           ConstraintValidatorContext context) {

        Optional<Sessao> possivelSessao = sessaoRepository.findById(request.getSessaoId());
        if (possivelSessao.isEmpty()) {
            return false;
        }


        Optional<Usuario> possivelUsuario = usuarioRepository.findById(request.getUsuarioId());
        if (possivelUsuario.isEmpty()) {
            return false;
        }

        Sessao sessao = possivelSessao.get();
        Usuario usuario = possivelUsuario.get();


        return usuario.podeAssistir(sessao.getFilme());
    }
}
