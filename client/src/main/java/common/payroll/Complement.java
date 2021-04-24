/*

 Nominal Application
 Complement

 @author     Carlos Pomares
 Date        2021-04-24

*/

package common.payroll;

public class Complement {

    private final String name;
    private final float originalValue;
    private final float valuePercentage;
    private final float value;

    public Complement(String name, float originalValue, float valuePercentage, float value) {
        this.name = name;
        this.originalValue = originalValue;
        this.valuePercentage = valuePercentage;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public float getOriginalValue() {
        return originalValue;
    }

    public float getValuePercentage() {
        return valuePercentage;
    }

    public float getValue() {
        return value;
    }
}
