package wh_11_1;

public class Statistics {
    static String avgEmployeeSalary(Employe[] employees) {
        int counter = 0;
        double salarySum = 0;
        for (Employe employe : employees) {
            salarySum += employe.getPayment();
            counter++;
        }
        double avgValue = salarySum / counter;
        return "Średnia wypłata:" + avgValue;
    }

    static String minEmployeeSalary(Employe[] employees) {
        try {
            Employe minSalary = employees[0];
            for (Employe employe : employees) {
                if (employe.getPayment() < minSalary.getPayment())
                    minSalary = employe;
            }
            return "najmniejsza wypłata: " + minSalary.getPayment();
        } catch (ArrayIndexOutOfBoundsException ex) {
            return "Nie da sie policzyc. Pusta tablica";
        }

    }

    static String maxEmployeeSalary(Employe[] employees) {
        try {
            Employe maxSalary = employees[0];
            for (Employe employe : employees) {
                if (employe.getPayment() > maxSalary.getPayment())
                    maxSalary = employe;
            }
            return "największa wypłata: " + maxSalary.getPayment();
        } catch (ArrayIndexOutOfBoundsException ex) {
            return "Nie da sie policzyc. Pusta tablica";
        }

    }

    static String empNOinDepartment(Employe[] employees, String department) {
        int counter = 0;
        for (Employe employe : employees) {
            if (department.equals(employe.getDepartment())) {
                counter++;
            }
        }
        return "Liczba pracownikow w dziale " + department + ": " + counter;
    }
}