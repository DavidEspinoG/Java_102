package Assignment_four;
import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

public class MapsToMaps {
    public static void main(String[] args) {
        mapsToMaps();
    }
    public static void mapsToMaps(){
        Map<String, Integer> channelToSubscribers    = new TreeMap<>(); // channel, numSubscribers
        Map<String, String> channelToPublisher       = new TreeMap<>(); // channel, publisher
        Map<String, Integer> publisherToSubscribers  = new TreeMap<>(); // publisher, numSubscribers

        // channel -> number of subscribers
        // K -> V1
        channelToSubscribers.put("JustForLaughs", 120_000);
        channelToSubscribers.put("JustForGags", 10_000);
        channelToSubscribers.put("ContemplationTechniques", 10_000);
        channelToSubscribers.put("A New Earth", 20_000);

        // channel -> publisher
        // K -> V2
        channelToPublisher.put("JustForLaughs", "Charlie Chaplin");
        channelToPublisher.put("JustForGags", "Charlie Chaplin");
        channelToPublisher.put("ContemplationTechniques", "Echhart Tolle");
        channelToPublisher.put("A New Earth", "Echhart Tolle");

        // 1. Setup "publisherToSubscribers"
        // publisher -> number of subscribers (total)
        // V2 -> V1
        channelToSubscribers.forEach((channel, subscribers) -> {
                String publisher = channelToPublisher.get(channel);
                if (publisherToSubscribers.containsKey(publisher)) {
                    int currentSubscribers = publisherToSubscribers.get(publisher);
                    int newVal = currentSubscribers + subscribers;
                    publisherToSubscribers.put(publisher, newVal);
                } else {
                    publisherToSubscribers.put(publisher, subscribers);
                }
        });

        // 2. Output "publisherToSubscribers"
        publisherToSubscribers.forEach((publisher, subscriber) -> System.out.println("Publisher: " + publisher + " Suscribers: " + subscriber));
        // 3. Who has the most/least subscribers?
        int maxSubscribers = Collections.max(publisherToSubscribers.values());
        int minSubscribers = Collections.min(publisherToSubscribers.values());
        publisherToSubscribers.forEach((publisher, subscribers) -> {
           if(maxSubscribers == subscribers ) {
               System.out.println("The publisher with most subscribers is: " + publisher);
           } else if (minSubscribers == subscribers) {
               System.out.println("The publisher with most subscribers is: " + publisher);
            }
        });
    }
}

