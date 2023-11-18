package units.abstractUnits;

import arena.Arena;

public abstract class UnitAttacking extends Unit {
    private float increasingAttack;
    private int abilityPoints;

    public UnitAttacking(int health, int defense, int attack, UnitsTypes type, String name) {
        super(health, defense, attack, type, name);
        this.abilityPoints = 0;
    }

    public UnitAttacking(UnitsTypes type, String name) {
        this(0, 0, 0, type, name);
    }

    public boolean concentration() {
//        System.out.println("Концентрируюсь");

        //super.skipAMove();
        if (abilityPoints < 2) {
            abilityPoints += 1;
            return true;
        }

        return false;
    }

    public int getAbilityPoints() {
        return abilityPoints;
    }

    public void clearPointAbility() {
        abilityPoints = 0;
    }

    @Override
    public void increaseAttack(int increasingAttack) {
        super.increaseAttack(increasingAttack);
    }

    public float getIncreasingAttack() {
        return increasingAttack;
    }

    @Override
    public void actionInDiapason(Arena arena, Unit targetUnit, boolean moveMade) {

        if (!this.applyAbility(targetUnit)) {
            // если не смогли применить спобосность
            if (this.performAnAttack(targetUnit)) {
                // если смогли атаковать

                //проверяем убили ли
                if (targetUnit.getHealth() == 0) {
                    // выносим труп
                    arena.removeTheCorpse(targetUnit);
                }

                if (!moveMade) {
                    // если шаг НЕ сделан
                    this.concentration();
                }
            } else {
                // если не смогли атаковать
                if (!moveMade) {
                    // если шаг НЕ сделан
                    this.clearPointActivites();
                }
            }
        }
    }

    @Override
    public void actionNotInDiapason(Arena arena, Unit targetUnit, boolean moveMade) {
//        if (this.getAbilityPoints() < 2) {
//            //концентрация
//            this.concentration();
//        } else if (this.getAbilityPoints() == 2) {
//            //абилити
//            if (kindOfBattle == KindOfBattle.distant) {
//                this.applyAbility(targetUnit);
//            } else if (kindOfBattle == KindOfBattle.near) {
//                if (!moveMade) {
//                    this.skipAMove();
//                }
//            }
//        }

        if (moveMade) {
            // если шаг сделан
            if (!this.concentration()) {
                // если не смогли сконцентрироваться
                this.clearPointActivites();
            }
        }
    }
}
