package Exam.forgottenBattleships.entities.battleship;

public class RoyalBattleship extends BaseBattleship {
    private static final int INITIAL_AMMUNITION = 100;
    private static final int HIT_STRENGTH = 25;

    public RoyalBattleship(String name, int health) {
        super(name, health, INITIAL_AMMUNITION, HIT_STRENGTH);
    }

    @Override
    protected int getAmmunitionDecrement() {
        return 25;
    }
}
