package com.mingfeichn.thinkinginjava.annotations;

import java.util.List;

/**
 * 使用@UseCase对该类中的方法进行注解
 */
public class PasswordUtils {
    @UseCase(id = 47, description = "Password must contain at least one numeric")
    public boolean validatePassword(String password) {
        return (password.matches("\\w*\\d\\w*"));
    }

    @UseCase(id = 48)
    public String encryptPassword(String password) {
        return new StringBuilder(password).reverse().toString();
    }

    @UseCase(id = 49, description = "New password can't equal previously used ones")
    public boolean checkForNewPassword(List<String> prevPasswords, String password) {
        return !prevPasswords.contains(password);
    }
}
