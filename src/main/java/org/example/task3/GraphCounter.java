package org.example.task3;

import org.example.Processor;
import org.example.utils.InOutUtil;
import org.example.validators.GraphValidator;

import java.util.*;
import java.util.stream.Collectors;


public class GraphCounter implements Processor {
    private static ResourceBundle constants = ResourceBundle.getBundle("textConstants");
    private List<String> input;

    public GraphCounter() {
        String tmp = InOutUtil.input(constants.getString("graphCounterInputNum"), input -> {
            if (Objects.nonNull(input) && input.matches("\\d+")) {
                return true;
            } else {
                System.out.println("You should enter positive integer. For example 3. Try again.");
                return false;
            }
        });
        int i = Integer.parseInt(tmp);
        input = new ArrayList<>();
        for (int j = 0; j < i; j++) {
            String msg = String.format(constants.getString("graphCounterInput"), j + 1);
            input.add(InOutUtil.input(msg, new GraphValidator()));
        }
    }

    @Override
    public void process() {
        List<HashSet<Integer>> list = convert(input);
        int i = 0;
        while (i < list.size()) {
            HashSet<Integer> tmp = list.get(i);
            Iterator<Integer> iterator = tmp.iterator();
            while (iterator.hasNext()) {
                Integer number = iterator.next();
                int j = i + 1;
                while (j < list.size()) {
                    if (list.get(j).contains(number)) {
                        tmp.addAll(list.get(j));
                        list.remove(j);
                        iterator = tmp.iterator();
                        continue;
                    }
                    j++;
                }
            }
            i++;
        }
        System.out.println(list.size());
    }

    private List<HashSet<Integer>> convert(List<String> input) {
        List<HashSet<Integer>> list = input.stream().map((p) -> {
            String[] array = p.trim().split(" ");
            if (Integer.valueOf(array[0]) != Integer.valueOf(array[1])) {
                return new HashSet<>(Set.of(Integer.valueOf(array[0]), Integer.valueOf(array[1])));
            }
            return null;
        }).filter(Objects::nonNull).collect(Collectors.toCollection(ArrayList::new));
        return list;
    }
}
