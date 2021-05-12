package common.company;

import common.NominalObject;

public class Currency extends NominalObject {

    private final int id;
    private final String name;
    private final String digit;

    public Currency(int id, String name, String digit) {
        this.id = id;
        this.name = name;
        this.digit = digit;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDigit() {
        return digit;
    }
}
