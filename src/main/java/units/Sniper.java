package units;

import units.abstractUnits.UnitAttackingWithWeapons;

/**
 * Снайпер
 */
public class Sniper extends UnitAttackingWithWeapons {
    public Sniper(String name) {
        super(Equipment.bow_and_arrows.getHealth(), Equipment.bow_and_arrows.getAttack(),
                Equipment.bow_and_arrows.getDefend(), UnitsTypes.Sniper, name);
    }
}
