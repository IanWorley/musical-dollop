package xyz.ianworley.flavoroftheday.services.clients;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.web.client.RestClient;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.net.URISyntaxException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class BerryClient {

    private final RestClient restClient;
    private final URI BerryUrl = new URI("https://www.berrybrewery.com/flavor-of-the-day");

    public BerryClient(RestClient restClient) throws URISyntaxException {
        this.restClient = restClient;
    }

    public String getFlavorOfTheDay() {
        try {
            var html = restClient.get().uri(BerryUrl).retrieve().body(String.class);
            var doc = Jsoup.parse(html);
            Elements events = doc.select("article.tribe-events-calendar-month-mobile-events__mobile-event");

            DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("MMddyyyy");

            for (Element event : events) {
                // Extract date from <time datetime="...">
                Element timeElement = event.selectFirst("time[datetime]");
                if (timeElement != null) {
                    String dateStr = timeElement.attr("datetime");
                    LocalDate date = LocalDate.parse(dateStr, inputFormatter);
                    String formattedDate = date.format(outputFormatter);

                    // Extract flavor from the title attribute
                    String flavor = timeElement.attr("title");

                    System.out.println(flavor + " on " + formattedDate);

                    return flavor + " on " + formattedDate;
                }
            }
        } catch (Exception e) {
            return "Error getting flavor of the day";
        }
        return "";
    }
}
