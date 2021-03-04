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
            throw new EmployeeAlreadyExistsException("Taki użytkownik już istnieje!");
        }
        company.put(organization.getRank(), organization);
    }

    public void addUser(LibraryUser user) {
        if(users.containsKey(user.getId())){
            throw new UserAllreadyExistsException("Użytkownik z takim ID już istnieje!");
        }
        users.put(user.getId(), user);
    }

    public boolean removeWrestler(Organization org) {
        if(company.containsKey(org.getRank())) {
            company.remove(org.getRank());
            return true;
        }

        return false;
    }
}
