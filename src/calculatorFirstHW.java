import java.util.Scanner;

public class calculatorFirstHW {


    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        long desChislo = 0;
        String twoChislo = "";

        System.out.println("Enter you number");
        desChislo = input.nextLong();

        System.out.println("It can be ")
        ;
        if (desChislo <= 127) {
            System.out.print("byte ");
        }
        if (desChislo <= 32767) {
            System.out.print("short ");
        }
        if (desChislo <= 2147483647) {
            System.out.print("int ");
        }
        System.out.print("long ");

        while (desChislo > 1) {
            twoChislo += desChislo % 2;
            desChislo /= 2;
        }

        System.out.println();
        System.out.print("1");

        for (int n = twoChislo.length()-1; n > -1; n--) {
            System.out.print(twoChislo.charAt(n));
        }
    }
}
