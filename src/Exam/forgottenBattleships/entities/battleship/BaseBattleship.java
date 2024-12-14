package Exam.forgottenBattleships.entities.battleship;

import Exam.forgottenBattleships.common.ExceptionMessages;

public abstract class BaseBattleship implements Battleship {
    private String name;
    private int health;
    private int ammunition;
    private int hitStrength;

    public BaseBattleship(String name, int health, int ammunition, int hitStrength) {
        setName(name);
        setHealth(health);
        setAmmunition(ammunition);
        this.hitStrength = hitStrength;
    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException(ExceptionMessages.SHIP_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    private void setHealth(int health) {
        if (health < 0) {
            this.health = 0;
        } else {
            this.health = health;
        }
    }

    private void setAmmunition(int ammunition) {
        if (ammunition < 0) {
            this.ammunition = 0;
        } else {
            this.ammunition = ammunition;
        }
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getHealth() {
        return this.health;
    }

    @Override
    public int getAmmunition() {
        return this.ammunition;
    }

    @Override
    public int getHitStrength() {
        return this.hitStrength;
    }

    protected void decreaseAmmunition(int amount) {
        this.ammunition = Math.max(0, this.ammunition - amount);
    }

    @Override
    public void attack(Battleship battleship) {
        if (this.ammunition > 0) {
            decreaseAmmunition(getAmmunitionDecrement());
            battleship.takeDamage(this);
        }
    }

    @Override
    public void takeDamage(Battleship battleship) {
        this.health = Math.max(0, this.health - battleship.getHitStrength());
    }

    protected abstract int getAmmunitionDecrement();
}

