package edu.umn.d.cs1632;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        MArray mArray = new MArray("src/data/simple.csv");

        System.out.println("Data:");
        mArray.printData();

        while (true) {

            System.out.print("Query? ");
            String input = scanner.nextLine();

            String[] parts = input.split(" ");

            if (parts[0].equals("Q")) {
                break;
            }

            if (parts[0].equals("V")) {

                int col = Integer.parseInt(parts[1]);
                int rowStart = Integer.parseInt(parts[2]);
                int rowEnd = Integer.parseInt(parts[3]);

                System.out.println(
                        mArray.verticalQuery(col, rowStart, rowEnd)
                );

            } else if (parts[0].equals("H")) {

                int row = Integer.parseInt(parts[1]);
                int colStart = Integer.parseInt(parts[2]);
                int colEnd = Integer.parseInt(parts[3]);

                System.out.println(
                        mArray.horizontalQuery(row, colStart, colEnd)
                );

            } else if (parts[0].equals("M")) {

                int rowStart = Integer.parseInt(parts[1]);
                int rowEnd = Integer.parseInt(parts[2]);
                int colStart = Integer.parseInt(parts[3]);
                int colEnd = Integer.parseInt(parts[4]);

                System.out.println(
                        mArray.matrixQuery(
                                rowStart,
                                rowEnd,
                                colStart,
                                colEnd
                        )
                );
            }
        }

        scanner.close();
    }
}