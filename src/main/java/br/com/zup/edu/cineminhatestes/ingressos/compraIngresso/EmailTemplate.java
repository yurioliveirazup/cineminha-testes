package br.com.zup.edu.cineminhatestes.ingressos.compraIngresso;

import java.util.StringJoiner;

public class EmailTemplate {

    private String remetente;
    private String destinatario;
    private String assunto;
    private String corpo;

    public EmailTemplate(String remetente,
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

    @Override
    public String toString() {
        return new StringJoiner(", ", EmailTemplate.class.getSimpleName() + "[", "]")
                .add("remetente='" + remetente + "'")
                .add("destinatario='" + destinatario + "'")
                .add("assunto='" + assunto + "'")
                .toString();
    }
}
