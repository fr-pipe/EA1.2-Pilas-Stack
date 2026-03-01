package app;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        TextEditor editor = new TextEditor();
        int option;

        do {
            System.out.println("Editor Undo/Redo (Pilas)");
            System.out.println("1. Escribir texto");
            System.out.println("2. Deshacer (Undo)");
            System.out.println("3. Rehacer (Redo)");
            System.out.println("4. Mostrar texto actual");
            System.out.println("5. Salir");
            System.out.print("Elige una opción: ");

            option = Integer.parseInt(sc.nextLine());

            switch (option) {
                case 1:
                    System.out.print("Escribe una línea: ");
                    String line = sc.nextLine();
                    editor.writeLine(line);
                    System.out.println("Línea agregada.");
                    break;

                case 2:
                    if (editor.undo())
                        System.out.println("Undo realizado.");
                    else
                        System.out.println("No hay acciones para deshacer.");
                    break;

                case 3:
                    if (editor.redo())
                        System.out.println("Redo realizado.");
                    else
                        System.out.println("No hay acciones para rehacer.");
                    break;

                case 4:
                    System.out.println("TEXTO ACTUAL");
                    System.out.println(editor.getText());
                    break;

                case 5:
                    System.out.println("Saliendo");
                    break;

                default:
                    System.out.println("Opción inválida.");
            }

        } while (option != 5);

        sc.close();
    }
}