package org.example;

import org.example.task1.Sorter;
import org.example.task2.Finder;
import org.example.task3.GraphCounter;
import org.example.utils.InOutUtil;
import org.example.validators.TaskValidator;

import java.util.*;

public class Main {

    private static ResourceBundle constants = ResourceBundle.getBundle("textConstants");
    private static Random random = new Random();

    public static void main(String... args) {
        String taskNumber = InOutUtil.input(constants.getString("taskSelection"), new TaskValidator());
        Processor processor = getTask(taskNumber);
        processor.process();
    }

    private static Processor getTask(String taskNumber) {
        switch (taskNumber) {
            case "1":
                return new Sorter();
            case "2":
                return new Finder();
            case "3":
                return new GraphCounter();
            default:
                return null;
        }
    }


    private static String getInput(int i) {
        StringBuilder builder = new StringBuilder();

        while (i > 0) {
            builder.append(random.nextInt(0, 25)).append(" ");
            i--;
        }
        return builder.toString();
    }


}
