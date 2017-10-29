package fbhackercup;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by Eduardo Pinto on 09/01/2017.
 */
public class ProgressPie {

    public static void main(String args[]) throws IOException {

        String fileName = "progress_pie_example_input.txt";
        Stream<String> lines = Files.lines(Paths.get(fileName));
        List<List<Integer>> values = lines
                .skip(1)
                .map(line -> ProgressPie.toInt(line.split(" ")))
                .collect(Collectors.toList());

        List<String> out = new LinkedList<>();
        for (int i = 0; i < values.size(); i++) {
            double alpha = Math.toRadians(values.get(i).get(0) / 100.0 * 360);
            int x = values.get(i).get(1), y = values.get(i).get(2);

            if (distanceBetweenTwoPoints(50,50, x, y) > 50)
                out.add("Case #" + i + ": white");

            double cat = Math.sin(alpha) * 50;
            System.out.println("Degree: " + alpha + " cat " + cat);
        }
        System.out.println(values);
    }

    public static List<Integer> toInt(String[] s) {
        List<Integer> l = new ArrayList<>();
        for (String s1 : s)
            l.add(Integer.parseInt(s1));
        return l;
    }

    public static Double distanceBetweenTwoPoints (int x1, int y1, int x2, int y2) {
        return Math.sqrt(Math.pow(x2-x1, 2) + Math.pow(y2-y1, 2));
    }
}
