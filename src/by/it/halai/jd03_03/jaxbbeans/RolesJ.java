package by.it.halai.jd03_03.jaxbbeans;

import by.it.halai.jd03_02.beans.*;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "rolesJ"
})
@XmlRootElement(name = "rolesJ")

public class RolesJ {


    @XmlElement(name = "roles", required = true)
    List<Role> rolesJ = new ArrayList<>();

    public RolesJ() {
    }

    public RolesJ(List<Role> rolesJ) {
        this.rolesJ = rolesJ;
    }

    public List<Role> getRolesJ() {
        return rolesJ;
    }

    public void setRolesJ(List<Role> rolesJ) {
        this.rolesJ = rolesJ;
    }

    @Override
    public String toString() {
        return "RolesJ{" +
                "rolesJ=" + rolesJ +
                '}';
    }
}

