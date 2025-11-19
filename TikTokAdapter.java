import java.time.Instant;

/**
 * Adapter para TikTokApiFake.
 */
public class TikTokAdapter implements ISocialAdapter {

    private final TikTokApiFake api = new TikTokApiFake();

    @Override
    public Publicacao publicarAgora(Conteudo conteudo) throws Exception {
        // Simulamos: se midiaUrl é nulo, erro (TikTok precisa de vídeo)
        if (conteudo.midiaUrl == null) {
            throw new IllegalArgumentException("TikTok: vídeo obrigatório (midiaUrl).");
        }
        byte[] dummy = new byte[0];
        String id = api.uploadVideo(dummy, conteudo.texto);
        return new Publicacao(getPlataformaNome(), Instant.now(), "TikTok uploadId: " + id, true);
    }

    @Override
    public Publicacao publicarAgendado(Conteudo conteudo) throws Exception {
        return publicarAgora(conteudo);
    }

    @Override
    public Estatisticas obterEstatisticas(String publicacaoId) throws Exception {
        int hearts = api.hearts(publicacaoId);
        int shares = api.shares(publicacaoId);
        int comments = api.comments(publicacaoId);
        return new Estatisticas(getPlataformaNome(), hearts, shares, comments);
    }

    @Override
    public String getPlataformaNome() { return "TikTok"; }
}
