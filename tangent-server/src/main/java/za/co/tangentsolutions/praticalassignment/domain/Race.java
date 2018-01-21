package za.co.tangentsolutions.praticalassignment.domain;

public enum Race {

    B("Black African"),
    C("Coloured"),
    I("Indian"),
    W("White"),
    N("None Dominant");

    private final String race;

    Race(String race) {
        this.race = race;
    }
}
