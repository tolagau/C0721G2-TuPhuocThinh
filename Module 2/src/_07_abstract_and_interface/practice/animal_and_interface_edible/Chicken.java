package _07_abstract_and_interface.practice.animal_and_interface_edible;

public class Chicken  extends Animal implements IEdible{
    @Override
    public String makeSound() {
        return "Chicken said: Quạt quạt";
    }

    @Override
    public String howToEat() {
        return "Chicken eat rice";
    }
}
