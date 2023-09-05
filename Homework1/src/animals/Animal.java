package animals;

import exceptions.*;

public abstract class Animal {
    public String name;
    public int age;
    public double weight;
    public String colour;


    public Animal (String name, int age, double weight, String colour) throws LessWeightException, LessAgeExceptions{

        this.name = name;


        if (age > 25 || age <= 0){
            throw new LessAgeExceptions(age);
        }else {
            this.age = age;
        }

        if (weight > 100 || weight <= 0){
            throw new LessWeightException(weight);
        }
        else {
            this.weight = weight;
        }





        this.colour = colour;


    }


    /**
     *  Закомментил Get&Set т.к. не юзаются
     */
  /*  public String getName(){
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

   // public int getAge() {
     //   return age;
   // }

    public int getAgeLess () throws LessAgeExceptions {
        if (age > 25){
            throw new LessAgeExceptions(age);
        }
        return age;
    }

    public double getLessWeight () throws LessWeightException{
        if (weight <= 0){
            throw new LessWeightException(weight);
        }
        return weight;
    }

    public void setAge(int age) {
        this.age = age;
    }

   // public double getWeight() {
    //    return weight;
    //}

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }*/

    public void say (){
        System.out.println("Я говорю");
    }

    public void go (){
        System.out.println("Я иду");
    }

    public void drink (){
        System.out.println("Я пью");
    }

    public void eat (){
        System.out.println("Я ем");
    }

    private String year(int age) {
        String years = "";


        int ages = this.age % 10;

        if (this.age >= 11 && this.age <= 19) {
            years = "лет";
        }

        if (age == 1) {
            years = "год";
        } else if (age > 5) {
            years = "лет";
        } else {
            years = "года";
        }
        return years;
    }

    public String toString (String name, int age, double weight, String colour){
        return String.format("Привет! меня зовут %s, мне %d %s. Я вешу - %.2f кг, мой цвет - %s", name, age, year(age), weight, colour);
    }

}

