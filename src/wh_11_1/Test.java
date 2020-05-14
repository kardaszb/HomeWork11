package wh_11_1;

import java.io.*;

class Test {
    public static void main(String[] args) {
        final String FILE_NAME = "TestFile.txt";
        final String RESULTS_FILE_NAME = "testResults.txt";
        try {
            Employe[] employes = EmployeeReader.readFromFile(FILE_NAME);
            for (Employe employe : employes) {
                System.out.println(employe);
            }
            FileOperations.fileChecker(RESULTS_FILE_NAME);

            FileOperations.fileWriter(RESULTS_FILE_NAME, Statistics.avgEmployeeSalary(employes));
            FileOperations.fileWriter(RESULTS_FILE_NAME, Statistics.minEmployeeSalary(employes));
            FileOperations.fileWriter(RESULTS_FILE_NAME, Statistics.maxEmployeeSalary(employes));
            FileOperations.fileWriter(RESULTS_FILE_NAME, Statistics.empNOinDepartment(employes, "it"));

            FileOperations.fileReader(RESULTS_FILE_NAME);
        } catch (FileNotFoundException ex) {
            System.err.println(ex.getMessage());
        }
    }

}
