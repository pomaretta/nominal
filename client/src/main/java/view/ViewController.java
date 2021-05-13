package view;

public abstract class ViewController {

    protected ViewManager manager;

    public void setManager(ViewManager manager){
        this.manager = manager;
    }

    public abstract void run();

    public abstract void shouldUpdate();

}
