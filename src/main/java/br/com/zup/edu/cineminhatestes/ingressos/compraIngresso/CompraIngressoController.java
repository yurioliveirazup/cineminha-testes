package br.com.zup.edu.cineminhatestes.ingressos.compraIngresso;

import br.com.zup.edu.cineminhatestes.filmes.Filme;
import br.com.zup.edu.cineminhatestes.filmes.SessaoRepository;
import br.com.zup.edu.cineminhatestes.ingressos.IngressoRepository;
import br.com.zup.edu.cineminhatestes.ingressos.Tipo;
import br.com.zup.edu.cineminhatestes.usuarios.Usuario;
import br.com.zup.edu.cineminhatestes.usuarios.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.math.RoundingMode;

@RestController
@RequestMapping("/api/compras")
public class CompraIngressoController {

    @Autowired
    private EmailClient emailClient;

    @Autowired
    private SessaoRepository sessaoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private IngressoRepository ingressoRepository;


    @PostMapping
    public ResponseEntity<?> compra(@RequestBody @Valid CompraIngressoRequest request) {

        var ingresso = request.paraIngresso(sessaoRepository, usuarioRepository);

        if (ingresso.getTipo() == Tipo.MEIA_ENTRADA) {
            ingresso.setPreco(ingresso.getPreco().divide(new BigDecimal("2.0"), RoundingMode.HALF_UP));
        } else if (ingresso.getTipo() == Tipo.CORTESIA) {
            ingresso.setPreco(BigDecimal.ZERO);
        }

        ingressoRepository.save(ingresso);

        EmailTemplate emailTemplate = new EmailTemplate(
                "nosso.cinema@cinema.com.br",
                ingresso.getEmail(),
                "Compra realizada",
                "Parabéns! Esperamos que você goste do filme");

        // requisicao no sistema de email
        emailClient.enviar(emailTemplate);

        return ResponseEntity.ok().build();
    }


}
