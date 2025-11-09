package xyz.ianworley.flavoroftheday.model;

public class IceCream {
    public String flavor;
    public String description;

    public IceCream(String flavor, String description) {
        this.flavor = flavor;
        this.description = description;
    }

    public IceCream() {
    }

    public String getDescription() {
        return description;
    }

    public String getFlavor() {
        return flavor;
    }

    public String toString() {
        return String.format("%s: %s", flavor, description);
    }
}

