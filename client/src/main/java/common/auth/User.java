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
    private Privilege privilege;
    private final String name;
    private final String password;

    public User(int id, HashSet<Company> companies, String name, String password, Privilege privilege) {
        this.id = id;
        this.companies = companies;
        this.name = name;
        this.password = password;
        this.privilege = privilege;
    }

    public User(int id, Privilege privilege, String name, String password) {
        this.id = id;
        this.privilege = privilege;
        this.name = name;
        this.password = password;
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

    public Privilege getPrivilege() {
        return privilege;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

}
