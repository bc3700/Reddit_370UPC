import java.util.Scanner;

public class UpcDigitChecker
{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter in an 11-digit UPC code: ");
        String upcCode = scanner.next();
        int calculatedLastDigit = calculateUpcLastDigit(upcCode);
        System.out.println("The calculated last digit is: " + calculatedLastDigit);
    }

    public static int calculateUpcLastDigit(String upcCode) {
        int lastDigit = -1;
        int sumOdd = 0;
        int sumEven = 0;
        int totalSum = 0;
        int M = -1;
        for(int i = 0; i < upcCode.length(); i++) {
            if(i % 2 == 0) {
                sumOdd += Integer.parseInt(upcCode.substring(i, i + 1));
            }
        }
        sumOdd *= 3;

        for(int i = 0; i < upcCode.length(); i++) {
            if(i %2 != 0) {
                sumEven += Integer.parseInt(upcCode.substring(i, i + 1));
            }
        }
        totalSum = sumEven + sumOdd;
        M = totalSum % 10;

        if(M == 0) {
            lastDigit = 0;
        }
        else {
            lastDigit = 10 - M;
        }

        return lastDigit;
    }
}
