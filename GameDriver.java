import java.util.*;

public class GameDriver {
    private static GameState currentState;

    public static GameState getCurrentGameState() {
        return currentState;
    }

    public static void main(String[] args) {
        Scanner user = new Scanner(System.in);
        Wizard player = new Wizard("player");
        Dragon enemy = new Dragon("enemy");
        GameStack history = new GameStack();

        System.out.println("Game Start!");
        System.out.println();

        while (!player.hasLost() && !enemy.hasLost()) {
            System.out.println(player.getName() + ": Health of " + player.getCurHealth() + "/"
                + player.getMaxHealth() + " and power of " + player.getBasePower());
            System.out.println(enemy.getName() + ": Health of " + enemy.getCurHealth() + "/"
                + enemy.getMaxHealth() + " and power of " + enemy.getBasePower());

            currentState = new GameState(new CombatEntity[] {player, enemy}, new int[] {player.getCurHealth(), enemy.getCurHealth()});
            history.push(currentState);

            String action = player.chooseAction(user, enemy);
            System.out.println();
            System.out.println(action);

            if (action.equals("UNDO")) {
                history.pop();
                currentState = history.peek();
                currentState.restore();
                System.out.println(player.getName() + " casts a spell to turn back time");
                continue;
            } else if (action.equals("RETREAT")) {
                System.out.println(player.getName() + " runs away, and lives to fight another day");
                break;
            }
            if (!enemy.hasLost()) {
                String dragonAction = enemy.takeTurn(player);
                System.out.println(dragonAction);
            }

            System.out.println();
        }

        if (player.hasLost()) {
            System.out.println(player.getName() + " has been Defeated...");
        } else if (enemy.hasLost()) {
            System.out.println(player.getName() + " has acheived Victory!");
        } else {
            System.out.println(player.getName() + " has escaped!");
        }

    }
}
