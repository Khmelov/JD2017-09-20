package by.it.shelkovich.project.java.dao;


import by.it.shelkovich.project.java.dao.entities.*;


public class DAO {
    private static DAO dao;
    public UniDAO<User> userDAO;
    public UniDAO<Post> postDAO;
    public UniDAO<Role> roleDAO;
    public UniDAO<Comment> commentDAO;
    public UniDAO<FollowLink> followLinkDAO;

    private DAO() {
    }

    public static DAO getInstance() {

        if (dao == null) {
            synchronized (DAO.class) {
                if (dao == null) {
                    dao = new DAO();
                    dao.userDAO = new UniDAO<User>(User.class);
                    dao.postDAO = new UniDAO<Post>(Post.class);
                    dao.roleDAO = new UniDAO<Role>(Role.class);
                    dao.commentDAO = new UniDAO<Comment>(Comment.class);
                    dao.followLinkDAO = new UniDAO<FollowLink>(FollowLink.class);
                }
            }
        }

        return dao;
    }
}
