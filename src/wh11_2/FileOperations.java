package wh11_2;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.util.Scanner;

public class FileOperations {
    static MathValues[] readFromFile(String file) throws FileNotFoundException {
        final int linesNumber = countLines(file);
        MathValues[] mathValues = new MathValues[linesNumber];
        try (Scanner scanner = new Scanner(new File(file))) {
            for (int i = 0; i < linesNumber; i++) {
                String fileLine = scanner.nextLine();
                mathValues[i] = MathValuesCreate.createValue(fileLine);
            }
        }
        return mathValues;
    }
    private static int countLines(String file) throws FileNotFoundException {
        int lines = 0;
        try (Scanner scanner = new Scanner(new File(file))) {
            while (scanner.hasNextLine()) {
                scanner.nextLine();
                lines++;
            }
        }
        return lines;
    }

    static void writeToFile(String fileName, String nextLine) {
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

    static void readFile(String fileName) {
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

    static void checkFileExist(String fileName){
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