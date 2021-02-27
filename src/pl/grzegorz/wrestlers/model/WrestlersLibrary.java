package pl.grzegorz.wrestlers.model;

import pl.grzegorz.wrestlers.exceptions.EmployeeAlreadyExistsException;
import pl.grzegorz.wrestlers.exceptions.UserAllreadyExistsException;

import java.io.Serializable;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class WrestlersLibrary implements Serializable {

    private Map<String, Company> company = new HashMap<>();
    private Map<Integer, LibraryUser> users = new HashMap<>();

    public Map<String, Company> getCompany() {
        return company;
    }

    public Map<Integer, LibraryUser> getUsers() {
        return users;
    }


    public void addEmployees(Company organization) {
        if(company.containsKey(organization.getOrganizationName())) {
            throw new EmployeeAlreadyExistsException("This employee allready exists in the company!");
        }
        company.put(organization.getOrganizationName(), organization);
    }

    public void addUser(LibraryUser user) {
        if(users.containsKey(user.getId())){
            throw new UserAllreadyExistsException("User with this ID allready exists in database!");
        }
        users.put(user.getId(), user);
    }

    public boolean removeEmployee(Company comp) {
        if(company.containsValue(comp)){
            company.remove(comp.getOrganizationName());
            return true;
        }

        return false;
    }
}
