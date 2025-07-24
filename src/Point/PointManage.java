package Point;

import java.util.Scanner;

public class PointManage {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Point point = new Point();

        point.input(scanner);
        point.display();

        scanner.close();
    }
}
