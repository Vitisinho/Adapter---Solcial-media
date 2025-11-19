import java.time.Instant;
import java.time.Duration;
import java.util.*;
import java.util.concurrent.*;

/**
 * Gerenciador unificado: registra adapters e oferece API única para o resto do sistema.
 *
 * Design:
 * - Depende de abstração ISocialAdapter (Dependency Inversion)
 * - Responsabilidade única: orquestrar publicações/agendamento/estatísticas
 * - Usa ScheduledExecutorService para agendamento
 */
public class GerenciadorMidiaSocial {

    private final Map<String, ISocialAdapter> adapters = new ConcurrentHashMap<>();
    private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(4);

    // Registro dinâmico de adapters
    public void registrarAdapter(ISocialAdapter adapter) {
        adapters.put(adapter.getPlataformaNome(), adapter);
        System.out.println("Adapter registrado: " + adapter.getPlataformaNome());
    }

    // Publicar agora (chama adapter correspondente)
    public Publicacao publicarAgora(String plataforma, Conteudo conteudo) {
        ISocialAdapter adapter = adapters.get(plataforma);
        if (adapter == null) {
            System.out.println("Plataforma não registrada: " + plataforma);
            return new Publicacao(plataforma, Instant.now(), "Plataforma não encontrada", false);
        }
        try {
            return adapter.publicarAgora(conteudo);
        } catch (Exception e) {
            return new Publicacao(plataforma, Instant.now(), "Erro: " + e.getMessage(), false);
        }
    }

    // Agendar publicação em um instante futuro
    public ScheduledFuture<Publicacao> agendarPublicacao(String plataforma, Conteudo conteudo, Instant quando) {
    long delayMs = Math.max(0, Duration.between(Instant.now(), quando).toMillis());
    ISocialAdapter adapter = adapters.get(plataforma);

    if (adapter == null) {
        // CORREÇÃO: usar scheduler.schedule para retornar um ScheduledFuture válido
        return scheduler.schedule(() ->
                new Publicacao(plataforma, Instant.now(), "Plataforma não encontrada", false),
                delayMs,
                TimeUnit.MILLISECONDS
        );
    }

    // Caso normal
    return scheduler.schedule(() -> {
        try {
            return adapter.publicarAgendado(conteudo);
        } catch (Exception e) {
            return new Publicacao(plataforma, Instant.now(), "Erro agendamento: " + e.getMessage(), false);
        }
    }, delayMs, TimeUnit.MILLISECONDS);
}


    // Obter estatísticas
    public Estatisticas obterEstatisticas(String plataforma, String publicacaoId) {
        ISocialAdapter adapter = adapters.get(plataforma);
        if (adapter == null) {
            return new Estatisticas(plataforma, 0, 0, 0);
        }
        try {
            return adapter.obterEstatisticas(publicacaoId);
        } catch (Exception e) {
            System.out.println("Erro ao buscar estatísticas: " + e.getMessage());
            return new Estatisticas(plataforma, 0, 0, 0);
        }
    }

    public void shutdown() {
        scheduler.shutdown();
    }
}
