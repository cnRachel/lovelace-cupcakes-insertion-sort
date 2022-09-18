package com.example;

import org.json.simple.*;
import org.w3c.dom.NameList;

public class App 
{
    private static int count = 0;
    public static void main( String[] args )
    {
        String fileName = "C:/Users/rache/Documents/GitHub/lovelace-cupcakes-insertion-sort/cupcake_sort/src/main/java/com/example/cupcake_3906.json";
        //String fileName = "C:/Users/rache/Documents/GitHub/lovelace-cupcakes-insertion-sort/cupcake_sort/src/main/java/com/example/cupcake_test_10.json";

        //read cupcake names
        JSONArray cupcakeArray = JSONFile.readArray(fileName);
        String[] cupcakeNameArray = nameArray(cupcakeArray);
        //System.out.println(cupcakeNameArray);

        //print unsorted list
        //System.out.println("----- Unsorted array -----");
        //print(cupcakeNameArray);

        //sort
        insertionSort(cupcakeNameArray);

        //print sorted list
        //System.out.println("----- Sorted array----- ");
        //print(cupcakeNameArray);

        //print statistics
        System.out.println("----- Statistics -----");
        System.out.printf("Size of array = %d\n", cupcakeNameArray.length);
        System.out.printf("Count = %d\n", count);

    }

    //print cupcake array
    public static void print(String[] cupcakeNameArray) {
        System.out.printf("Number\tName\n");
        System.out.printf("------\t---------------\n");
        for (int i = 0; i < cupcakeNameArray.length; i++) {
            System.out.printf("%04d\t%s\n", i, cupcakeNameArray[i]);
        }
    }

    //get array of cupcake names
    public static String[] nameArray(JSONArray cupcakeArray) {
        String[] arr = new String[cupcakeArray.size()];

        for (int i = 0; i < cupcakeArray.size(); i++) {
            JSONObject o = (JSONObject) cupcakeArray.get(i);
            String name = (String) o.get("name");
            arr[i] = name;
        }

        return arr;
    }

    public static void insertionSort(String[] arr) {
        for (int i = 1; i < arr.length; i++) {
            String key = arr[i];
            
            int j = i-1;
            while (j >= 0 && arr[j].compareTo(key) > 0) {
                arr[j+1] = arr[j];
                j--;
                count++;
            }
            arr[j+1] = key;
        }
    }

}
