package by.it.shelkovich.project.java.servlets;

public interface ValidatePatterns {
    String USERNAME = "[A-Za-z0-9.-_]{5,}";
    String PASSWORD = "[A-Za-z0-9.-_]{5,}";
    String EMAIL = "[A-Za-z0-9.-_]{5,}";
    String DESCRIPTION = "[A-Za-z0-9.-_]{5,}";
    String NAME = "[A-Za-z0-9.-_]{5,}";
    String SURNAME = "[A-Za-z0-9.-_]{5,}";
}
