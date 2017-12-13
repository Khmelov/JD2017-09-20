package by.it.halai.jd03_03.jaxbbeans;

import by.it.halai.jd03_02.beans.*;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "usersJ"
})
@XmlRootElement(name = "usersJ")
public class UsersJ {

    @XmlElement(name = "users", required = true)
    List<User> usersJ = new ArrayList<>();

    public UsersJ() {
    }

    public UsersJ(List<User> usersJ) {
        this.usersJ = usersJ;
    }

    public List<User> getUsersJ() {
        return usersJ;
    }

    public void setUsersJ(List<User> usersJ) {
        this.usersJ = usersJ;
    }
}

