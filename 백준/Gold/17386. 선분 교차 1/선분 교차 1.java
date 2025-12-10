import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        long x1  = sc.nextLong();
        long y1 = sc.nextLong();
        long x2 = sc.nextLong();
        long y2 = sc.nextLong();

        Line line1 = new Line(x1, y1, x2, y2);

        x1 = sc.nextLong();
        y1 = sc.nextLong();
        x2 = sc.nextLong();
        y2 = sc.nextLong();

        Line line2 = new Line(x1, y1, x2, y2);

        long ans1 = line1.cross(line2);
        long ans2 = line2.cross(line1);

        if (ans1 <= 0 && ans2 <= 0) {
            System.out.println("1");
        } else {
            System.out.println("0");
        }
    }

    static class Line {
        long x1, y1, x2, y2;

        Line(long x1, long y1, long x2, long y2) {
            this.x1 = x1;
            this.y1 = y1;
            this.x2 = x2;
            this.y2 = y2;
        }

        long cross(Line l) {
            long xx1 = x2 - x1;
            long yy1 = y2 - y1;

            long xx2 = l.x1 - x1;
            long yy2 = l.y1 - y1;

            long ans1 = xx1 * yy2 - xx2 * yy1;

            xx2 = l.x2 - x1;
            yy2 = l.y2 - y1;

            long ans2 = xx1 * yy2 - xx2 * yy1;

            if (ans1 == 0 || ans2 == 0) return 0;
            if ((ans1 > 0 && ans2 < 0) || (ans1 < 0 && ans2 > 0)) return -1;
            return 1;
        }
    }
}
