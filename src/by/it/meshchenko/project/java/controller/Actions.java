package by.it.meshchenko.project.java.controller;

import by.it.meshchenko.project.java.controller.Admin.*;
import by.it.meshchenko.project.java.controller.Manager.*;

public enum Actions {

    SIGNIN {
        {
            this.command = new CmdSignIn();
        }
    },
    REGISTER {
        {
            this.command = new CmdRegister();
        }
    },
    INDEX {
        {
            this.command = new CmdIndex();
        }
    },
    LEASE {
        {
            this.command = new CmdLease();
        }
    },
    SIGNOUT {
        {
            this.command = new CmdSignOut();
        }
    },
    RESETDB {
        {
            this.command = new CmdResetDB();
        }
    },
    SHOPPINGCENTER {
        {
            this.command = new CmdShoppingCenter();
        }
    },
    ADMINPAGE {
        {
            this.command = new CmdAdminPage();
        }
    },
    MANAGERPAGE {
        {
            this.command = new CmdManagerPage();
        }
    },
    ADMROOMS {
        {
            this.command = new CmdAdmRooms();
        }
    },
    ADMSHOPPINGCENTERS {
        {
            this.command = new CmdAdmShoppingCenters();
        }
    },
    ADMADDRESSES {
        {
            this.command = new CmdAdmAddresses();
        }
    },
    ADMCITIES {
        {
            this.command = new CmdAdmCities();
        }
    },
    ADMCOUNTRIES {
        {
            this.command = new CmdAdmCountries();
        }
    },
    ADMSTREETS {
        {
            this.command = new CmdAdmStreets();
        }
    },
    ADMUSERS {
        {
            this.command = new CmdAdmUsers();
        }
    },
    MANAGROOMS {
        {
            this.command = new CmdManagRooms();
        }
    };

    public ICommand command;
}
