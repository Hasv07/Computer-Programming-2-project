
public enum Type {
    Idle("Idle"),
    walk("walk"),
    dead("dead"),
    Run("Run");
    String Name;

    Type(String name) {
        Name = name;
    }

    public String getName() {
        return Name;
    }
}
