package animals;
import exceptions.*;
import animals.Animal;

public class Cat extends Animal {

    public Cat (String name, int age, double weight, String colour) throws LessAgeExceptions, LessWeightException {
        super(name, age, weight, colour);
    }
    @Override public void say (){
        System.out.println("Мяу");
    }

}
