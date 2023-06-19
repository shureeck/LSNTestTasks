package org.example.utils;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.example.validators.Validator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;

@NoArgsConstructor(access = AccessLevel.PUBLIC)
public class InOutUtil {
    private static final String UNVISIBLE_u202A = "\u202A";

    public static String input(String message, Validator validator) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(message);
        try {
            String inputString;
            do {
                inputString = reader.readLine();
                if (Objects.nonNull(inputString)) {
                    inputString = inputString.trim().replaceAll(UNVISIBLE_u202A, "");
                }
            } while (Objects.nonNull(inputString) && !validator.validate(inputString));
            return inputString;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}


