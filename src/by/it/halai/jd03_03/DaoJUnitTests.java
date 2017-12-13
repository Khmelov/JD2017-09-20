package by.it.halai.jd03_03;

import by.it.halai.jd03_03.beans.*;
import by.it.halai.jd03_03.dao.DAO;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DaoJUnitTests {

    private DAO dao = DAO.getInstance();

    @BeforeClass
    public static void db() {
        DbInit.main(null);
    }

    @Test
    public void testRoles() throws Exception {

        Role role = new Role(0, "tester");
        dao.role.create(role);
        Role res = dao.role.read(role);
        assertEquals(role, res);

        role.setRole("tester2");
        dao.role.update(role);
        res = dao.role.read(role);
        assertEquals(role, res);

        assertEquals(true, dao.role.delete(res));
    }


    @Test
    public void testUsers() throws Exception {

        User user = new User(0, "Login", "pass", "email", 2);
        dao.user.create(user);
        User res = dao.user.read(user);
        assertEquals(user, res);

        user.setLogin("loginUpdate");
        dao.user.update(user);
        res = dao.user.read(user);
        assertEquals(user, res);

        assertEquals(true, dao.user.delete(res));
    }

    @Test
    public void testAds() throws Exception {

        Ad ad = new Ad(0, "Земля Маниту", "Deadlands", 1000, 25, "Wired Wild West", 2);
        dao.ad.create(ad);
        Ad res = dao.ad.read(ad);
        assertEquals(ad, res);

        ad.setName("Bison lands");
        dao.ad.update(ad);
        res = dao.ad.read(ad);
        assertEquals(ad, res);

        assertEquals(true, dao.ad.delete(res));
    }


    @AfterClass
    public static void dbDel() {
        DbReset.main(null);
    }


}
