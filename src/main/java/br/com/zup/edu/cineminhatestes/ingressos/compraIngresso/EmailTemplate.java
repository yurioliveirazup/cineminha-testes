package br.com.zup.edu.cineminhatestes.ingressos.compraIngresso;

import java.util.StringJoiner;

public class EmailTemplate {

    private String remetente;
    private String destinatario;
    private String assunto;
    private String corpo;

    private EmailTemplate(String remetente,
                         String destinatario,
                         String assunto,
                         String corpo) {
        this.remetente = remetente;
        this.destinatario = destinatario;
        this.assunto = assunto;
        this.corpo = corpo;
    }

    /**
     * @deprecated para uso exclusivo dos frameworks
     */
    @Deprecated
    public EmailTemplate() { }

    public String getRemetente() {
        return remetente;
    }

    public String getDestinatario() {
        return destinatario;
    }

    public String getAssunto() {
        return assunto;
    }

    public String getCorpo() {
        return corpo;
    }

    public static EmailTemplate destinatario(String destinatario) {
        EmailTemplate email = new EmailTemplate();
        email.destinatario = destinatario;

        return email;
    }

    public EmailTemplate remetente(String remetente) {
        this.remetente = remetente;
        return this;
    }

    public EmailTemplate assunto(String assunto) {
        this.assunto = assunto;
        return this;
    }


    public EmailTemplate corpo(String corpo) {
        this.corpo = corpo;
        return this;
    }


    @Override
    public String toString() {
        return new StringJoiner(", ", EmailTemplate.class.getSimpleName() + "[", "]")
                .add("remetente='" + remetente + "'")
                .add("destinatario='" + destinatario + "'")
                .add("assunto='" + assunto + "'")
                .toString();
    }
}
