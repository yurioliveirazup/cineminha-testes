package br.com.zup.edu.cineminhatestes.ingressos.compraIngresso;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "enviadorDeEmails", url = "http://localhost:8080/emails")
public interface EmailClient {

    @PostMapping
    void enviar(EmailTemplate emailTemplate);
}
