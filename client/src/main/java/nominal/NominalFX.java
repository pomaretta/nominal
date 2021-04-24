/*

 Nominal Application
 Main

 @author     Carlos Pomares
 Date        2021-04-24

*/

package nominal;

import application.Application;

public class NominalFX {
    public static void main(String[] args) throws Exception {
        Application application = Application.init(args);
        application.getApplicationManager().getStage().show();
    }
}
