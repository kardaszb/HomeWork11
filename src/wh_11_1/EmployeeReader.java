package wh_11_1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class EmployeeReader {

    static Employe[] readFromFile(String file) throws FileNotFoundException {
        final int linesNumber = countLines(file);
        Employe[] employes = new Employe[linesNumber];
        try (Scanner scanner = new Scanner(new File(file))) {
            for (int i = 0; i < linesNumber; i++) {
                String fileLine = scanner.nextLine();
                employes[i] = createEmployee(fileLine);
            }
        }
        return employes;
    }

    private static Employe createEmployee(String fileLine) {
        String[] data = fileLine.split(";");
        String firstName = data[0];
        String lastName = data[1];
        int pesel = Integer.parseInt(data[2]);
        String department = data[3];
        double payment = Double.parseDouble(data[4]);
        return new Employe(firstName, lastName, pesel, department, payment);
    }

    public static int countLines(String file) throws FileNotFoundException {
        int lines = 0;
        try (Scanner scanner = new Scanner(new File(file))) {
            while (scanner.hasNextLine()) {
                scanner.nextLine();
                lines++;
            }
        }
        return lines;
    }
}