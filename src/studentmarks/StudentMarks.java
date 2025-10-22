package studentmarks;


import java.util.Scanner;

public class StudentMarks {

    public static void main(String[] args) {

        // Create Scanner object to take input from the user
        Scanner sc = new Scanner(System.in);

        System.out.println("========================================");
        System.out.println("     STUDENT MARKS MANAGEMENT SYSTEM    ");
        System.out.println("========================================");

        // Step 1: Take number of students from user
        System.out.print("Enter the number of students: ");
        int n = sc.nextInt(); // store array size

        // Handle invalid input
        if (n <= 0) {
            System.out.println("Invalid number of students! Exiting program.");
            sc.close();
            return;
        }

        // Step 2: Create array to store marks for 'n' students
        int[] marks = new int[n];

        // Step 3: Input marks for each student
        System.out.println("\nEnter marks for " + n + " students:");
        for (int i = 0; i < n; i++) {
            System.out.print("Student " + (i + 1) + ": ");
            marks[i] = sc.nextInt();
        }

        // Step 4: Display original marks before sorting
        System.out.println("\n---- Original Marks ----");
        printArray(marks);

        // Step 5: Sort marks using Bubble Sort
        bubbleSort(marks);

        System.out.println("\n---- Sorted Marks (Lowest to Highest) ----");
        printArray(marks);

        // Step 6: Search for a specific student's marks using Linear Search
        System.out.print("\nEnter marks to search for: ");
        int key = sc.nextInt(); // value to search

        int result = linearSearch(marks, key); // call linear search function

        // Display search results
        System.out.println("\n---- Search Result ----");
        if (result == -1) {
            System.out.println("Marks not found for any student.");
        } else {
            System.out.println("Marks found at student index: " + result);
        }

        // Step 7: Display small statistics (safe enhancement)
        displayStatistics(marks);

        // Close Scanner to prevent resource leak
        sc.close();

        System.out.println("\n===== Thank You! Program Ended Successfully =====");
    }

    // Function to print array elements
    public static void printArray(int[] marks) {
        for (int i = 0; i < marks.length; i++) {
            System.out.print(marks[i] + " ");
        }
        System.out.println();
    }

    // Bubble Sort algorithm
    public static void bubbleSort(int[] marks) {
        int n = marks.length;
        // Outer loop -> number of passes needed (n-1)
        for (int i = 0; i < n - 1; i++) {
            // Inner loop -> compare adjacent elements
            for (int j = 0; j < n - i - 1; j++) {
                if (marks[j] > marks[j + 1]) { // if current element > next element
                    // swap
                    int temp = marks[j];
                    marks[j] = marks[j + 1];
                    marks[j + 1] = temp;
                }
            }
        }
    }

    // Linear Search algorithm
    public static int linearSearch(int[] marks, int key) {
        // Loop through the array to find the key
        for (int i = 0; i < marks.length; i++) {
            if (marks[i] == key) { // if element found
                return i; // return the index
            }
        }
        return -1; // return -1 if element not found
    }

    // Small optional enhancement: Display simple statistics
    public static void displayStatistics(int[] marks) {
        int n = marks.length;
        int highest = marks[n - 1];
        int lowest = marks[0];
        double total = 0;

        for (int m : marks) {
            total += m;
        }

        double average = total / n;

        System.out.println("\n---- Statistics ----");
        System.out.println("Highest Marks : " + highest);
        System.out.println("Lowest Marks  : " + lowest);
        System.out.println("Average Marks : " + String.format("%.2f", average));
    }
}
