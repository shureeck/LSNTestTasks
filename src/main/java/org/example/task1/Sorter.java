package org.example.task1;

import org.example.Processor;
import org.example.utils.InOutUtil;
import org.example.validators.SorterValidator;

import java.util.*;
import java.util.stream.Collectors;

public class Sorter implements Processor {
    private static ResourceBundle constants = ResourceBundle.getBundle("textConstants");
    private final String input;

    public Sorter() {
        this.input = InOutUtil.input(constants.getString("sorterInput"), new SorterValidator());
    }

    @Override
    public void process() {
        String[] numbersArray = input.trim().split(" ");
        SortedSet<Integer> numbers = Arrays.stream(numbersArray)
                .map(Integer::valueOf)
                .collect(Collectors.toCollection(TreeSet::new));
        System.out.println(numbers.stream().map(String::valueOf).collect(Collectors.joining(" ")));
        System.out.println("count: " + numbersArray.length);
        System.out.println("distinct: " + numbers.size());
        System.out.println("min: " + numbers.first());
        System.out.println("max: " + numbers.last());
    }
}
