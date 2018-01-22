package za.co.tangentsolutions.praticalassignment.domain;

public enum Gender {
    M ("Male"),
    F("Female");
    private final String value;

    Gender(String value){
        this.value = value;
    }
}
