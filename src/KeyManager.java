import javafx.scene.input.KeyCode;

public class KeyManager
{

    private boolean [] keystates;

    public KeyManager()
    {
        keystates = new boolean[4];
    }

    private int keycodeToIndx(KeyCode k)
    {
        switch(k)
        {
            case UP:
                return 0;
            case DOWN:
                return 1;
            case W:
                return 2;
            case S:
                return 3;
            default:
                return -1;
        }
    }


    public void setkeystate(KeyCode k , boolean state)
    {
        int i = keycodeToIndx(k);
        keystates[i] = state;
    }

    public boolean getkeystate(KeyCode k)
    {
        int i = keycodeToIndx(k);
        return keystates[i];
    }


}
