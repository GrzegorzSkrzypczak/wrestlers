package pl.grzegorz.wrestlers.model;

import pl.grzegorz.wrestlers.exceptions.EmployeeAlreadyExistsException;
import pl.grzegorz.wrestlers.exceptions.UserAllreadyExistsException;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class WrestlersLibrary implements Serializable {

    private Map<Integer, Organization> company = new HashMap<>();
    private Map<Integer, LibraryUser> users = new HashMap<>();

    public Map<Integer, Organization> getCompany() {
        return company;
    }
    public Map<Integer, LibraryUser> getUsers() {
        return users;
    }


    public void addWrestlers(Organization organization) {

        if(company.containsKey(organization.getRank())) {
            throw new EmployeeAlreadyExistsException("This employee allready exists in the company!");
        }
        company.put(organization.getRank(), organization);
    }

    public void addUser(LibraryUser user) {
        if(users.containsKey(user.getId())){
            throw new UserAllreadyExistsException("User with this ID allready exists in database!");
        }
        users.put(user.getId(), user);
    }

    public boolean removeWrestler(Organization comp) {
        if(company.containsValue(comp)){
            company.remove(comp.getRank());
            return true;
        }

        return false;
    }
}
