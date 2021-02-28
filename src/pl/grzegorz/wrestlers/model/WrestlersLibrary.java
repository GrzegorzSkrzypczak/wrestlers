package pl.grzegorz.wrestlers.model;

import pl.grzegorz.wrestlers.exceptions.EmployeeAlreadyExistsException;
import pl.grzegorz.wrestlers.exceptions.UserAllreadyExistsException;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class WrestlersLibrary implements Serializable {

    private Map<String, Organization> company = new HashMap<>();
    private Map<Integer, LibraryUser> users = new HashMap<>();

    public Map<String, Organization> getCompany() {
        return company;
    }

    public Map<Integer, LibraryUser> getUsers() {
        return users;
    }


    public void addEmployees(Organization organization) {
        if(company.containsKey(organization.getOrganizationFullName())) {
            throw new EmployeeAlreadyExistsException("This employee allready exists in the company!");
        }
        company.put(organization.getOrganizationFullName(), organization);
    }

    public void addUser(LibraryUser user) {
        if(users.containsKey(user.getId())){
            throw new UserAllreadyExistsException("User with this ID allready exists in database!");
        }
        users.put(user.getId(), user);
    }

    public boolean removeEmployee(Organization comp) {
        if(company.containsValue(comp)){
            company.remove(comp.getOrganizationFullName());
            return true;
        }

        return false;
    }
}
