import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class CHUAN_HOA_VA_SAP_XEP {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("DANHSACH.in"));
        List<String> hoTen = new ArrayList<>();
        while (sc.hasNextLine()) {
            hoTen.add(sc.nextLine());
        }

        for (int i = 0; i < hoTen.size(); i++) {
            String hoTenChuanHoa[] = hoTen.get(i).trim().toLowerCase().split("\\s+");
            for (int j = 0; j < hoTenChuanHoa.length; j++) {
                hoTenChuanHoa[j] = hoTenChuanHoa[j].substring(0, 1).toUpperCase() + hoTenChuanHoa[j].substring(1);
            }
            hoTen.set(i, String.join(" ", hoTenChuanHoa));
        }

        hoTen.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String ten1 = o1.substring(o1.lastIndexOf(" ") + 1);
                String ten2 = o2.substring(o2.lastIndexOf(" ") + 1);
                String ho1 = o1.substring(0, o1.lastIndexOf(" "));
                String ho2 = o2.substring(0, o2.lastIndexOf(" "));
                if (ten1.compareTo(ten2) == 0) {
                    return ho1.compareTo(ho2);
                }
                return ten1.compareTo(ten2);
            }
        });

        for (String s : hoTen) {
            System.out.println(s);
        }
    }
}
