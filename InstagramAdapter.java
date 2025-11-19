import java.time.Instant;

/**
 * Adapter para InstagramApiFake.
 */
public class InstagramAdapter implements ISocialAdapter {

    private final InstagramApiFake api = new InstagramApiFake();

    @Override
    public Publicacao publicarAgora(Conteudo conteudo) throws Exception {
        String caption = (conteudo.titulo != null ? conteudo.titulo + " - " : "") + conteudo.texto;
        String id = api.uploadPhoto(caption, conteudo.midiaUrl);
        return new Publicacao(getPlataformaNome(), Instant.now(), "Instagram uploadId: " + id, true);
    }

    @Override
    public Publicacao publicarAgendado(Conteudo conteudo) throws Exception {
        return publicarAgora(conteudo);
    }

    @Override
    public Estatisticas obterEstatisticas(String publicacaoId) throws Exception {
        int heart = api.heartCount(publicacaoId);
        int comments = api.commentCount(publicacaoId);
        return new Estatisticas(getPlataformaNome(), heart, 0, comments);
    }

    @Override
    public String getPlataformaNome() { return "Instagram"; }
}
