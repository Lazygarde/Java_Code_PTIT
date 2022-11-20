import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.*;

public class DangKyHinhThucGiangDay {
    public static void main(String[] args) throws FileNotFoundException, ParseException {
        Scanner sc = new Scanner(new File("MONHOC.in"));
        Vector<Subject> subjects = new Vector<>();

        int n = sc.nextInt();
        sc.nextLine();

        while (n-- > 0) {
            String id = sc.nextLine();
            String name = sc.nextLine();
            int num = Integer.parseInt(sc.nextLine());
            String offline = sc.nextLine();
            String online = sc.nextLine();

            subjects.add(new Subject(id, name, num, offline, online));
        }

        subjects.sort(new Comparator<Subject>() {
            @Override
            public int compare(Subject o1, Subject o2) {
                return o1.id.compareTo(o2.id);
            }
        });

        subjects.forEach((item) -> {
                    if (!item.hinhThucThucHanh.equals("Truc tiep"))
                        System.out.println(item.toString());
                }
        );
    }
}

class Subject {
    String id;
    String name;
    int num = 0;
    String hinhThucLyThuyet = "";
    String hinhThucThucHanh = "";

    Subject(String id, String name, int num, String offline, String online) {
        this.id = id;
        this.name = name;
        this.num = num;
        this.hinhThucLyThuyet = offline;
        this.hinhThucThucHanh = online;
    }

    @Override
    public String toString() {
        return id + " " + name + " " + num + " " + hinhThucLyThuyet + " " + hinhThucThucHanh;
    }
}