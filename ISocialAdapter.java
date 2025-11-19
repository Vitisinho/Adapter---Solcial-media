/**
 * Interface que cada Adapter deve implementar.
 * Define contrato unificado para publicar, agendar e buscar estatísticas.
 */
public interface ISocialAdapter {
    /**
     * Publica imediatamente o conteúdo na plataforma.
     * Retorna um objeto Publicacao unificado.
     */
    Publicacao publicarAgora(Conteudo conteudo) throws Exception;

    /**
     * Agenda uma publicação para um timestamp definido.
     * Aqui simplificamos: o gerenciador fará o agendamento — o adapter apenas transforma/realiza a publicação no horário.
     */
    Publicacao publicarAgendado(Conteudo conteudo) throws Exception;

    /**
     * Obtém estatísticas unificadas.
     */
    Estatisticas obterEstatisticas(String publicacaoId) throws Exception;

    /**
     * Nome da plataforma (ex: "Twitter", "Instagram").
     */
    String getPlataformaNome();
}
