import java.util.*;

public class Goblin extends CombatEntity implements AIControlled {
    public Goblin(String name) {
        super(name, 75, 5);
    }

    public String attack(CombatEntity target) {
        Random rand = new Random();
        int rng = rand.nextInt(2);

        if (rng == 0) {
            return target.takeHit(getBasePower(), getName());
        } else {
            target.takeHit(getBasePower() * 2, getName());
            return "SMAAAASH!!" + "\n" + getName() + " dealt " + getBasePower() * 2 + " damage to " + target.getName() + "!";
        }
    }

    public String takeTurn(CombatEntity target) {
        return attack(target);
    }
}
