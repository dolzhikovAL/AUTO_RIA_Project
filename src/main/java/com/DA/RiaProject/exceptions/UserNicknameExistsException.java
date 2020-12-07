package com.DA.RiaProject.exceptions;

public class UserNicknameExistsException extends RuntimeException {

    public UserNicknameExistsException(String message) {
        super(message);
    }

}