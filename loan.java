import java.util.Scanner;

class Loan {
    double amount, rate;
    int years;

    Loan(double amount, int years, double rate) {
        this.amount = amount;
        this.years = years;
        this.rate = rate;
    }

    double monthlyPayment() {
        double r = rate / 1200;
        return (amount * r) / (1 - 1 / Math.pow(1 + r, years * 12));
    }

    double totalPayment() {
        return monthlyPayment() * years * 12;
    }
}

public class loan {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter loan amount: ");
        double amount = sc.nextDouble();

        System.out.print("Enter number of years: ");
        int years = sc.nextInt();

        System.out.printf("%-15s %-18s %-15s%n",
                "Rate", "Monthly", "Total");

        for (double rate = 5; rate <= 10; rate += 0.25) {

            Loan l = new Loan(amount, years, rate);

            System.out.printf("%.2f%%        %.2f        %.2f%n",
                    rate, l.monthlyPayment(), l.totalPayment());
        }

        sc.close();
    }
}