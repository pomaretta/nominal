/*

 Nominal Application
 Nominal Views

 @author     Carlos Pomares
 Date        2021-04-28

*/

package application;

public enum Views {

    LOGIN {
        @Override
        public String getTitle() {
            return "Login";
        }

        @Override
        public String getFile() {
            return "/fxml/login.fxml";
        }
    };

    public abstract String getTitle();
    public abstract String getFile();

}
