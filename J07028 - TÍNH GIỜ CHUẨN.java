import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class tinhgiochuan {

    void solve(int numTest) throws FileNotFoundException {
        Scanner cin = new Scanner(new File("GIANGVIEN.in"));
        int n = Integer.parseInt(cin.nextLine());
        Map<String, String> map = new LinkedHashMap<>();
        for (int i = 0; i < n; i++) {
            String[] parts = cin.nextLine().split("\\s+");
            String name = "";
            for (int j = 1; j < parts.length; j++) {
                name += parts[j] + " ";
            }
            map.put(parts[0], name.trim());
        }
        cin.close();

        Map<String, Float> map2 = new HashMap<>();
        cin = new Scanner(new File("GIOCHUAN.in"));
        int m = Integer.parseInt(cin.nextLine());
        for (int i = 0; i < m; i++) {
            String[] parts = cin.nextLine().split("\\s+");
            float value = Float.parseFloat(parts[2]);
            if (map2.containsKey(parts[0])) {
                value += map2.get(parts[0]);
            }
            map2.put(parts[0], value);
        }
        cin.close();

        for (Map.Entry<String, String> entry : map.entrySet()) {
            String key = entry.getKey();
            if (map2.containsKey(key)) {
                System.out.printf("%s %.2f\n", map.get(key), map2.get(key));
            }
        }
    }

    void Run() throws FileNotFoundException {
        int t = 1;
        // t = Integer.parseInt(cin.nextLine());
        for (int i = 1; i <= t; i++) {
            solve(i);
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        new tinhgiochuan().Run();
    }
}
