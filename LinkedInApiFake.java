/**
 * Simula API do LinkedIn.
 */
public class LinkedInApiFake {
    public String shareArticle(String headline, String body) {
        return "li-" + System.currentTimeMillis();
    }

    public int applause(String id) { return (int)(Math.random() * 500); }
    public int shares(String id) { return (int)(Math.random() * 100); }
}
