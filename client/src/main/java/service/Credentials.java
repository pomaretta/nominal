/*

 Nominal Application
 Nominal Credentials

 @author     Carlos Pomares
 Date        2021-04-24

*/

package service;

public enum Credentials {

    /**
     *
     * Enum of the different credentials used
     * for set up default connection with DB.
     *
     */

    USERNAME("USERNAME"),
    PASSWORD("PASSWORD"),
    DATABASE("DATABASE"),
    HOST("HOST"),
    PORT("PORT");

    private final String data;

    Credentials(String data) {
        this.data = data;
    }

    public String getData() {
        return data;
    }

    public static String getUrl(){
        return String.format("jdbc:mysql://%s:%s/%s",HOST.data,PORT.data,DATABASE.data);
    }

}
