import java.time.Instant;
import java.util.UUID;

/**
 * Modelo unificado de publicação (resultado/metadata).
 */
public class Publicacao {
    public final String id;
    public final String plataforma;
    public final Instant horario;
    public final String mensagem;
    public final boolean sucesso;

    public Publicacao(String plataforma, Instant horario, String mensagem, boolean sucesso) {
        this.id = UUID.randomUUID().toString();
        this.plataforma = plataforma;
        this.horario = horario;
        this.mensagem = mensagem;
        this.sucesso = sucesso;
    }

    @Override
    public String toString() {
        return "Publicacao{id='" + id + "', plataforma='" + plataforma + "', horario=" + horario + ", sucesso=" + sucesso + ", mensagem='" + mensagem + "'}";
    }
}
