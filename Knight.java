import java.util.Scanner;

public class Knight extends CombatEntity implements PlayerControlled {
    protected int boastCount = 3;
    protected double attackMod = 1;
    protected int boastRoundCount = 0;

    public Knight(String name) {
        super(name, 120, 10);
    }

    public String attack(CombatEntity target) {
        return target.takeHit((int) (getBasePower() * attackMod), getName());
    }

    public String boast(CombatEntity target) {
        if (boastCount > 0) {
            attackMod = 1.5;
            boastCount--;
            boastRoundCount = 3;
            return getName() + " boasts and raises his attack power!";
        } else {
            return getName() + " is exhausted...";
        }
    }

    public void checkBoastCount() {
        if (boastRoundCount > 0) {
            boastRoundCount--;
            if (boastRoundCount == 0) {
                attackMod = 1.0;
            }
        }
    }

    public void resetStats() {
        attackMod = 1.0;
        boastRoundCount = 0;
    }

    public String chooseAction(Scanner user, CombatEntity target) {
        System.out.println("0. Retreat 1. Simple Attack 2. Heal (Spell) 3. Undo (Spell) 4. Special Attack " + boastCount);
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
            return boast(target);
        }
    }
}
