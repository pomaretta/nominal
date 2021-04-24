/*

 Nominal Application
 Application Manager

 @author     Carlos Pomares
 Date        2021-04-23

*/

package application;

public class Application {

    private String[] args;
    private static Application application;

    private application.Manager applicationManager;
    private scenes.Manager sceneManager;

    private Application(String[] initArgs) {
        this.args = initArgs;
        applicationManager = new application.Manager();
        sceneManager = new scenes.Manager(applicationManager.getStage(),this,1280,720);
    }

    public String[] getArgs() {
        return args;
    }

    public static Application getApplication() {
        return application;
    }

    public Manager getApplicationManager() {
        return applicationManager;
    }

    public scenes.Manager getSceneManager() {
        return sceneManager;
    }

    public static Application init(String[] initArgs) throws Exception {
        if (application != null){
            throw new Exception("Application already assigned.");
        }
        application = new Application(initArgs);
        return application;
    }

}
