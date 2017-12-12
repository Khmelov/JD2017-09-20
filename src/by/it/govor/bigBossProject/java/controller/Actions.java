package by.it.govor.bigBossProject.java.controller;


enum Actions {
    EditUSERS{
        {
        this.command = new CmdEditUsers();}
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
    LOGOUT{
        {
            this.command = new CmdLogout();
        }
    },
    ERROR{
        {
            this.command = new CmdError();
        }
    },
    EDITUSERS {
        {
            this.command = new CmdEditUsers();
        }
    },
    INDEX {
        {
            this.command = new CmdIndex();
        }
    },
    CREATEAD{
        {
            this.command = new CmdCreateAd();
        }
    };



    ICommand command;
}
