import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.Comparator;
import java.util.Scanner;
import java.util.Vector;

public class QuanLyBaiTapNhom {
    public static void main(String[] args) throws FileNotFoundException, ParseException {
        Scanner sc1 = new Scanner(new File("SINHVIEN.in"));
        Scanner sc2 = new Scanner(new File("BAITAP.in"));
        Scanner sc3 = new Scanner(new File("NHOM.in"));
        Vector<SinhVien> sinhViens = new Vector<>();

        int n = sc1.nextInt();
        sc1.nextLine();

        for (int i = 0; i < n; i++) {
            String id = sc1.nextLine();
            String name = sc1.nextLine();
            String phoneNum = sc1.nextLine();

            String[] strs = sc3.nextLine().split("\\s");
            int nhom = Integer.parseInt(strs[strs.length - 1]);

            sinhViens.add(new SinhVien(id, name, phoneNum, nhom));
        }

        n = Integer.parseInt(sc2.nextLine());
        String mon = "";
        for (int j = 1; j <= n; j++) {
            mon = sc2.nextLine();
            for (int i = 0; i < sinhViens.size(); i++) {
                if (sinhViens.get(i).nhom == j) {
                    sinhViens.get(i).baiTap = mon;
                }
            }
        }

        sinhViens.sort(new Comparator<SinhVien>() {
            @Override
            public int compare(SinhVien o1, SinhVien o2) {
                return o1.id.compareTo(o2.id);
            }
        });

        sinhViens.forEach((item)->{
            System.out.println(item.toString());
        });
    }
}

class SinhVien {
    String id = "";
    String name = "";
    String phoneNum = "";
    int nhom = 0;
    String baiTap = "";

    SinhVien(String id, String name, String phoneNum, int nhom) {
        this.id = id;
        this.name = name;
        this.phoneNum = phoneNum;
        this.nhom = nhom;
    }


    @Override
    public String toString() {
        return id + " " + name + " " + phoneNum + " " + nhom + " " + baiTap;
    }
}
