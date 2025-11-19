import java.time.Instant;

/**
 * Adapter para LinkedInApiFake.
 */
public class LinkedInAdapter implements ISocialAdapter {

    private final LinkedInApiFake api = new LinkedInApiFake();

    @Override
    public Publicacao publicarAgora(Conteudo conteudo) throws Exception {
        String headline = conteudo.titulo != null ? conteudo.titulo : "Post";
        String body = conteudo.texto;
        String id = api.shareArticle(headline, body);
        return new Publicacao(getPlataformaNome(), Instant.now(), "LinkedIn shareId: " + id, true);
    }

    @Override
    public Publicacao publicarAgendado(Conteudo conteudo) throws Exception {
        return publicarAgora(conteudo);
    }

    @Override
    public Estatisticas obterEstatisticas(String publicacaoId) throws Exception {
        int applause = api.applause(publicacaoId);
        int shares = api.shares(publicacaoId);
        return new Estatisticas(getPlataformaNome(), applause, shares, 0);
    }

    @Override
    public String getPlataformaNome() { return "LinkedIn"; }
}
