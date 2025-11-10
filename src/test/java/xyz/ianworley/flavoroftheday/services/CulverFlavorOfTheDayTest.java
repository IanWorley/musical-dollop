package xyz.ianworley.flavoroftheday.services;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import xyz.ianworley.flavoroftheday.dto.Culvers.CulversApiResponse;
import xyz.ianworley.flavoroftheday.services.clients.CulversClientInterface;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CulverFlavorOfTheDayTest {

    @Mock
    private CulversClientInterface culversClient;

    @InjectMocks
    private CulverFlavorOfTheDay culverFlavorOfTheDay;

    @Test
    void displayFlavorOfTheDay_Success() {
        var metadata = new xyz.ianworley.flavoroftheday.dto.Culvers.Metadata();
        metadata.flavorOfDayName = "Chocolate";
        metadata.flavorOfTheDayDescription = "Rich chocolate ice cream";
        
        var geofence = new xyz.ianworley.flavoroftheday.dto.Culvers.Geofence();
        geofence.metadata = metadata;
        
        var data = new xyz.ianworley.flavoroftheday.dto.Culvers.Data();
        data.geofences = new java.util.ArrayList<>();
        data.geofences.add(geofence);
        
        var response = new CulversApiResponse();
        response.isSuccessful = true;
        response.data = data;

        when(culversClient.getFlavorOfTheDay("64029", 1)).thenReturn(response);

        assertDoesNotThrow(() -> culverFlavorOfTheDay.displayFlavorOfTheDay());
        verify(culversClient).getFlavorOfTheDay("64029", 1);
    }

    @Test
    void displayFlavorOfTheDay_ThrowsException_WhenResponseIsNull() {
        when(culversClient.getFlavorOfTheDay("64029", 1)).thenReturn(null);

        assertThrows(RuntimeException.class, () -> culverFlavorOfTheDay.displayFlavorOfTheDay());
    }
}
