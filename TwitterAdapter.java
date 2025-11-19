import java.time.Instant;

/**
 * Adapter para TwitterApiFake.
 * Converte Conteudo -> chamada tweet(message).
 */
public class TwitterAdapter implements ISocialAdapter {

    private final TwitterApiFake api = new TwitterApiFake();

    @Override
    public Publicacao publicarAgora(Conteudo conteudo) throws Exception {
        // adaptação simples: usamos título+texto como tweet
        String texto = (conteudo.titulo != null ? conteudo.titulo + " - " : "") + conteudo.texto;
        String id = api.tweet(texto);

        String msg = "Tweet publicado: " + id;
        return new Publicacao(getPlataformaNome(), Instant.now(), msg, true);
    }

    @Override
    public Publicacao publicarAgendado(Conteudo conteudo) throws Exception {
        // adapter não cuida do agendamento real (o manager faz) — apenas publica
        return publicarAgora(conteudo);
    }

    @Override
    public Estatisticas obterEstatisticas(String publicacaoId) throws Exception {
        int likes = api.likes(publicacaoId);
        int retweets = api.retweets(publicacaoId);
        return new Estatisticas(getPlataformaNome(), likes, retweets, 0);
    }

    @Override
    public String getPlataformaNome() {
        return "Twitter";
    }
}
