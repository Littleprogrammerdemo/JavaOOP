package Polymorphism.animals;

public class Dog extends Animal {

    public Dog(String name, String favouriteFood) {
        super(name, favouriteFood);
    }

    @Override
    public String explainSelf() {
        return String.format("%sDJAAF", super.explainSelf());
    }
}