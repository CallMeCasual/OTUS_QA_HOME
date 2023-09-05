
package birds;
import animals.Animal;
import exceptions.*;;

public class Duck extends Animal {
    public Duck (String name, int age, double weight, String colour) throws LessAgeExceptions, LessWeightException {
        super(name, age, weight, colour);
    }
    @Override public void say (){
        System.out.println("Кря");
    }

}