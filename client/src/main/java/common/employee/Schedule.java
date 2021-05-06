package common.employee;

import java.sql.Timestamp;

public class Schedule {

    private int id;
    private final Employee employee;
    private final Timestamp creation;
    private final boolean nocturnal;
    private final boolean turnicity;
    private final float complementaryHours;

    public Schedule(int id, Employee employee, Timestamp creation, boolean nocturnal, boolean turnicity, float complementaryHours) {
        this.id = id;
        this.employee = employee;
        this.creation = creation;
        this.nocturnal = nocturnal;
        this.turnicity = turnicity;
        this.complementaryHours = complementaryHours;
    }

    public Schedule(Employee employee, Timestamp creation, boolean nocturnal, boolean turnicity, float complementaryHours) {
        this.employee = employee;
        this.creation = creation;
        this.nocturnal = nocturnal;
        this.turnicity = turnicity;
        this.complementaryHours = complementaryHours;
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

}
