package org.math;

public class PascalTriangleNCR {
    static void main() {
        printPascalAll(5);
        System.out.println();
        printPascal(5);
    }

    public static void printPascalAll(int n) {
        for (int i = 0; i < n; i++) {
            int val = 1;
            int space = 0;
            while (space < n - i) {
                System.out.print(" ");
                space++;
            }
            for (int k = 0; k <= i; k++) {
                System.out.print(val + " ");
                val = val * (i - k) / (k + 1); // Iterative formula
            }
            System.out.println();
        }
    }

    public static void printPascal(int n) {
        int val = 1;
        for (int k = 0; k <= n; k++) {
            System.out.print(val + " ");
            val = val * (n - k) / (k + 1); // Iterative formula
        }
        System.out.println();
    }
}
