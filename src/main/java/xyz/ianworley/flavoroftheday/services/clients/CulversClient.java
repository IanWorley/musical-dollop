package xyz.ianworley.flavoroftheday.services.clients;

import org.springframework.context.annotation.Scope;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import org.springframework.web.util.UriBuilder;
import org.springframework.web.util.UriComponentsBuilder;
import xyz.ianworley.flavoroftheday.dto.Culvers.CulversApiResponse;
import xyz.ianworley.flavoroftheday.model.IceCream;

import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

@Component
public class CulversClient {
    private final RestClient restClient;
    private final URI culversUrl = new URI("https://web.culvers.com/api/locator/getLocations");

    public CulversClient(RestClient restClient) throws URISyntaxException {
        this.restClient = restClient;
    }

    public CulversApiResponse getFlavorOfTheDay(String zipCode, long limit) {

        var uri = UriComponentsBuilder.fromUri(culversUrl).queryParam("location", zipCode).queryParam("limit", limit).build().toUri();
        var x =   restClient.get().uri(uri).retrieve();
        var  culversApiResponse = x.toEntity(CulversApiResponse.class);
        if (culversApiResponse.getStatusCode().is2xxSuccessful()) {
            if (culversApiResponse.getBody().isSuccessful) {
                return culversApiResponse.getBody();
            }
            else {
                return null;
            }
        }
        else {
            return null;
        }
    }



}
