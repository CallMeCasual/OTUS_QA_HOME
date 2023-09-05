package exceptions;


public class LessWeightException extends  Exception{

    public LessWeightException (double weight){
        super(String.format("Вес животного не может быть <= 0 или быть отрицательным"));
    }
}

