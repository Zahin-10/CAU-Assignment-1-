package com.uri;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static String[] initialArgs;
    public static String[] array;
    public static LinkedList list;

    public static void main(String[] args) {
	// write your code here
        initialArgs = args;
        String[] data = {"java", "FirstMiniTest", "Hello", "Kiel", "University", "Java", "Mini", "Test"};
        runProgram(args);

    }
    public static void runProgram(String[] data){
        getMenu();
        Scanner sc = new Scanner(System.in);
        int option = sc.nextInt();
        switch (option){
            case 1:
                startQuickSort(data);
                break;
            case 2:
                startArrayToLinkedlist();
                break;
            case 5:
                removeItem();
                break;
        }
    }

    public static void getMenu(){
        System.out.println("1. Sort array Elements (Insertion Sort/ quick Sort)");
        System.out.println("2. Array to Linked List");
        System.out.println("3. Linked List to Array");
        System.out.println("4. Sortedly Insert a value in Linked List");
        System.out.println("5. Delete a value from Linked list (Delete anyone if multiple occurances)");
        System.out.println("6. Exit");
    }
    public static void startArrayToLinkedlist (){
        LinkedList listOne = new LinkedList();
        for(int i =0;i < array.length;i++){
            listOne.addItem(array[i]);
        }
        list = listOne;
        listOne.printValue();
        runProgram(array);
    }

    public static void removeItem(){
        Scanner sc = new Scanner(System.in);
        String item = sc.nextLine();
        list.removeValue(item);
    }

    public static void startQuickSort(String[] data){

        quicksort(data,0,data.length-1);
        System.out.println(Arrays.toString(data));
        array = data;
        runProgram(data);
    }

    public static void quicksort(String[] data, int start, int end){
        if(start<end)
        {
            int newPosOfPivot = partition(data,end);
            quicksort(data,start,newPosOfPivot-1);
            quicksort(data,newPosOfPivot+1,end);
        }
    }
    public static int partition(String[] data, int pivot){
        int i = -1;
        for(int j=0; j < pivot; j++)
        {
            if(data[j].compareTo( data[pivot]) < 0){
                i++;
                swap(data,i,j);
            }
        }
        swap(data,i+1,pivot);
        return i+1;
    }

    public static void swap(String[] data, int posI, int posJ){
        String temp = data[posI];
        data[posI] = data[posJ];
        data[posJ] = temp;
    }
}
