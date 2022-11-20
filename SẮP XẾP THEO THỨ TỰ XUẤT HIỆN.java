import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class sapxeptheothutuxuathien {

    List<Integer> sortByFrequencyKeepAllElement(List<Integer> a) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < a.size(); i++) {
            if (map.containsKey(a.get(i))) {
                map.put(a.get(i), map.get(a.get(i)) + 1);
            } else {
                map.put(a.get(i), 1);
            }
        }
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, (o1, o2) -> {
            if (o1.getValue() == o2.getValue()) {
                return a.indexOf(o1.getKey()) < a.indexOf(o2.getKey()) ? -1 : 1;
            }
            return o1.getValue() > o2.getValue() ? -1 : 1;
        });
        List<Integer> result = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : list) {
            for (int i = 0; i < entry.getValue(); i++) {
                result.add(entry.getKey());
            }
        }
        return result;
    }

    void solve(int numTest) {
        int n = in.nextInt();
        List<Integer> a = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            a.add(in.nextInt());
        }
        List<Integer> r = sortByFrequencyKeepAllElement(a);
        for (int i : r) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    Scanner in = new Scanner(System.in);

    void Run() {
        int t = 1;
        t = Integer.parseInt(in.nextLine());
        for (int i = 1; i <= t; i++) {
            solve(i);
        }
    }

    public static void main(String[] args) {
        new sapxeptheothutuxuathien().Run();
    }
}
