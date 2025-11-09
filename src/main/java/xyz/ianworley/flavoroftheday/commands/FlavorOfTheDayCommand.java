package xyz.ianworley.flavoroftheday.commands;

import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import xyz.ianworley.flavoroftheday.model.IceCream;
import xyz.ianworley.flavoroftheday.services.FlavorOfTheDayProvider;

@ShellComponent
public class FlavorOfTheDayCommand {
    private final FlavorOfTheDayProvider flavorOfTheDayProvider;

    FlavorOfTheDayCommand(FlavorOfTheDayProvider flavorOfTheDayProvider) {
        this.flavorOfTheDayProvider = flavorOfTheDayProvider;
    }

    @ShellMethod(key = "fotd", value = "Prints the flavor of the day")
    public void getFlavorOfTheDay() {
         flavorOfTheDayProvider.displayFlavorOfTheDay();
    }
}
