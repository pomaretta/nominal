/*

 Nominal Application
 Nominal Views

 @author     Carlos Pomares
 Date        2021-04-28

*/

package application;

public enum Views {

    /**
     *
     * Contains the main scenes that are in the application
     * with their name for Application title and FXML path
     *
     */

    LOGIN {
        @Override
        public String getTitle() {
            return "Login";
        }

        @Override
        public String getFile() {
            return "/fxml/login.fxml";
        }
    },
    HOME {
        @Override
        public String getTitle() {
            return "Home";
        }

        @Override
        public String getFile() {
            return "/fxml/main_view.fxml";
        }
    };

    public abstract String getTitle();
    public abstract String getFile();

}
