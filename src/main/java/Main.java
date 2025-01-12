import java.util.Scanner;
import java.util.SimpleTimeZone;

public class Main {
    public static void main(String[] args) {
        String logotype = """
                    ________                       \s
                    ___  __ \\_____ ___________     \s
                    __  /_/ /  __ `/  ___/  _ \\    \s
                    _  _, _// /_/ // /__ /  __/    \s
                    /_/ |_| \\__,_/ \\___/ \\___/   \s
                """;
        System.out.println(logotype);
        System.out.println("[+]===================[- Race -]======================[+]");
        System.out.println("[~] Добро пожаловать в гонки!");
        System.out.println("[>] Вам нужно ввести названия 3-х автомобилей и их скорость");
        System.out.println("[>] Допустимая скорость от 1 до 250 км/ч");
        System.out.println("[~] После мы произведем магию вычисления и определим победителя. Удачи!");
        System.out.println("[+]===================[- Race -]======================[+]");

        Scanner scanner = new Scanner(System.in);
        Race race = new Race();

        for (int i = 0; i < 3; i++) {
            System.out.print("Введите название автомобиля №" + (i + 1) + ": ");
            String nameCar = scanner.next();

            int speed = -1;
            while (speed < 0 || speed > 250) {
                System.out.print("Теперь его скорость: ");
                speed = scanner.nextInt();

                if (speed < 0 || speed > 250) {
                    System.out.println("[-]: Скорость должна быть от 1 до 250");
                }
            }

            Car car = new Car(nameCar, speed);
            race.whoLeader(car);
        }

        System.out.println("Победитель гонки: " + race.getThatLeader());
        scanner.close();
    }
}

class Car {
    String nameCar;
    int speed;

    Car(String nameCar, int speed){
        this.nameCar = nameCar;
        this.speed = speed;
    }

    public String getNameCar(){
        return nameCar;
    }

    public int getSpeed() {
        return speed;
    }
}

class Race {
    String leader = "";
    int distansLeader = 0;

    public void whoLeader(Car Car) {
        int distant = 24 * Car.getSpeed();

        if (distant > distansLeader){
            leader = Car.getNameCar();
            distansLeader = distant;
        }
    }

    public String getThatLeader() {
        return leader;
    }
}