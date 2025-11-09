package xyz.ianworley.flavoroftheday.bean;

import org.springframework.stereotype.Component;
import xyz.ianworley.flavoroftheday.services.FlavorOfTheDayProvider;

import java.util.HashMap;
import java.util.Map;

@Component
public class FlavorOfTheDayBeanFactory {
    private Map<String, FlavorOfTheDayProvider> iceCreams = new HashMap<>();


    public FlavorOfTheDayBeanFactory(Map<String, FlavorOfTheDayProvider> iceCreams) {
        this.iceCreams = iceCreams;
    }


    public FlavorOfTheDayProvider getIceCream(String flavor){
        return iceCreams.get(flavor);
    }
}
