import animals.*;
import animals.Comm;
import animals.CommAnimal;
import birds.Duck;
import exceptions.LessAgeExceptions;
import exceptions.LessWeightException;


import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;


// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static Scanner scanner = new Scanner(System.in);
    public static int sayAgeExcept(){
        System.out.println("Введите возраст животного:");
        int age;
        try {
            age = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Необходимо числовое значение..");
            scanner.nextLine();
            age = sayAgeExcept();
        }
        return age;
    }

    public static double sayWeightExcept(){
        System.out.println("Введите вес животного:");
        double weight;
        try {
            weight = scanner.nextDouble();
        } catch (InputMismatchException e) {
            System.out.println("Необходимо числовое значение..");
            scanner.nextLine();
            weight = sayWeightExcept();
        }
        return weight;
    }

    public static void main(String[] args) throws LessAgeExceptions, LessWeightException {


        List<Animal> animals = new ArrayList<>();



        while (true) {

            System.out.println("Введите команду: (Add, List, Exit)");

            String commInput = scanner.next().trim().toUpperCase();

            boolean isCommExist = false;
            for (Comm comm : Comm.values()) {
                if (comm.name().equals(commInput)) {
                    isCommExist = true;
                    break;
                }
            }
            if (isCommExist == false) {
                System.out.printf("Команда %s не найдена\n", commInput);
                continue;
            }

            Comm comm = Comm.valueOf(commInput);

            switch (comm) {
                case ADD: {
                    System.out.println("Введите тип животного Cat/Dog/Duck");
                    String animalCommInput = scanner.next().trim().toUpperCase();

                    boolean isCommAnimalExist = false;
                    for (CommAnimal commAnimal : CommAnimal.values()) {
                        if (commAnimal.name().equals(animalCommInput)) {
                            isCommAnimalExist = true;
                            break;
                        }
                    }
                    if (isCommAnimalExist == false) {
                        System.out.printf("Тип животного %s не найден\n", animalCommInput);
                        continue;
                    }

                    CommAnimal commAnimal = CommAnimal.valueOf(animalCommInput);

                    scanner.nextLine();
                    System.out.println("Введите имя животного:");
                    String name = scanner.nextLine().trim().toLowerCase();


                    int age = sayAgeExcept();
                    scanner.nextLine();

                    double weight = sayWeightExcept();
                    scanner.nextLine();


                    System.out.println("Введите цвет животного:");
                    String colour = scanner.nextLine().trim().toLowerCase();


                    switch (commAnimal) {
                        case CAT: {
                            animals.add(new Cat(name, age, weight, colour));
                            new Cat(name, age, weight, colour).say();
                            break;
                        }
                        case DOG: {
                            animals.add(new Dog(name, age, weight, colour));
                            new Dog(name, age, weight, colour).say();
                            break;
                        }
                        case DUCK: {
                            animals.add(new Duck(name, age, weight, colour));
                            new Duck(name, age, weight, colour).say();
                            break;
                        }
                    }


                    break;

                }


                case EXIT: {
                    System.out.println("Выхожу из программы");
                    System.exit(0);
                }
                case LIST: {
                    if (animals.size() == 0) {
                        System.out.println("Список пуст. Добавьте животное через команду add.");
                    } else {
                        for (Animal animal : animals) {
                            System.out.println(animal.toString(animal.name, animal.age, animal.weight, animal.colour));
                        }
                    }
                    break;
                }

            }

        }


    }
}
