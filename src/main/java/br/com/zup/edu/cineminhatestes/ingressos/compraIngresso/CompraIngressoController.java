package br.com.zup.edu.cineminhatestes.ingressos.compraIngresso;

import br.com.zup.edu.cineminhatestes.filmes.SessaoRepository;
import br.com.zup.edu.cineminhatestes.ingressos.Ingresso;
import br.com.zup.edu.cineminhatestes.ingressos.IngressoRepository;
import br.com.zup.edu.cineminhatestes.usuarios.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

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

        Ingresso ingresso = request.paraIngresso(sessaoRepository, usuarioRepository);

        ingressoRepository.save(ingresso);

        EmailTemplate emailTemplate = new EmailTemplate("nosso.cinema@cinema.com.br",
                ingresso.getEmail(),
                "Compra realizada");

        // requisicao no sistema de email
        emailClient.enviar(emailTemplate);

        return ResponseEntity.ok().build();
    }


}
