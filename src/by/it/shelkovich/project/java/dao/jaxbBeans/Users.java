package by.it.shelkovich.project.java.dao.jaxbBeans;

import by.it.shelkovich.project.java.dao.entities.User;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "users"
})
@XmlRootElement(name="Users")
public class Users {
    @XmlElement(required = true, name="User")
    List<User> users;

    public Users() {
    }

    public Users(List<User> users) {
        this.users = users;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
