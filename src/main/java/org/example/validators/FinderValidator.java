package org.example.validators;

public class FinderValidator implements Validator {

    @Override
    public boolean validate(String input) {
        if (input.matches("-?\\d+")) {
            return true;
        } else {
            System.out.println("Input should be integer number. For example 13. Try again.");
            return false;
        }
    }
}
