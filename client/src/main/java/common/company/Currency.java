package common.company;

public class Currency {

    private final String name;
    private final String digit;

    public Currency(String name, String digit) {
        this.name = name;
        this.digit = digit;
    }

    public String getName() {
        return name;
    }

    public String getDigit() {
        return digit;
    }

}
