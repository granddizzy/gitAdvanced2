package units;

import arena.Arena;
import units.abstractUnits.Equipment;
import units.abstractUnits.Unit;
import units.abstractUnits.UnitSupportiveHealer;
import units.abstractUnits.UnitsTypes;

/**
 * Друид
 */
public class Druid extends UnitSupportiveHealer {

    public Druid(String name) {
        super(Equipment.frogfoot_and_bearskin.getHealth(), Equipment.frogfoot_and_bearskin.getAttack(),
                Equipment.frogfoot_and_bearskin.getDefend(), UnitsTypes.Druid, name);
    }

    @Override
    public Unit findTarget(Arena arena) {
        // ищем ближайшего своего
        return arena.findTheNearestTeamUnit(this, false);
    }

    @Override
    public boolean applyAbility(Unit targetUnit, Arena arena) {
        return super.smallHeal(targetUnit);
    }

    @Override
    public boolean isInDiapason(Unit targetUnit) {
        return this.distanceSkill >= this.getCoordinates().calculateDistance(targetUnit.getCoordinates());
    }

    @Override
    public String getCharacterRepresentation() {
        return "Drd";
    }
}
