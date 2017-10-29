package fbhackercup;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;

public class LazyLoading {

    private static final String FILENAME = "lazy_loading.txt";

    static List<Integer> solutions;



    public static void main(String[] args) throws IOException {

        String sCurrentLine;
        BufferedReader br = new BufferedReader(new FileReader(FILENAME));

        int nDays = Integer.parseInt(br.readLine());
        solutions = new ArrayList<Integer>();

        System.out.println("Num days: " + nDays);

        while ((sCurrentLine = br.readLine()) != null) {
            List<Integer> l = new LinkedList<>();
            int n = Integer.parseInt(sCurrentLine);
            while (n-->0) {
                int temp = Integer.parseInt(br.readLine());
                l.add(temp);
            }

            solve(l);
        }

        try{
            PrintWriter writer = new PrintWriter("out.txt", "UTF-8");
            for (int i = 0; i < solutions.size(); i++)
                writer.println("Case #" + (i+1) + ": " + solutions.get(i));
            writer.close();
        } catch (IOException e) {
            // do something
        }
        System.out.println(solutions);
    }

    public static void solve(List<Integer> l) {

        Collections.sort(l, Collections.reverseOrder());
        int trips = 0;
        System.out.println("LISTA: " + l);
        for (int i = 0, j = l.size(); i < j;) {

            int remaining = j-i;
            System.out.println("Remain:" + remaining);

            if (l.get(i)*remaining < 50)
                break;

            if (l.get(i) >= 50) {
                i++;
                trips++;
                continue;
            }

            int add = (int) Math.ceil(50.0 / (double) l.get(i));
            j -= add-1;
            i++;
            trips++;
        }
        solutions.add(trips);
    }
}
