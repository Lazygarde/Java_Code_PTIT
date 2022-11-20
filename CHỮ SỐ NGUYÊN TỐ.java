import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class chusonguyento {

    int[] a = { 2, 3, 5, 7 };

    boolean isPrime(int n) {
        if (n < 2)
            return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0)
                return false;
        }
        return true;
    }

    List<String> evenNumbersDigitsMustContainsAllOf2357(int digitsGreaterThan4) {
        List<String> result = new ArrayList<>();
        for (int i = 1000; i < Math.pow(10, digitsGreaterThan4); i++) {
            String s = String.valueOf(i);
            if (s.contains("0") || s.contains("1") || s.contains("4") || s.contains("6") || s.contains("8")
                    || s.contains("9"))
                continue;
            boolean isOk = true;
            for (int j = 0; j < a.length; j++) {
                if (!s.contains(String.valueOf(a[j]))) {
                    isOk = false;
                    break;
                }
            }
            if (isOk)
                result.add(s);  
        }
        return result;
    }

    void solve(int numTest) {
        int n = cin.nextInt();
        for (int i = 4; i <= n; i++) {
            List<String> list = evenNumbersDigitsMustContainsAllOf2357(i);
            for (int j = 0; j < list.size(); j++) {
                System.out.println(list.get(j));
            }
        }
    }

    Scanner cin = new Scanner(System.in);

    void Run() {
        int t = 1;
        // t = Integer.parseInt(cin.nextLine());
        for (int i = 1; i <= t; i++) {
            solve(i);
        }
    }

    public static void main(String[] args) {
        new chusonguyento().Run();
    }
}
