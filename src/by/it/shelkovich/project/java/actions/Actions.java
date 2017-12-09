package by.it.shelkovich.project.java.actions;

public enum Actions {
    LOGIN{
        {
            command = new CmdLogIn();
        }
    },
    LOGOUT{
        {
            command = new CmdLogOut();
        }
    },
    REGISTER{
        {
            command = new CmdRegister();
        }
    },
    ERROR{
        {
            command = new CmdError();
        }
    },
    MANAGE{
        {
            command = new CmdManage();
        }
    },
    PUBLISH{
        {
            command = new CmdPublish();
        }
    },
    MAIN{
        {
            command = new CmdMain();
        }
    },
    PUBLICATION{
        {
            command = new CmdPublication();
        }
    },
    RESETDB{
        {
            command = new CmdResetDB();
        }
    };

    public ICommand command;
}
