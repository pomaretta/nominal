/*

 Nominal Application
 Nominal Base Controller

 @author     Carlos Pomares
 Date        2021-04-28

*/

package view;

public abstract class BaseController {

    protected StageManager stageManager;

    public void setManager(StageManager stageManager){
        this.stageManager = stageManager;
    }

}
