/*

 Nominal Application
 User

*/

package common.auth;

import common.NominalObject;
import common.company.Company;

import java.util.HashSet;
public class User extends NominalObject {

    //Atributtes
    private int id;
    private HashSet<Company> companies;
    private Privilege privilege;
    private final String name;
    private String password;

    /**
     *
     * @param id user identificator
     * @param companies companies that the user can manage
     * @param name user name
     * @param password password for user auth
     * @param privilege user privileges
     */
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

    public User(String name, String password, Privilege privilege) {
        this.name = name;
        this.password = password;
        this.privilege = privilege;
    }

    // GETTERS
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

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPrivilege(Privilege privilege) {
        this.privilege = privilege;
    }

}
