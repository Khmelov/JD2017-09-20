package by.it.govor.bigBossProject.java.controller;


abstract class AbstractAction implements ICommand {
    @Override
    public abstract ICommand execute();

    @Override
    public String getJsp() {
        return "/" + this.getClass().
                getSimpleName().
                replace("Cmd", "").
                toLowerCase() +
                ".jsp";
    }
}
