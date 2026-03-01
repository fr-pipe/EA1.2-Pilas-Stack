package app;

import java.util.ArrayList;
import java.util.List;

public class TextEditor {

    private final List<String> lines;
    private final MyStack<Action> undoStack;
    private final MyStack<Action> redoStack;

    public TextEditor() {
        this.lines = new ArrayList<>();
        this.undoStack = new MyStack<>();
        this.redoStack = new MyStack<>();
    }

    public void writeLine(String line) {
        lines.add(line);
        undoStack.push(new Action(Action.Type.ADD_LINE, line));
        redoStack.clear();
    }

    public String getText() {
        if (lines.isEmpty()) return "(vacío)";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < lines.size(); i++) {
            sb.append(i + 1).append(". ").append(lines.get(i)).append("\n");
        }
        return sb.toString();
    }

    public boolean undo() {
        if (undoStack.isEmpty()) return false;

        Action last = undoStack.pop();

        if (last.getType() == Action.Type.ADD_LINE) {
            if (!lines.isEmpty()) {
                lines.remove(lines.size() - 1);
            }
            redoStack.push(last);
            return true;
        }

        return false;
    }

    public boolean redo() {
        if (redoStack.isEmpty()) return false;

        Action a = redoStack.pop();

        if (a.getType() == Action.Type.ADD_LINE) {
            lines.add(a.getLine());
            undoStack.push(a);
            return true;
        }

        return false;
    }
}