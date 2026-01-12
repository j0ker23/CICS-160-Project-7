import java.util.*;

public class Dragon extends CombatEntity implements AIControlled {
    public Dragon(String name) {
        super(name, 150, 20);
    }

    public String attack(CombatEntity target) {
        return target.takeHit(getBasePower(), getName());
    }

    public String takeTurn(CombatEntity target) {
        Random rand = new Random();
        int value = rand.nextInt(20) + 1;
        
        if (value < 16) {
            return attack(target);
        } else if (value >= 16 && value <= 19) {
            target.takeHit(3 * getBasePower(), getName());
            return getName() + " scorched " + target.getName() + " with searing fire, dealing " 
                + 3 * getBasePower() +  " damage";
        } else {
            recover(20, "Special Attack");
            target.takeHit(3 * getBasePower(), getName());
            return getName() + " took a bite out of " + target.getName() + " dealing " + 3 * getBasePower()
                 + " damage and recovering " + 20 + " health!";
        }
    }
}
