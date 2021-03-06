package wh11_2;

import java.io.FileNotFoundException;

class Test {
    public static void main(String[] args) {
        final String FILE_NAME = "TestFile.txt";
        try {
            MathValues[] mathValues = FileOperations.readFromFile(FILE_NAME);
            for (MathValues mathValue : mathValues) {
                System.out.println(mathValue);
            }
            FileOperations.checkFileExist(MathOperations.RESULTS_FILE_NAME);
            MathOperations.writeMathOperationsTofile(mathValues);
            FileOperations.readFile(MathOperations.RESULTS_FILE_NAME);
        } catch (FileNotFoundException ex) {
            System.err.println(ex.getMessage());
        }
    }
}
