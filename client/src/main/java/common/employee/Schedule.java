package common.employee;

import common.NominalObject;

import java.sql.Timestamp;

public class Schedule extends NominalObject {

    private int id;
    private final Employee employee;
    private final Timestamp creation;
    private final boolean nocturnal;
    private final boolean turnicity;
    private final float complementaryHours;
    private final float extraHours;
    private final float overwhelmingHours;

    public Schedule(int id, Employee employee, Timestamp creation, boolean nocturnal, boolean turnicity, float complementaryHours, float extraHours, float overwhelmingHours) {
        this.id = id;
        this.employee = employee;
        this.creation = creation;
        this.nocturnal = nocturnal;
        this.turnicity = turnicity;
        this.complementaryHours = complementaryHours;
        this.extraHours = extraHours;
        this.overwhelmingHours = overwhelmingHours;
    }

    public Schedule(Employee employee, Timestamp creation, boolean nocturnal, boolean turnicity, float complementaryHours, float extraHours, float overwhelmingHours) {
        this.employee = employee;
        this.creation = creation;
        this.nocturnal = nocturnal;
        this.turnicity = turnicity;
        this.complementaryHours = complementaryHours;
        this.extraHours = extraHours;
        this.overwhelmingHours = overwhelmingHours;
    }

    public int getId() {
        return id;
    }

    public Employee getEmployee() {
        return employee;
    }

    public Timestamp getCreation() {
        return creation;
    }

    public boolean isNocturnal() {
        return nocturnal;
    }

    public boolean isTurnicity() {
        return turnicity;
    }

    public float getComplementaryHours() {
        return complementaryHours;
    }

    public float getExtraHours() {
        return extraHours;
    }

    public float getOverwhelmingHours() {
        return overwhelmingHours;
    }
}
