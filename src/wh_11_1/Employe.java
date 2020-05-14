package wh_11_1;

public class Employe {
    private String firstName;
    private String lastName;
    private int pesel;
    private String department;
    private double payment;

    public Employe(String firstName, String lastName, int pesel, String department, double payment) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.pesel = pesel;
        this.department = department;
        this.payment = payment;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getPesel() {
        return pesel;
    }

    public void setPesel(int pesel) {
        this.pesel = pesel;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public double getPayment() {
        return payment;
    }

    public void setPayment(double payment) {
        this.payment = payment;
    }

    @Override
    public String toString() {
        return "Employe{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", pesel=" + pesel +
                ", department='" + department + '\'' +
                ", payment=" + payment +
                '}';
    }
}
