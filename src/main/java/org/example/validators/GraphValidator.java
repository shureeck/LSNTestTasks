package org.example.validators;

public class GraphValidator implements Validator {
    @Override
    public boolean validate(String input) {
        if (input.matches("\\d+ \\d+")) {
            String[] tmp = input.split(" ");
            if (tmp[0].trim().equals(tmp[1].trim())) {
                System.out.println("Inputted numbers should be different. Try again.");
                return false;
            } else {
                return true;
            }
        } else {
            System.out.println("Input should be pair of positive integer numbers separated by space. For example \"12 4\". " +
                    "Try again. ");
            return false;
        }
    }
}
