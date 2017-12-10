package by.it.shelkovich.project.java.dao.jaxbBeans;

import by.it.shelkovich.project.java.dao.entities.Role;
import by.it.shelkovich.project.java.dao.entities.User;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "roles"
})
@XmlRootElement(name="Roles")
public class Roles {
    @XmlElement(name="Role")
    List<Role> roles;

    public Roles() {
    }

    public List<Role> getRoles() {
        return roles;
    }

    public Roles(List<Role> roles) {
        this.roles = roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
}
