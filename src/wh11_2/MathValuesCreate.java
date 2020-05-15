package wh11_2;

public class MathValuesCreate {
    static MathValues createValue(String fileLine) {
        String[] data = fileLine.split(" ");
        String valueA = data[0];
        String operator = data[1];
        String valueB = data[2];
        return new MathValues(valueA, operator, valueB);
    }
}