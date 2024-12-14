package ExamPreparation.dolphinarium.entities.dolphins;

//TODO Implement all methods


import ExamPreparation.dolphinarium.entities.foods.Food;

public interface Dolphin {
    String getName();
    int getEnergy();

    void jump();

    void eat(Food food);
}