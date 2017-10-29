package codility;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by eduardopinto on 19/10/16.
 */
public class OddOccurrencesInArray {

    public int solution(int[] A) {

        Map<Integer, Integer> hist = new HashMap();

        for (int i : A) {
            if (hist.containsKey(i))
                hist.replace(i, hist.get(i)+1);
            else
                hist.put(i, 1);
        }


        for (Map.Entry<Integer, Integer> n : hist.entrySet()) {
            //System.out.println(n.getValue());
            if (n.getValue() % 2 != 0)
                return n.getKey();
            //System.out.println(entry.getKey() + "/" + entry.getValue());
        }

        return 0;
    }

    public static void main(String[] args) {
        OddOccurrencesInArray e = new OddOccurrencesInArray();
        System.out.println(e.solution(new int[]{22}));
    }
}
