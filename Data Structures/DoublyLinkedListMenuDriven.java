package Algorithms;

import java.util.Scanner;

public class QuickSort {

	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the size of the list: ");
        int size = scanner.nextInt();

        String[] names = new String[size];

        System.out.println("Enter " + size + " names:");
        for (int i = 0; i < size; i++) {
            names[i] = scanner.next();
        }

        System.out.println("Original list:");
        printArray(names);

        quickSort(names, 0, names.length - 1);

        System.out.println("\nSorted list of names in ascending order:");
        printArray(names);

        scanner.close();
    }


    public static void quickSort(String[] arr, int low, int high) {
        if (low < high) {

            int pivotIndex = partition(arr, low, high);


            quickSort(arr, low, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, high);
        }
    }
    public static int partition(String[] arr, int low, int high) {

        String pivot = arr[high];

        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j].compareTo(pivot) <= 0) {
                i++;
                String temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        String temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }
    public static void printArray(String[] arr) {
        for (String s : arr) {
            System.out.print(s + " ");
        }
        System.out.println();
    }
}
