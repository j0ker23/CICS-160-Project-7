public class GameState {
    protected CombatEntity[] Beings;
    protected int[] BeingsHealth;

    public GameState(CombatEntity[] b, int[] Health) {
        Beings = b;
        BeingsHealth = Health;
    }

    public CombatEntity getCE(int index) {
        if (index > Beings.length) {
            throw new IndexOutOfBoundsException();
        }
        return Beings[index];
    }

    public int getCEHealth(int index) {
        if (index > BeingsHealth.length) {
            throw new IndexOutOfBoundsException();
        }
        return BeingsHealth[index];
    }

    public void restore() {
        for (int i = 0; i < Beings.length; i++) {
            Beings[i].curHealth = BeingsHealth[i];
        }
    }
}
