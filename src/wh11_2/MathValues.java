package wh11_2;

public class MathValues {
    private String  valueA;
    private String operator;
    private String valueB;

    public MathValues(String valueA, String operator, String valueB) {
        this.valueA = valueA;
        this.operator = operator;
        this.valueB = valueB;
    }

    public String getValueA() {
        return valueA;
    }

    public void setValueA(String valueA) {
        this.valueA = valueA;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getValueB() {
        return valueB;
    }

    public void setValueB(String valueB) {
        this.valueB = valueB;
    }

    @Override
    public String toString() {
        return "MathValues{" +
                "valueA=" + valueA +
                ", operator='" + operator + '\'' +
                ", valueB=" + valueB +
                '}';
    }
}