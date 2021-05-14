package error;

import java.util.ArrayList;

public class Logger {

    private final ArrayList<Object> errors;

    public Logger(){
        this.errors = new ArrayList<>();
    }

    public void add(Object o){
        this.errors.add(o);
    }

    public void clear(){
        this.errors.clear();
    }

    public ArrayList<Object> getErrors() {
        return errors;
    }

}