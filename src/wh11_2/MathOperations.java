package wh11_2;

public class MathOperations {
    final static String RESULTS_FILE_NAME = "testResults.txt";
    static void mathOperations(MathValues[] mathValues) {
        for (MathValues mathValue : mathValues) {
            int A = Integer.parseInt(mathValue.getValueA());
            int B = Integer.parseInt(mathValue.getValueB());
            String operator = mathValue.getOperator();
            int result = result(A,B,operator);
            FileOperations.fileWriter(RESULTS_FILE_NAME,stringConverter(A,B,operator,result));
        }
    }

    private static int result(int A, int B, String operator) {
        int results = 0;
        switch (operator) {
            case "+":
                results = A + B;
                break;
            case "-":
                results = A - B;
                break;
            case "*":
                results = A * B;
                break;
            case "/":
                results = A / B;
                break;
        }
        return results;
    }
    private static String stringConverter(int A, int B, String operator, int result){
        return Integer.toString(A) + operator + Integer.toString(B) + "=" + result;
    }



}