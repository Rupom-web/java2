import java.util.Scanner;

public class calander {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter month: ");
        int month = sc.nextInt();

        System.out.print("Enter year: ");
        int year = sc.nextInt();

        int days;

      
        if (month == 2) {
            if (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0))
                days = 29;
            else
                days = 28;
        }
        else if (month == 4 || month == 6 || month == 9 || month == 11) {
            days = 30;
        }
        else {
            days = 31;
        }

        // Find first day of the month
        int totalDays = 0;

        for (int y = 1; y < year; y++) {
            if (y % 400 == 0 || (y % 4 == 0 && y % 100 != 0))
                totalDays += 366;
            else
                totalDays += 365;
        }

        for (int m = 1; m < month; m++) {

            if (m == 2) {
                if (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0))
                    totalDays += 29;
                else
                    totalDays += 28;
            }
            else if (m == 4 || m == 6 || m == 9 || m == 11) {
                totalDays += 30;
            }
            else {
                totalDays += 31;
            }
        }

        int firstDay = totalDays % 7;

        String[] months = {
            "", "January", "February", "March", "April",
            "May", "June", "July", "August", "September",
            "October", "November", "December"
        };

        System.out.println("\n      " + months[month] + " " + year);
        System.out.println("Sun Mon Tue Wed Thu Fri Sat");

        // Spaces before day 1
        for (int i = 0; i < firstDay; i++) {
            System.out.print("    ");
        }

        // Print days
        for (int day = 1; day <= days; day++) {

            System.out.printf("%3d ", day);

            if ((firstDay + day) % 7 == 0) {
                System.out.println();
            }
        }

        sc.close();
    }
}