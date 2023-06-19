package org.example.validators;

import java.util.Objects;

public class SorterValidator implements Validator {
    @Override
    public boolean validate(String input) {
        if (Objects.nonNull(input) && input.matches("^(-?\\d+[ ]?)+")) {
            return true;
        } else {
            System.out.println("Line should be list of integers. For example: 1 10 -20 20 2 5. Try again.");
            return false;
        }
    }
}
