package org.tdd;

import java.util.Arrays;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        int arr[] ={3,60,35,2,45,320,5};

        System.out.println("Array Before Bubble Sort");
        for(int i=0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();

        bubbleSort(arr);//sorting array elements using bubble sort

        System.out.println("Array After Bubble Sort");
        for(int i=0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }

        /*
        List<String> strConvertida = converterCamelCase("nome10CompostEmail");
        System.out.println(strConvertida);*/
    }

    public static List<String> converterCamelCase(String original) {
        String[] result = original.split("(?=\\p{Upper})");
        for (String res : result) {
            if (res.matches(".*[^a-zA-Z0-9].*")) {
                List<String> err = Arrays.asList("Invalido");
                return err;
            }
            boolean first = Character.isDigit(res.charAt(0));
            if (first) {
                List<String> err = Arrays.asList("Invalido");
                return err;
            }
        }
        List<String> success = Arrays.asList(result);
        return success;
    }

    static void bubbleSort(int[] arr) {
        int n = arr.length;
        int temp = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < (n - i); j++) {
                if (arr[j - 1] > arr[j]) {
                    //swap elements
                    temp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = temp;
                }

            }
        }
    }

}