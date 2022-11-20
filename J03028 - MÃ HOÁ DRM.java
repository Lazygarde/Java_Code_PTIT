import java.util.Scanner;

public class mahoadrm {

    class Pair<K, V> {
        K key;
        V value;

        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    String drmLizeThenMerge(String source) {
        int length = source.length();
        int half = length / 2;
        int sum1 = 0;
        int sum2 = 0;
        for (int i = 0; i < half; i++) {
            sum1 += source.charAt(i) - 'A';
            sum2 += source.charAt(i + half) - 'A';
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < half; i++) {
            int c1 = source.charAt(i) - 'A';
            int c2 = source.charAt(i + half) - 'A';
            int c = (c1 + sum1) % 26;
            c = (c + c2 + sum2) % 26;
            sb.append((char) (c + 'A'));
        }
        return sb.toString();
    }

    void solve(int numTest) {
        String s = cin.nextLine();
        System.out.println(drmLizeThenMerge(s));
    }

    Scanner cin = new Scanner(System.in);

    void Run() {
        int t = 1;
        t = Integer.parseInt(cin.nextLine());
        for (int i = 1; i <= t; i++) {
            solve(i);
        }
    }

    public static void main(String[] args) {
        new mahoadrm().Run();
    }
}
