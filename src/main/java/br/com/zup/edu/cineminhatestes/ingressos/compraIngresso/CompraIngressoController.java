package br.com.zup.edu.cineminhatestes.ingressos.compraIngresso;

import br.com.zup.edu.cineminhatestes.filmes.Classificacao;
import br.com.zup.edu.cineminhatestes.filmes.SessaoRepository;
import br.com.zup.edu.cineminhatestes.ingressos.Ingresso;
import br.com.zup.edu.cineminhatestes.ingressos.IngressoRepository;
import br.com.zup.edu.cineminhatestes.ingressos.Tipo;
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
import java.time.LocalDate;
import java.time.Period;

@RestController
@RequestMapping("/api/compras")
public class CompraIngressoController {

    @Autowired
    private EmailClient emailClient;

    @Autowired
    private SessaoRepository sessoes;

    @Autowired
    private UsuarioRepository usuarios;

    @Autowired
    private IngressoRepository repository;


    @PostMapping
    public ResponseEntity<?> compra(@RequestBody @Valid CompraIngressoRequest r) {

        Ingresso i = r.paraIngresso(sessoes, usuarios);

        if (i.getSessao().getFilme().getClassificacao() == Classificacao.MAIORES_DE_10_ANOS) {
            LocalDate dataDeNascimento = i.getUsuario().getDataDeNascimento();
            LocalDate hoje = LocalDate.now();

            Period periodo = Period.between(dataDeNascimento, hoje);
            int idade = periodo.getYears();

            if (idade < 10) {
                throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY);
            }
        } else if (i.getSessao().getFilme().getClassificacao() == Classificacao.MAIORES_DE_14_ANOS) {
            LocalDate dataDeNascimento = i.getUsuario().getDataDeNascimento();
            LocalDate hoje = LocalDate.now();

            Period periodo = Period.between(dataDeNascimento, hoje);
            int idade = periodo.getYears();

            if (idade < 14) {
                throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY);
            }
        }  else if (i.getSessao().getFilme().getClassificacao() == Classificacao.MAIORES_DE_16_ANOS) {

            LocalDate dataDeNascimento = i.getUsuario().getDataDeNascimento();
            LocalDate hoje = LocalDate.now();

            Period periodo = Period.between(dataDeNascimento, hoje);
            int idade = periodo.getYears();

            if (idade < 16) {
                throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY);
            }
        }  else if (i.getSessao().getFilme().getClassificacao() == Classificacao.MAIORES_DE_18_ANOS) {

            LocalDate dataDeNascimento = i.getUsuario().getDataDeNascimento();
            LocalDate hoje = LocalDate.now();

            Period periodo = Period.between(dataDeNascimento, hoje);
            int idade = periodo.getYears();

            if (idade < 18) {
                throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY);
            }
        }

        if (i.getTipo() == Tipo.MEIA_ENTRADA) {
            i.setPreco(i.getPreco().divide(new BigDecimal("2.0"), RoundingMode.HALF_UP));
        } else if (i.getTipo() == Tipo.CORTESIA) {
            i.setPreco(BigDecimal.ZERO);
        }

        repository.save(i);

        EmailTemplate emailTemplate = new EmailTemplate("nosso.cinema@cinema.com.br",
                i.getEmail(),
                "Compra realizada", "Parabéns! Esperamos que você goste do filme");

        // requisicao no sistema de email
        emailClient.enviar(emailTemplate);

        return ResponseEntity.ok().build();
    }


}
