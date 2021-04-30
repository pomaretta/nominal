/*

 Nominal Application
 Auth User

 @author     Carlos Pomares
 Date        2021-04-29

*/

package common.auth;

import common.Company;

import java.util.HashSet;

public class User {

    private int id;
    private HashSet<Company> companies;
    private final String name;
    private final String password;

    public User(int id, String name, String password, HashSet<Company> companies) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.companies = companies;
    }

    public User(int id, String name, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
    }

    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public HashSet<Company> getCompanies() {
        return companies;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

}
