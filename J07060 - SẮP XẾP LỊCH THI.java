import java.io.*;
import java.util.*;
import java.text.*;

public class sapxeplichthi {

    static class MT {
        String code, name, method;

        public MT(String code, String name, String method) {
            this.code = code;
            this.name = name;
            this.method = method;
        }
    }

    static class CA {
        String code, date, time, room;

        public CA(int i, String date, String time, String room) {
            this.code = String.format("C%03d", i);
            this.date = date;
            this.time = time;
            this.room = room;
        }
    }

    static class L {
        MT mt;
        CA ca;
        String code;
        int sv;
        Date date;

        public L(MT mt, CA ca, String code, int sv) {
            this.mt = mt;
            this.ca = ca;
            this.code = code;
            this.sv = sv;
            SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy hh:mm");
            try {
                this.date = f.parse(ca.date + " " + ca.time);
            } catch (ParseException e) {

            }
        }

        @Override
        public String toString() {
            return ca.date + " " + ca.time + " " + ca.room + " " + mt.name + " " + code + " " + sv;
        }
    }

    public static void main(String[] args) throws IOException {
        Scanner sc1 = new Scanner(new File("MONTHI.in"));
        Scanner sc2 = new Scanner(new File("CATHI.in"));
        Scanner sc3 = new Scanner(new File("LICHTHI.in"));
        HashMap<String, MT> hmt = new HashMap<>();
        HashMap<String, CA> hca = new HashMap<>();
        int n = sc1.nextInt();
        sc1.nextLine();
        for (int i = 0; i < n; i++) {
            MT x = new MT(sc1.nextLine(), sc1.nextLine(), sc1.nextLine());
            hmt.put(x.code, x);
        }
        int m = sc2.nextInt();
        sc2.nextLine();
        for (int i = 0; i < m; i++) {
            CA x = new CA(i + 1, sc2.nextLine(), sc2.nextLine(), sc2.nextLine());
            hca.put(x.code, x);
        }
        int k = sc3.nextInt();
        ArrayList<L> a = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            String ccode = sc3.next();
            String mcode = sc3.next();
            a.add(new L(hmt.get(mcode), hca.get(ccode), sc3.next(), sc3.nextInt()));
        }
        a.sort((L x, L y) -> {
            if (x.date.compareTo(y.date) == 0)
                return x.ca.code.compareTo(y.ca.code);
            return x.date.compareTo(y.date);
        });
        a.forEach(e -> System.out.println(e));
    }
}