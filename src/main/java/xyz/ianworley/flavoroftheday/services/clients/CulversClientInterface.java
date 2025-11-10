package xyz.ianworley.flavoroftheday.services.clients;

import xyz.ianworley.flavoroftheday.dto.Culvers.CulversApiResponse;

public interface CulversClientInterface {
    CulversApiResponse getFlavorOfTheDay(String zipCode, long limit);
}
