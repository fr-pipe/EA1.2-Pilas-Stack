package app;

public class Action {

    public enum Type { ADD_LINE }

    private final Type type;
    private final String line;

    public Action(Type type, String line) {
        this.type = type;
        this.line = line;
    }

    public Type getType() {
        return type;
    }

    public String getLine() {
        return line;
    }
}