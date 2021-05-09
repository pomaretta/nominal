/*

 Nominal Application
 Nominal View Controller

 @author     Carlos Pomares
 Date        2021-04-28

*/

package view;

public abstract class ViewController {

    protected ViewManager manager;

    public void setManager(ViewManager manager){
        this.manager = manager;
    }

    public abstract void run();

    public abstract void shouldUpdate();

}
