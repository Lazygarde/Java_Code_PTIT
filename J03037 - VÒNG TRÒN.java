
import java.util.Scanner;

public class VongTron {
    public static int[] a = new int[127], b = new int[127], check = new int[127];

    public static void main(String[] args) {
        int cnt = 0;
        char[] s = sc.nextLine().toCharArray();


        for (int i = 0; Integer.compareUnsigned(i, s.length) < 0; i++) {
            if (check[s[i]] == 0) {
                a[s[i]] = i;
                check[s[i]] = 1;
            } else {
                b[s[i]] = i;
            }
        }
        for (int i = 'A'; i <= 'Z'; i++) {
            for (int j = 'A'; j <= 'Z'; j++) {
                if (a[i] < a[j] && a[j] < b[i] && b[j] > b[i]) {
                    cnt++;
                }
            }
        }
        System.out.print(cnt);
    }

    public final static Scanner sc = new Scanner(System.in);
}