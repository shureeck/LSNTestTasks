package org.example.task2;

import org.example.Processor;
import org.example.utils.InOutUtil;
import org.example.validators.FinderValidator;
import org.example.validators.SorterValidator;

import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

public class Finder implements Processor {
    private static ResourceBundle constants = ResourceBundle.getBundle("textConstants");
    private int summ;
    private String input;

    public Finder() {
        String tmp = InOutUtil.input(constants.getString("finderInput"), new FinderValidator());
        this.summ = Integer.parseInt(tmp);
        this.input = InOutUtil.input(constants.getString("sorterInput"), new SorterValidator());
    }

    @Override
    public void process() {
        List<Integer> list = Arrays.stream(input.split(" ")).map(Integer::valueOf).sorted().toList();
        for (int i = list.size() - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                int tmpSum = list.get(i) + list.get(j);
                if (tmpSum == summ) {
                    System.out.println(list.get(j) + " " + list.get(i));
                } else if (tmpSum > summ) {
                    break;
                }
            }
        }
    }
}
