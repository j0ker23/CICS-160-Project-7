import java.util.ArrayList;

public class GameStack {
    private ArrayList<GameState> history;

    public GameStack() {
        history = new ArrayList<>();
    }

    public void push(GameState t) {
        history.add(t);
    }

    public GameState pop() {
        if (!history.isEmpty()) {
            GameState element = history.get(history.size() - 1);
            history.remove(history.size() - 1);
            return element;
        } else {
            return null;
        }
    }

    public GameState peek() {
        if (!history.isEmpty()) {
            return history.get(history.size() - 1);
        } else {
            return null;
        }
    }

    public boolean isEmpty() {
        return history.isEmpty();
    }
}
