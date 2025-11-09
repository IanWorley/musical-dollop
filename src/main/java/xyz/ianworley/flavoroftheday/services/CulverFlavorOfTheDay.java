package xyz.ianworley.flavoroftheday.services;

import org.springframework.shell.table.*;
import org.springframework.stereotype.Service;
import xyz.ianworley.flavoroftheday.model.IceCream;
import xyz.ianworley.flavoroftheday.services.clients.CulversClient;

@Service
public class CulverFlavorOfTheDay implements FlavorOfTheDayProvider{

    private final CulversClient culversClient;

    public CulverFlavorOfTheDay(CulversClient culversClient){
        this.culversClient = culversClient;

    }

    @Override
    public void displayFlavorOfTheDay() {

       var webRequest = culversClient.getFlavorOfTheDay("64029", 1);
        if(webRequest == null){
            throw new RuntimeException("Could not get flavor of the day from culvers");
        }
        var store =  webRequest.data.geofences.getFirst().metadata;
        var IceCream = new IceCream(store.flavorOfDayName, store.flavorOfTheDayDescription);
        TableModel model = new ArrayTableModel(new Object[][] {  { "Flavor", "Description" },
                { IceCream.flavor, IceCream.description } });
        TableBuilder tableBuilder = new TableBuilder(model);
        tableBuilder.addFullBorder(BorderStyle.oldschool);
        System.out.println(tableBuilder.build().render(300));


    }

}
