/**
 * Simula API do TikTok.
 */
public class TikTokApiFake {
    public String uploadVideo(byte[] data, String description) {
        return "tt-" + System.currentTimeMillis();
    }

    public int hearts(String id) { return (int)(Math.random() * 5000); }
    public int shares(String id) { return (int)(Math.random() * 800); }
    public int comments(String id) { return (int)(Math.random() * 400); }
}
