package at.htlkaindorf.pojo;

public enum Classname {
    AHIF24("3AHIF"),
    BHIF24("3BHIF"),
    CHIF24("3CHIF"),
    DHIF24("3DHIF"),
    AHIF23("4AHIF"),
    BHIF23("4BHIF"),
    CHIF23("4CHIF"),
    DHIF23("4DHIF");

    private final String name;

    Classname(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
