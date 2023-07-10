package units.abstractUnits;

import arena.Arena;

public abstract class UnitProtective extends Unit {
    private float increasingDefence;
    private int abilityPoints;

    public UnitProtective(int health, int defense, int attack, UnitsTypes type, String name) {
        super(health, defense, attack, type, name);
        this.abilityPoints = 0;
    }

    public UnitProtective(UnitsTypes type, String name) {
        this(0, 0, 0, type, name);
    }

    public void concentration() {
        //super.skipAMove();
        if (abilityPoints < 3) {
            abilityPoints += 1;
        }
    }

    public int getAbilityPoints() {
        return abilityPoints;
    }

    public void useAbility() {
        abilityPoints = 0;
    }

    public void decreaseDamage(int increasingDefence) {
        super.decreaseAttack(increasingDefence);
    }

    public float getIncreasingDefence() {
        return increasingDefence;
    }

    @Override
    public void actionInDiapason(Arena arena, Unit targetUnit, boolean moveMade) {
        System.out.println("Защищаюший Не знаю что делать в диапазоне");
    }

    @Override
    public void actionNotInDiapason(Arena arena, Unit targetUnit, boolean moveMade) {
        System.out.println("Защищающий Не знаю что делать вне диапазона");
    }
}
