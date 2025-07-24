package Point;

import java.util.Scanner;

public class Point {
    private double x;
    private double y;


    public void input(Scanner scanner) {
        System.out.print("Enter x: ");
        if (scanner.hasNextDouble()) {
            this.x = scanner.nextDouble();
        } else {
            System.out.println("Invalid input for x. Setting to default 0.");
            this.x = 0;
            scanner.next();
        }
        System.out.print("Enter y: ");
        if (scanner.hasNextDouble()) {
            this.y = scanner.nextDouble();
        } else {
            System.out.println("Invalid input for y. Setting to default 0.");
            this.y = 0;
            scanner.next();
        }
    }

    public double distance() {
        return Math.sqrt(x * x + y * y);
    }

    public void display() {
        System.out.printf("Point coordinates: (%.2f, %.2f)\n", x, y);
        System.out.printf("Distance from origin: %.2f\n", distance());
    }
}
