package ru.job4j.tracker;

public class ValidateInput implements Input {
    private final Output out;
    private final Input in;

    public ValidateInput(Output out, Input input) {
        this.out = out;
        this.in = input;
    }

    @Override
    public String askStr(String question) {
        return null;
    }

    private boolean isNumber(String value) {
        boolean rsl = true;
        char[] check = value.toCharArray();
        for (char num : check) {
            if (num < 48 || num > 57) {
                rsl = false;
                break;
            }
        }
        return rsl;
    }

    @Override
    public int askInt(String question) {
        boolean invalid = true;
        int value = -1;
        do {
            String rsl = in.askStr(question);
            if (!isNumber(rsl)) {
                System.out.println("Please enter validate data again.");
                continue;
            }
                try {
                    value = in.askInt(question);
                    invalid = false;
                } catch (NumberFormatException nfe) {
                    out.println("Please enter validate data again.");
                }
            }
            while (invalid);
            return value;
        }
    }