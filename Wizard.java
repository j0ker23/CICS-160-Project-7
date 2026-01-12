import java.util.*;

public class Wizard extends CombatEntity implements PlayerControlled {
    protected int mana = 10;

    public Wizard(String name) {
        super(name, 100, 15);
    }

    public String attack(CombatEntity target) {
        return target.takeHit(getBasePower(), getName());
    }

    public String fireball(CombatEntity target) {
        int damage = (int) (getBasePower()  * 1.2);
        target.takeHit(damage, getName());
        mana -= 2;
        return getName() + " cast a fireball on " + target.getName() + " and dealt " + damage + "!";
    }

    public String chooseAction(Scanner user, CombatEntity target) {
        System.out.println("0. Retreat 1. Simple Attack 2. Heal (Spell) 3. Undo (Spell) 4. Fireball (Mana: " + mana + ")");
        int input = -1;
        while (true) {
            if (user.hasNextInt()) {
                input = user.nextInt();
                if (input >= 0 && input <= 4) {
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
        } else if (input == 3) {
            return "UNDO";
        } else {
            return fireball(target);
        }
    }
}


