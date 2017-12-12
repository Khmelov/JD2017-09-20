package by.it.meshchenko.project.java.controller;

public interface Patterns {
    String UserNAME="[A-Za-zА-Яа-яЁё0-9_]{4,31}";
    String UserPASSWORD="[A-Za-z_0-9]{4,31}";
    String UserEMAIL="([A-Za-z_0-9]{2,31})@([A-Za-z_]{2,9})(\\.)([A-Za-z_]{1,5})";
    String UserPHONE ="\\+?[0-9]{4,15}";
    String INTEGER ="[0-9]{1,}";
    String TEXT = "[A-Za-zА-Яа-яЁё0-9\\s\\.\\-\\?!:;,]{1,}";
}
