package br.com.zup.edu.cineminhatestes.compartilhado.validacoes;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Documented
@Constraint(validatedBy = { ClassificacaoIndicativaValidator.class })
@Target({ TYPE })
@Retention(RUNTIME)
public @interface ClassificacaoIndicativa {

    String message() default "Pessoa não tem idade para assistir o filme";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };


}
