package com.example.module_dev18_home_work.exceptions;

public class UserNotFoundException extends Exception{
    private static final String USER_NOT_FOUND_EXCEPTION_TEXT = "User with username = %s not found.";
    private static final String USER_WITH_ID_NOT_FOUND_EXCEPTION_TEXT = "User with id = %s not found.";

    public UserNotFoundException(String username) {
        super(String.format(USER_NOT_FOUND_EXCEPTION_TEXT, username));
    }

    public UserNotFoundException(Long id) {
        super(String.format(USER_WITH_ID_NOT_FOUND_EXCEPTION_TEXT, id));
    }
}
