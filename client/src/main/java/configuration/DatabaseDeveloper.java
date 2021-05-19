/*

 Nominal Application
 Database Developer Credentials

 @author     Carlos Pomares
 Date        2021-04-29

*/

package configuration;

public enum DatabaseDeveloper {

    /**
     *
     * Enum of the different credentials used
     * for set up default connection with DB.
     *
     */

    NOMINAL {
        @Override
        public String getUser() {
            return "grup2";
        }
        @Override
        public String getPassword() {
            return "Adan";
        }
        @Override
        public String getHostname() {
            return "194.224.79.42";
        }
        @Override
        public String getPort() {
            return "43306";
        }
        @Override
        public String getDatabase() {
            return "grup2";
        }
    },
    AUTH {
        @Override
        public String getUser() {
            return "grup2";
        }
        @Override
        public String getPassword() {
            return "Adan";
        }
        @Override
        public String getHostname() {
            return "194.224.79.42";
        }
        @Override
        public String getPort() {
            return "43306";
        }
        @Override
        public String getDatabase() {
            return "grup2";
        }
    },
    IMAGE {
        @Override
        public String getUser() {
            return "grup2";
        }
        @Override
        public String getPassword() {
            return "Adan";
        }
        @Override
        public String getHostname() {
            return "194.224.79.42";
        }
        @Override
        public String getPort() {
            return "43306";
        }
        @Override
        public String getDatabase() {
            return "grup2";
        }
    };

    public abstract String getUser();
    public abstract String getPassword();
    public abstract String getHostname();
    public abstract String getPort();
    public abstract String getDatabase();

    public String getURL(){
        return String.format("jdbc:mysql://%s:%s/%s",getHostname(),getPort(),getDatabase());
    }

}
