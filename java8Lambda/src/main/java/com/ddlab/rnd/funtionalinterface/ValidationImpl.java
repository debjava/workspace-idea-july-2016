package com.ddlab.rnd.funtionalinterface;

public class ValidationImpl {

    public static void check(String s, Validator validator) {
        System.out.println("Validity : " + validator.isValid(s));
    }

    public static void main(String[] args) {
        Validator validator = (s) -> {
            if (s == null)
                return false;
            else
                return true;
        };

        String s = null;
        check(s, validator);
        s = "abcd";
        check(s,validator);
    }
}
