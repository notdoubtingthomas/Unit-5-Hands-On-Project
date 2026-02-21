import java.util.Scanner;

/**
 * Unit 5 - Loop-Based Algorithm Toolkit (STUDENT STARTER)
 * Complete each TODO section. Keep your code clean and well-commented.
 *
 * Requirements reminder:
 * - Use all 3 loop types (for, while, do-while) across the program
 * - Use break OR continue at least once
 * - Include comments explaining loop logic and exit conditions
 */
public class LoopBasedAlgorithmToolkit {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // ============================================================
        // 1) Generate the FIRST 100 PRIME NUMBERS
        // TODO:
        //  - Generate and print the first 100 primes.
        //  - Optimize: test divisors only up to sqrt(n) (i * i <= n).
        //  - Use break to exit the divisor loop when a factor is found.
        // Hint:
        //  - Keep a primeCount variable and a candidate number starting at 2.
        // ============================================================

        final int NUMBER_OF_PRIMES = 100; // Number of primes to display
        final int NUMBER_OF_PRIMES_PER_LINE = 10; // Display 10 per line
        int count = 0; // Count the number of prime numbers
        int number = 2; // A number to be tested for primeness

        System.out.println("The first 100 prime numbers are \n");

        // Repeatedly find prime numbers
        while (count < NUMBER_OF_PRIMES) {
            // Assume the number is prime
            boolean isPrime = true;

            // Test if number is prime
            for (int divisor = 2; divisor * divisor <= number / 2; divisor++) {
                if (number % divisor == 0) {
                    isPrime = false;
                    break;
                }
            }

            if (isPrime) {
                count++;

                if (count % NUMBER_OF_PRIMES_PER_LINE == 0) {
                    // Print the number and advance to the new line
                    System.out.println(number);
                }
                else
                    System.out.println(number + " ");
            }
            // Check if the next number is prime
            number++;
        }


        System.out.println(); // spacing

        // ============================================================
        // 2) Compute the GCD of TWO USER INPUTS (Euclidean Algorithm)
        // TODO:
        //  - Prompt user for two integers a and b.
        //  - Use a while loop to compute gcd(a, b).
        //  - Print the GCD result.
        // ============================================================

        // Prompt the user to enter two integers
        System.out.print("Enter first integer: ");
        int a = scanner.nextInt();
        System.out.print("Enter second integer: ");
        int b = scanner.nextInt();

        int gcd = 1;
        int k = 2;

        // Loop from k up to the smaller of a and b
        while (k <= a && k <= b) {
            // Check if k divides both a and b evenly
            if (a % k == 0 && b % k == 0)
                gcd = k; // If yes, update gcd to the current k (largest so far)
            k++; // Move to the next number to test
        }

        System.out.println("The greatest common divisor for " + a + " and " + b + " is " + gcd);

        // ============================================================
        // 3) Convert DECIMAL to HEXADECIMAL
        // TODO:
        //  - Prompt user for a non-negative integer.
        //  - Convert to hex using repeated division by 16.
        //  - Use a do-while loop so the conversion runs at least once (handles 0).
        //  - Print the hex value.
        // Hint:
        //  - digits = "0123456789ABCDEF"
        //  - remainder -> digits.charAt(remainder)
        // ============================================================

        // Prompt user to enter a non-negative integer
        System.out.print("Enter a non-negative integer: ");
        int a2 = scanner.nextInt();

        // convert integer to hex
        String hex = "";

        do {
            int hexValue = a2 % 16;

            // Convert a non-negative integer to a hex value
            char hexDigit = (0 <= hexValue && hexValue <= 9) ? (char)(hexValue + '0') : (char)(hexValue - 10 + 'A');

            hex = hexDigit + hex;
            a2 = a2 / 16;
        } while (a2 != 0);

        System.out.println("The hex number is " + hex);

        System.out.println(); // spacing

        // ============================================================
        // 4) Palindrome Check (STRING)
        // TODO:
        //  - Prompt user for a string.
        //  - Check if it is a palindrome (case-insensitive).
        //  - Use a for loop comparing characters from both ends.
        //  - Use break if a mismatch is found.
        //  - Print true/false (or a friendly message).
        // ============================================================

        // Promp the user to enter a string
        System.out.print("Enter a string: ");
        scanner.nextLine();
        String s = scanner.nextLine();

        // Ensures input is case-insensitive
        s = s.toLowerCase();

        // The index of the first character in the string
        int low = 0;

        // The index of the last character in the string
        int high = s.length() - 1;

        boolean isPalindrome = true;
        while (low < high) {
            if (s.charAt(low) != s.charAt(high)) {
                isPalindrome = false;
                break;
            }
            low++;
            high--;
        }
        if (isPalindrome)
            System.out.println(s + " is a palindrome");
        else
            System.out.println(s + " is not a palindrome");

        System.out.println(); // spacing

        // ============================================================
        // 5) Nested loops: MULTIPLICATION TABLE
        // TODO:
        //  - Print a 10x10 multiplication table using nested loops.
        //  - Use printf to align values (e.g., %4d).
        // ============================================================

        for (int i = 1; i <= 10; i++) { // outer loop: rows
            System.out.printf("%4d)", i); // row header
            for (int j = 1; j <= 10; j++) { // inner loop: columns
                System.out.printf("%4d", i * j); // print with width of 4
            }
            System.out.println();
        }


        scanner.close();
    }
}
