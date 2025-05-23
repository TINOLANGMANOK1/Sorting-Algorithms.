/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.sorting1;

/**
 *
 * @author Students Account
 */
import java.util.*;

public class Sorting1 {

    public static void main(String[] args) {

        String[] names = {
            "Kevin", "Rachel", "Owen", "Jasmin", "Gabriel", "Olivia", "Madison", "Alexander", "Jacob", "Hannah",
            "Penelope", "Sarah", "Isabella", "Quentin", "Emma", "Victor", "Aaron", "Patrick", "Yasmine", "Grace",
            "Steven", "Liam", "Brianna", "Nathan", "William", "Diana", "Leah", "Mathhew", "Abigail", "Joshua",
            "Caleb", "Noah", "Charlotte", "Sophia", "Uriel", "Lucas", "Samuel", "Mia", "Elijah", "Zachary",
            "Tristan", "Zoe", "Alice", "Vanessa", "Thomas", "Katherine", "Benjamin", "Isaac", "Daniel", "Xander"
        };

        // -- METHOD CHOICES --
        /*
           1 = Bubble Sort
           2 = Selection Sort
           3 = Insertion Sort 
        */ 
        int choice = 1; // Replace with method choice

        if (choice == 1) {
            bubbleSort(names);
            System.out.println("-- Sorted using Bubble Sort: --");
            printDaNames(names);
        } else if (choice == 2) {
            selectionSort(names);
            System.out.println("-- Sorted using Selection Sort: --");
            printDaNames(names);
        } else if (choice == 3) {
            insertionSort(names);
            System.out.println("-- Sorted using Insertion Sort: --");
            printDaNames(names);
        } else {
            bubbleSort(names);
            selectionSort(names);
            insertionSort(names);
            System.out.println("-- Sorted using all Methods --");
            printDaNames(names);
        }
    }
    
    // --- BUBBLE SORT ---
    public static void bubbleSort(String[] arr) {
        int n = arr.length;
        boolean Isort;
        for (int i = 0; i < n - 1; i++) {
            Isort = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j].compareTo(arr[j + 1]) > 0) {
                    String temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    Isort = true;
                }
            }
            if (!Isort) {
                break;
            }
        }
    }
    
    // --- SELECTION SORT ---
    public static void selectionSort(String[] names) {
        int n = names.length;
        for (int i = 0; i < n - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < n; j++) {
                if (names[j].compareTo(names[minIdx]) < 0) {
                    minIdx = j;
                }
            }
            String temp = names[minIdx];
            names[minIdx] = names[i];
            names[i] = temp;
        }
    }

    // --- INSERTION SORT ---
    public static void insertionSort(String[] names) {
        int n = names.length;
        for (int i = 1; i < n; i++) {
            String key = names[i];
            int j = i - 1;
            while (j >= 0 && names[j].compareTo(key) > 0) {
                names[j + 1] = names[j];
                j--;
            }
            names[j + 1] = key;
        }
    }

    
    // --- DISPLAY THE NAMES ---
    public static void printDaNames(String[] names) {
        int count = 0;
        for (int i = 0; i < names.length; i++) {
            System.out.print("\"" + names[i] + "\"");
            if (i != names.length - 1) {
                System.out.print(", ");
            }
            count++;
            if (count == 5) {
                System.out.println();
                count = 0;
            }
        }
    }
}
