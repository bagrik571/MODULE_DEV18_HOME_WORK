package com.example.module_dev18_home_work.exceptions;

public class UsernameNotFoundException extends Exception{
    private static final String USERNAME_NOT_FOUND_EXCEPTION_TEXT = "User with username = %s not found.";
    private static final String CAN_NOT_UPDATE_USER_WITHOUT_ID_EXCEPTION_TEXT = "Can not found user without id.";
    public UsernameNotFoundException(String username){
        super(String.format(CAN_NOT_UPDATE_USER_WITHOUT_ID_EXCEPTION_TEXT, username));
    }
    public UsernameNotFoundException(Long userId) {
        super(String.format(USERNAME_NOT_FOUND_EXCEPTION_TEXT, userId));
    }
}
