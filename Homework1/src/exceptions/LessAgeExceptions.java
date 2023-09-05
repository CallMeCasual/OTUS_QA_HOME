package exceptions;

public class LessAgeExceptions extends  Exception{

    public LessAgeExceptions(int age){
        super(String.format("Возраст животного не может быть отрицательным или больше 25"));
    }
}
