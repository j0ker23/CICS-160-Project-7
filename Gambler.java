import java.util.*;

public class Gambler extends CombatEntity implements PlayerControlled {

    public Gambler(String name) {
        super(name, 90, 20);
    }

    public String attack(CombatEntity target) {
        Random rand = new Random();
        int damage = rand.nextInt(getBasePower()) + 1;

        if (damage == 1) {
            takeHit(5, getName());
            return getName() + " slipped and took 5 damage...";
        } else if (damage == 20) {
            target.takeHit(damage, getName());
            return "SMAAAASH!!" + "\n" + getName() + "dealt " + damage + "damage!";
        } else {
            return target.takeHit(damage, getName());
        }
    }

    @Override
    public String takeHit(int damage, String source) {
        Random rand = new Random();
        int damageBlocked = rand.nextInt(5) + 1;
        int damageTook = damage - damageBlocked;
        curHealth -= damageTook;
        return name + " takes a hit for " + damageTook + " damage from " + source + ", by blocking " + damageBlocked + " damage!";
    }

    public String chooseAction(Scanner user, CombatEntity target) {
        System.out.println("0. Retreat 1. Simple Attack 2. Heal (Spell) 3. Undo (Spell)");
        int input = -1;
        while (true) {
            if (user.hasNextInt()) {
                input = user.nextInt();
                if (input >= 0 && input <= 3) {
                    break;
                } 
        } else {
            user.next();
            }
            
            System.out.println("Invalid input, please try again!");

        }
        
        if (input == 0) {
            return "RETREAT";
        } else if (input == 1) {
            return attack(target);
        } else if (input == 2) {
            return recover(20, "spell");
        } else {
            return "UNDO";
        }
    }
}


