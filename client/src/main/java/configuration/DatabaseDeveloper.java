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
            return "USERNAME";
        }
        @Override
        public String getPassword() {
            return "PASSWORD";
        }
        @Override
        public String getHostname() {
            return "HOSTNAME";
        }
        @Override
        public String getPort() {
            return "PORT";
        }
        @Override
        public String getDatabase() {
            return "DATABASE";
        }
    },
    AUTH {
        @Override
        public String getUser() {
            return "USERNAME";
        }
        @Override
        public String getPassword() {
            return "PASSWORD";
        }
        @Override
        public String getHostname() {
            return "HOSTNAME";
        }
        @Override
        public String getPort() {
            return "PORT";
        }
        @Override
        public String getDatabase() {
            return "DATABASE";
        }
    },
    IMAGE {
        @Override
        public String getUser() {
            return "USERNAME";
        }
        @Override
        public String getPassword() {
            return "PASSWORD";
        }
        @Override
        public String getHostname() {
            return "HOSTNAME";
        }
        @Override
        public String getPort() {
            return "PORT";
        }
        @Override
        public String getDatabase() {
            return "DATABASE";
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
