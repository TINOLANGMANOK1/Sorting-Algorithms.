/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sorting1;

/**
 *
 * @author Students Account
 */
import java.util.Scanner;

public class Sorting2 {
    
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
           1 = Merge Sort
           2 = Quick Sort
        */ 
        int choice = 1;  // Replace with method choice

        if (choice == 1) {
            mergeSort(names, 0, names.length - 1);
            System.out.println("-- Sorted using Merge Sort: --");
            printDaNames(names);
        } else if (choice == 2) {
            quickSort(names, 0, names.length - 1);
            System.out.println("-- Sorted using Quick Sort: --");
            printDaNames(names);
        } else {
            System.out.println("-- Invalid choice --");
        }
    }

    // --- MERGE SORT --
    public static void mergeSort(String[] arr, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    public static void merge(String[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;
        String[] L = new String[n1];
        String[] R = new String[n2];

        for (int i = 0; i < n1; i++)
            L[i] = arr[left + i];
        for (int j = 0; j < n2; j++)
            R[j] = arr[mid + 1 + j];

        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (L[i].compareTo(R[j]) <= 0) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    // --- QUICK SORT ---
    public static void quickSort(String[] arr, int low, int high) {
        if (low < high) {
            int pi = split(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }
    
    // 
    public static int split(String[] arr, int low, int high) {
        String pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j].compareTo(pivot) < 0) {
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