/**
 * Simula API do Instagram com outro modelo.
 */
public class InstagramApiFake {
    public String uploadPhoto(String caption, String photoUrl) {
        return "ig-" + System.currentTimeMillis();
    }

    public int heartCount(String id) { return (int)(Math.random() * 2000); }
    public int commentCount(String id) { return (int)(Math.random() * 300); }
}
