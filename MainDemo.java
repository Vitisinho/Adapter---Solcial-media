import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.ScheduledFuture;

/**
 * Demonstração do uso do Gerenciador com adapters.
 */
public class MainDemo {
    public static void main(String[] args) throws Exception {

        GerenciadorMidiaSocial gerenciador = new GerenciadorMidiaSocial();

        // Registrando adapters (podem vir de configuração)
        gerenciador.registrarAdapter(new TwitterAdapter());
        gerenciador.registrarAdapter(new InstagramAdapter());
        gerenciador.registrarAdapter(new LinkedInAdapter());
        gerenciador.registrarAdapter(new TikTokAdapter());

        // Criando conteúdo unificado
        Conteudo c1 = new Conteudo("Lançamento", "Produto X agora disponível!", "http://img.example.com/p.jpg", "Campanha");
        Conteudo c2 = new Conteudo("Vídeo Top", "Assista nosso trailer!", "http://video.example.com/v.mp4", "Campanha");

        System.out.println("\n--- Publicando agora no Twitter ---");
        Publicacao p1 = gerenciador.publicarAgora("Twitter", c1);
        System.out.println(p1);

        System.out.println("\n--- Publicando agora no Instagram ---");
        Publicacao p2 = gerenciador.publicarAgora("Instagram", c1);
        System.out.println(p2);

        System.out.println("\n--- Tentando publicar no TikTok sem vídeo (deve falhar) ---");
        Conteudo semVideo = new Conteudo("Só texto", "Texto para TikTok", null, "Campanha");
        Publicacao pTikFail = gerenciador.publicarAgora("TikTok", semVideo);
        System.out.println(pTikFail);

        System.out.println("\n--- Agendando publicação no LinkedIn para daqui a 3 segundos ---");
        Instant quando = Instant.now().plus(3, ChronoUnit.SECONDS);
        ScheduledFuture<Publicacao> futuro = gerenciador.agendarPublicacao("LinkedIn", c2, quando);

        // Aguardar resultado agendado (demo)
        System.out.println("Aguardando publicação agendada...");
        Publicacao pAgendada = futuro.get(); // bloqueia até execução
        System.out.println("Resultado agendado: " + pAgendada);

        System.out.println("\n--- Buscando estatísticas (exemplo) ---");
        Estatisticas est = gerenciador.obterEstatisticas("Twitter", p1.id);
        System.out.println(est);

        gerenciador.shutdown();
    }
}
