package view;

public abstract class BaseController {

    protected StageManager stageManager;

    public void setManager(StageManager stageManager){
        this.stageManager = stageManager;
    }

    public StageManager getStageManager() {
        return stageManager;
    }
}
