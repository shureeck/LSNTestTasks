package org.example.validators;

import java.util.Objects;

public class TaskValidator implements Validator {
    @Override
    public boolean validate(String input) {

        if (Objects.nonNull(input) && input.matches("[123]")) {
            return true;
        } else {
            System.out.println("You should enter number of task. It could be 1, 2 or 3. Try again.");
            return false;
        }

    }
}
