import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.Comparator;
import java.util.Objects;
import java.util.Scanner;
import java.util.Vector;

public class LichGiangDayTheoMonHoc {
    public static void main(String[] args) throws FileNotFoundException, ParseException {
        Scanner sc1 = new Scanner(new File("MONHOC.in"));
        Scanner sc2 = new Scanner(new File("LICHGD.in"));
        Vector<HocPhan> hocPhans = new Vector<>();

        int n = sc2.nextInt();
        sc2.nextLine();

        while (n-- > 0) {
            String id = sc2.nextLine();
            int day = Integer.parseInt(sc2.nextLine());
            int kipHoc = Integer.parseInt(sc2.nextLine());
            String teacherName = sc2.nextLine();
            String roomId = sc2.nextLine();

            hocPhans.add(new HocPhan(id, day, kipHoc, teacherName, roomId));
        }

        hocPhans.sort(new Comparator<HocPhan>() {
            @Override
            public int compare(HocPhan o1, HocPhan o2) {
                if (o1.day == o2.day) {
                    if (o1.kipHoc == o2.kipHoc) {
                        return o1.teacherName.compareTo(o2.teacherName);
                    } else {
                        return o1.kipHoc - o2.kipHoc;
                    }
                } else {
                    return o1.day - o2.day;
                }
            }
        });
        String monCanListRa = sc2.nextLine();
        String tenMonCanListRa = "";

        n = Integer.parseInt(sc1.nextLine());
        while (n-- > 0) {
            String maMon = sc1.nextLine();
            String tenMon = sc1.nextLine();
            int soTin = Integer.parseInt(sc1.nextLine());

            if (Objects.equals(maMon, monCanListRa)) {
                tenMonCanListRa = tenMon;
                break;
            }
        }

        System.out.println("LICH GIANG DAY MON" + " " + tenMonCanListRa + ":");

        hocPhans.forEach((item) -> {
            if (Objects.equals(item.subjectId, monCanListRa)) {
                System.out.println(item.toString());
            }
        });
    }
}

class Subject {
    String id;
    String name;
    int num = 0;
}

class HocPhan {
    static int idNum = 0;
    String id;
    String subjectId;
    int day = 0;
    int kipHoc = 0;
    String teacherName = "";
    String roomId = "";

    HocPhan(String subjectId, int day, int kipHoc, String teacherName, String roomId) {
        idNum++;
        if (idNum < 10)
            id = "HP00" + idNum;
        else if (idNum < 100)
            id = "HP0" + idNum;
        else
            id = "HP" + idNum;

        this.subjectId = subjectId;
        this.day = day;
        this.kipHoc = kipHoc;
        this.teacherName = teacherName;
        this.roomId = roomId;
    }

    @Override
    public String toString() {
        return id + " " + day + " " + kipHoc + " " + teacherName + " " + roomId;
    }
}