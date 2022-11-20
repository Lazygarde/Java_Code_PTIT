import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class danhsachkhachhangtrongfile {

    static int auto_id = 1;

    class Pair<K, V> {
        K key;
        V value;

        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    String cleanName(String source) {
        source = source.trim();
        String[] words = source.split("\\s+");
        String result = "";
        for (String word : words) {
            result += word.substring(0, 1).toUpperCase() + word.substring(1).toLowerCase() + " ";
        }
        return result.trim();
    }

    String dobToDDMMYYYY(String dob) {
        String[] parts = dob.split("/");
        String result = String.format("%02d/%02d/%04d", Integer.parseInt(parts[0]), Integer.parseInt(parts[1]),
                Integer.parseInt(parts[2]));
        return result;
    }

    String dobToYYYYMMDD(String dob) {
        String[] parts = dob.split("/");
        String result = String.format("%04d/%02d/%02d", Integer.parseInt(parts[2]), Integer.parseInt(parts[1]),
                Integer.parseInt(parts[0]));
        return result;
    }

    Pair<String, String> readCustomerInfo() {
        String id = String.format("KH%03d", auto_id++);
        String name = cin.nextLine();
        name = cleanName(name);
        String gender = cin.nextLine();
        String dob = cin.nextLine();
        dob = dobToDDMMYYYY(dob);
        String address = cin.nextLine();
        String value = id + " " + name + " " + gender + " " + address + " " + dob;
        String key = dobToYYYYMMDD(dob);
        return new Pair<>(key, value);
    }

    void solve(int numTest) {
        List<Pair<String, String>> list = new ArrayList<>();
        int n = Integer.parseInt(cin.nextLine());
        for (int i = 0; i < n; i++) {
            list.add(readCustomerInfo());
        }
        list.sort((a, b) -> a.key.compareTo(b.key));
        for (Pair<String, String> pair : list) {
            System.out.println(pair.value);
        }
    }

    Scanner cin;

    private danhsachkhachhangtrongfile() throws FileNotFoundException {
        cin = new Scanner(new File("KHACHHANG.in"));
    }

    void Run() {
        int t = 1;
        // t = Integer.parseInt(cin.nextLine());
        for (int i = 1; i <= t; i++) {
            solve(i);
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        new danhsachkhachhangtrongfile().Run();
    }
}
