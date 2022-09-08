package br.com.zup.edu.cineminhatestes;

import br.com.zup.edu.cineminhatestes.filmes.*;
import br.com.zup.edu.cineminhatestes.salas.Sala;
import br.com.zup.edu.cineminhatestes.salas.SalaRepository;
import br.com.zup.edu.cineminhatestes.usuarios.Usuario;
import br.com.zup.edu.cineminhatestes.usuarios.UsuarioRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalDate;

import static java.time.LocalTime.now;
import static java.time.temporal.ChronoUnit.HOURS;

@SpringBootApplication
@EnableFeignClients
public class CineminhaTestesApplication {

	public static void main(String[] args) {
		SpringApplication.run(CineminhaTestesApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(SessaoRepository sessaoRepository,
							 FilmeRepository filmeRepository,
							 SalaRepository salaRepository,
							 UsuarioRepository usuarioRepository) {


		Usuario huguinhoPato = new Usuario("Huguinho Pato", "huguinho@zup.com.br", LocalDate.of(2013, 7, 14));
		Usuario patoDolnald = new Usuario("Pato Dolnald", "donald@zup.com.br", LocalDate.of(2011, 8, 20));
		Usuario capitãoBoeing = new Usuario("Capitão Boeing", "boeing@zup.com.br", LocalDate.of(2007, 12, 12));
		Usuario madamePatilda = new Usuario("Madame Patilda", "patilda@zup.com.br", LocalDate.of(2005, 1, 4));
		Usuario tioPatinhas = new Usuario("Tio Patinhas", "tio.patinhas@zup.com.br", LocalDate.of(1999, 9, 10));


		Filme procurandoNemo = new Filme("Procurando Nemo", Duration.of(1, HOURS), Classificacao.LIVRE);
		Filme homemAranha = new Filme("Homem Aranha", Duration.of(1, HOURS), Classificacao.MAIORES_DE_10_ANOS);
		Filme harryPotter = new Filme("Harry Potter", Duration.of(1, HOURS), Classificacao.MAIORES_DE_14_ANOS);
		Filme coringa = new Filme("Coringa", Duration.of(1, HOURS), Classificacao.MAIORES_DE_16_ANOS);
		Filme aBruxa = new Filme("A Bruxa", Duration.of(1, HOURS), Classificacao.MAIORES_DE_18_ANOS);

		Sala paris = new Sala("Paris");
		Sala roma = new Sala("Roma");
		Sala londres = new Sala("Londres");
		Sala atenas = new Sala("Atenas");
		Sala tokio = new Sala("tokio");

		Sessao sessaoProcurandoNemo = new Sessao(now().plusHours(24), atenas, procurandoNemo, new BigDecimal("50.0"));
		Sessao sessaoHomemAranha = new Sessao(now().plusHours(24), paris, homemAranha, new BigDecimal("30.0"));
		Sessao sessaoHarryPotter = new Sessao(now().plusHours(24), roma, harryPotter, new BigDecimal("20.0"));
		Sessao sessaoCoringa = new Sessao(now().plusHours(24), londres, coringa, new BigDecimal("50.0"));
		Sessao sessaoABruxa = new Sessao(now().plusHours(24), tokio, aBruxa, new BigDecimal("50.0"));

		return (args) -> {
			usuarioRepository.save(huguinhoPato);
			usuarioRepository.save(patoDolnald);
			usuarioRepository.save(capitãoBoeing);
			usuarioRepository.save(madamePatilda);
			usuarioRepository.save(tioPatinhas);

			filmeRepository.save(procurandoNemo);
			filmeRepository.save(homemAranha);
			filmeRepository.save(harryPotter);
			filmeRepository.save(coringa);
			filmeRepository.save(aBruxa);

			salaRepository.save(paris);
			salaRepository.save(roma);
			salaRepository.save(londres);
			salaRepository.save(atenas);
			salaRepository.save(tokio);

			sessaoRepository.save(sessaoProcurandoNemo);
			sessaoRepository.save(sessaoHomemAranha);
			sessaoRepository.save(sessaoHarryPotter);
			sessaoRepository.save(sessaoCoringa);
			sessaoRepository.save(sessaoABruxa);
		};
	}

}
