package by.it.halai.project.java.controller;


import by.it.halai.project.java.dao.DbInit;

import javax.servlet.http.HttpServletRequest;

class CmdResetDB extends AbstractAction {
    @Override
    public ICommand execute(HttpServletRequest req) {
        if (FormValidator.isPost(req)) {
            DbInit.main(null);
            req.getSession().invalidate();
            return Actions.SIGNUP.command;
        }
        return null;
    }
}
