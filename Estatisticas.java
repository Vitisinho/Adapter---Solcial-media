/**
 * Modelo unificado de estatísticas (simplificado).
 */
public class Estatisticas {
    public final String plataforma;
    public final int curtidas;
    public final int compartilhamentos;
    public final int comentarios;

    public Estatisticas(String plataforma, int curtidas, int compartilhamentos, int comentarios) {
        this.plataforma = plataforma;
        this.curtidas = curtidas;
        this.compartilhamentos = compartilhamentos;
        this.comentarios = comentarios;
    }

    @Override
    public String toString() {
        return "Estatisticas{plataforma='" + plataforma + "', curtidas=" + curtidas + ", compartilhamentos=" + compartilhamentos + ", comentarios=" + comentarios + "}";
    }
}
