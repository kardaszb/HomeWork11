package wh_11_1;

import java.io.*;
import java.nio.file.*;

class Test {
    public static void main(String[] args) {
        final String FILE_NAME = "TestFile.txt";
        final String RESULTS_FILE_NAME = "testResults.txt";
        try {
            Employe[] employes = EmoloyeeReader.readFromFile(FILE_NAME);
            for (Employe x : employes) {
                System.out.println(x);
            }
            fileChecker(RESULTS_FILE_NAME);

            fileWriter(RESULTS_FILE_NAME, avgEmployeeSalary(employes));
            fileWriter(RESULTS_FILE_NAME, minEmployeeSalary(employes));
            fileWriter(RESULTS_FILE_NAME, maxEmployeeSalary(employes));
            fileWriter(RESULTS_FILE_NAME, empNOinDepartment(employes, "it"));

            fileReader(RESULTS_FILE_NAME);
        } catch (FileNotFoundException ex) {
            System.err.println(ex.getMessage());
        }
    }

    private static String avgEmployeeSalary(Employe[] employes) {
        int counter = 0;
        double salarySum = 0;
        for (Employe employe : employes) {
            salarySum += employe.getPayment();
            counter++;
        }
        double avgValue = salarySum / counter;
        return "Średnia wypłata:" + avgValue;
    }

    private static String minEmployeeSalary(Employe[] employes) {
        Employe minSalary = employes[0];
        for (Employe employe : employes) {
            if (employe.getPayment() < minSalary.getPayment())
                minSalary = employe;
        }
        return "najmniejsza wypłata: " + minSalary.getPayment();
    }

    private static String maxEmployeeSalary(Employe[] employes) {
        Employe maxSalary = employes[0];
        for (Employe employe : employes) {
            if (employe.getPayment() > maxSalary.getPayment())
                maxSalary = employe;
        }
        return "największa wypłata: " + maxSalary.getPayment();
    }

    private static String empNOinDepartment(Employe[] employes, String department) {
        int counter = 0;
        for (Employe employe : employes) {
            if (department.equals(employe.getDepartment())) {
                counter++;
            }
        }
        return "Liczba pracownikow w dziale " + department + ": " + counter;
    }

    private static void fileWriter(String fileName, String nextLine) {
        try (
                var fileWriter = new FileWriter(fileName, true);
                var writer = new BufferedWriter(fileWriter);
        ) {
            writer.write(nextLine);
            writer.newLine();
        } catch (IOException e) {
            System.err.println("Nie udało się zapisać pliku " + fileName);
        }
    }

    private static void fileReader(String fileName) {
        try (
                var fileReader = new FileReader(fileName);
                var reader = new BufferedReader(fileReader);
        ) {
            String nextLine = null;
            while ((nextLine = reader.readLine()) != null) {
                System.out.println(nextLine);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void fileChecker(String fileName){
        try
        {
            Files.deleteIfExists(Paths.get(fileName));
        }
        catch(NoSuchFileException e)
        {
            System.out.println("No such file/directory exists");
        }
        catch(IOException e)
        {
            System.out.println("Invalid permissions.");
        }

        System.out.println("Deletion successful.");
    }
}
