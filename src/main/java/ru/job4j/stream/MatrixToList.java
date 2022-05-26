package ru.job4j.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MatrixToList {
    public static List<Integer> convert(Integer[][] matrix) {
        /*
          .flatMap(x -> Arrays.stream(x)) == .flatMap(Arrays::stream)
          Arrays.stream(matrix) == Stream.of(matrix)
         */
        return Stream.of(matrix)
                .flatMap(Arrays::stream)
                .collect(Collectors.toList());
    }
}
