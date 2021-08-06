package br.com.zup.edu.cineminhatestes.compartilhado.validacoes;


import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Documented
@Target({ TYPE })
@Retention(RUNTIME)
@Constraint(validatedBy = { ClassificacaoIndicativaValidator.class })
public @interface ClassificacaoIndicativa {

    String message() default "Você não pode comprar esse ingresso. Verifique a classificação indicativa";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
