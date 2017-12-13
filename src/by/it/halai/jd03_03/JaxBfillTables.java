package by.it.halai.jd03_03;

import by.it.halai.jd03_03.beans.*;
import by.it.halai.jd03_03.dao.DAO;
import by.it.halai.jd03_03.jaxbbeans.*;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.SQLException;
import java.util.List;


class JaxBfillTables {

    static void addTableData() {
        addData("src/by/it/halai/jd03_03/xml/Roles.xml", RolesJ.class);
        addData("src/by/it/halai/jd03_03/xml/Users.xml", UsersJ.class);
        addData("src/by/it/halai/jd03_03/xml/Ads.xml", AdsJ.class);
    }

    private static void addData(String path, Class cls) {
        try {
            JAXBContext jc = JAXBContext.newInstance(cls);
            Unmarshaller u = jc.createUnmarshaller();
            FileReader reader = new FileReader(path);
            DAO dao = DAO.getInstance();
            List<?> l;
            switch (cls.getSimpleName()) {
                case "UsersJ":
                    UsersJ usersJ = (UsersJ) u.unmarshal(reader);
                    l = usersJ.getUsersJ();
                    for (Object obj : l)
                        dao.user.create((User) obj);
                    break;
                case "AdsJ":
                    AdsJ adsJ = (AdsJ) u.unmarshal(reader);
                    l = adsJ.getAdsJ();
                    for (Object obj : l)
                        dao.ad.create((Ad) obj);
                    break;
                case "RolesJ":
                    RolesJ rolesJ = (RolesJ) u.unmarshal(reader);
                    l = rolesJ.getRolesJ();
                    for (Object obj : l)
                        dao.role.create((Role) obj);
                    break;
            }

        } catch (FileNotFoundException | JAXBException | SQLException e) {
            e.printStackTrace();
        }

    }
}

