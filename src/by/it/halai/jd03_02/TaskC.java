package by.it.halai.jd03_02;

import by.it.halai.jd03_02.beans.*;
import by.it.halai.jd03_02.crud.*;
import by.it.halai.jd03_02.jaxbbeans.*;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.SQLException;
import java.util.List;


class TaskC {


    static void addTableData() {
        addData("src/by/it/halai/jd03_02/xml/Roles.xml", RolesJ.class);
        addData("src/by/it/halai/jd03_02/xml/Users.xml", UsersJ.class);
        addData("src/by/it/halai/jd03_02/xml/Users.xml", AdsJ.class);

    }


    private static void addData(String path, Class cls) {
        try {
            JAXBContext jc = JAXBContext.newInstance(cls);
            Unmarshaller u = jc.createUnmarshaller();
            FileReader reader = new FileReader(path);
            List<?> l;
            switch (cls.getSimpleName()) {
                case "UsersJ":
                    UsersJ usersJ = (UsersJ) u.unmarshal(reader);
                    l = usersJ.getUsersJ();
                    UsersCRUD uC = new UsersCRUD();
                    for (Object obj : l)
                        uC.create((User) obj);
                    break;
                case "RolesJ":
                    RolesJ rolesJ = (RolesJ) u.unmarshal(reader);
                    l = rolesJ.getRolesJ();
                    RolesCRUD rC = new RolesCRUD();
                    for (Object obj : l)
                        rC.create((Role) obj);
                    break;
                case "AdsJ":
                    AdsJ adsJ = (AdsJ) u.unmarshal(reader);
                    l = adsJ.getAdsJ();
                    AdsCRUD aC = new AdsCRUD();
                    for (Object obj : l)
                        aC.create((Ad) obj);
                    break;
            }

        } catch (FileNotFoundException | JAXBException | SQLException e) {
            e.printStackTrace();
        }

    }
}

