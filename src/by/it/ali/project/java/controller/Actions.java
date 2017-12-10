package by.it.ali.project.java.controller;


public enum Actions {
    INDEX {
        {
            this.command = new CmdIndex();
        }
    },
    LOGIN {
        {
            this.command = new CmdLogin();
        }
    },
    SIGNUP {
        {
            this.command = new CmdSignup();
        }
    },
    PROFILE{
        {
            this.command = new CmdProfile();
        }
    },
//    RESETDB{
//        {
//            this.command = new CmdResetDB();
//        }
//    },
    BUYTICKETS{
        {
            this.command = new CmdBuyTickets();
        }
    },
    ERROR{
        {
            this.command = new CmdError();
        }
    };

    ICommand command;
}
