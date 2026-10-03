public class uniqenumbercreating {
    public static void main(String[] args) {
      

        int count = 0;

        for (int a = 1; a <= 5; a++) {
            for (int b = 1; b <= 5; b++) {
                for (int c = 1; c <= 5; c++) {
                    for (int d = 1; d <= 5; d++) {
                        for (int e = 1; e <= 5; e++) {

                            if (a != b && a != c && a != d && a != e &&
                                b != c && b != d && b != e &&
                                c != d && c != e &&
                                d != e) {

                                System.out.println("" + a + b + c + d + e);
                                count++;
                            }
                        }
                    }
                }
            }//n!
        }

        System.out.println("Total unique five-digit numbers = " + count);
    }
}
    