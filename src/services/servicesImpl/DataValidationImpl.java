package services.servicesImpl;

import services.DataValidation;

public class DataValidationImpl implements DataValidation {
    @Override
    public  boolean validateUserName(String userName) {

        if (userName.length() >= 3 && Character.isUpperCase(userName.charAt(0))){
            return true;
        }
        return false;
    }

    @Override
    public boolean validatePassword(String password) {
        if (password.length() >=6 ) return  true;
        boolean hasUpper = false, hasLower = false, hasDigit = false, hasSpecial = false;
        String specialChars = "!@#$%^&*()_+=-";

        for (char ch : password.toCharArray()) {
            if (Character.isUpperCase(ch)) hasUpper = true;
            else if (Character.isLowerCase(ch)) hasLower = true;
            else if (Character.isDigit(ch)) hasDigit = true;
            else if (specialChars.contains(String.valueOf(ch))) hasSpecial = true;
        }

        return hasUpper && hasLower && hasDigit && hasSpecial;
    }
}
