/**
 * Simula uma API de Twitter com métodos incompatíveis ao nosso modelo.
 */
public class TwitterApiFake {
    public String tweet(String message) {
        // retorna id do tweet
        return "tw-" + System.currentTimeMillis();
    }

    public int likes(String tweetId) {
        return (int)(Math.random() * 1000);
    }

    public int retweets(String tweetId) {
        return (int)(Math.random() * 200);
    }
}