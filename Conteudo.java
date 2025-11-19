/**
 * Modelo unificado de conteúdo a ser publicado.
 * Pode ser estendido (ex.: anexos, imagens, vídeo, tags).
 */
public class Conteudo {
    public final String titulo;
    public final String texto;
    public final String midiaUrl; // opcional (imagem, vídeo)
    public final String plataformaOrigem; // informativo

    public Conteudo(String titulo, String texto, String midiaUrl, String plataformaOrigem) {
        this.titulo = titulo;
        this.texto = texto;
        this.midiaUrl = midiaUrl;
        this.plataformaOrigem = plataformaOrigem;
    }

    @Override
    public String toString() {
        return "Conteudo{titulo='" + titulo + "', texto='" + texto + "', midiaUrl='" + midiaUrl + "', plataformaOrigem='" + plataformaOrigem + "'}";
    }
}
