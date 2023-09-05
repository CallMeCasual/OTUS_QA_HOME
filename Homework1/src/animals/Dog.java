package animals;

import animals.Animal;
import exceptions.*;


public class Dog extends Animal {


    public Dog (String name, int age, double weight, String colour) throws LessAgeExceptions, LessWeightException {
        super(name, age, weight, colour);
    }
    @Override public void say (){
        System.out.println("Гав");
    }

}