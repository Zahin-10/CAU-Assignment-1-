package com.uri;
import java.util.Arrays;

public class LinkedList {
    Item head,tail;
    static int size;
    public class Item{
        String value;
        Item next;

        Item(String givenValue){
            this.value = givenValue;
        }

        public void addNextItem (Item reference){
            this.next = reference;
        }

    }

    LinkedList(){
        this.head = null;
        this.tail = null;
        LinkedList.size = 0;
    }

    public void addItem(String value){
        if (head==null){
            LinkedList.size=1;
            this.head = new Item(value);
            tail = head;
        }
        else {
            LinkedList.size++;
            Item newItem = new Item(value);
            tail.addNextItem(newItem);
            tail = tail.next;
        }
    }

    public void addItemSortedly(){

    }

    public void unRemove(String value){
        Item newItem = new Item(value);
        newItem.next = head;
        head = newItem;
        LinkedList.size++;
    }

    public String removeItem(){
        if (head==null){
            return null;
        }
        else {
            LinkedList.size--;
            String removedValue = head.value;
            head = head.next;
            return removedValue;
        }

    }

    public void printValue(){
        Item print;
        print = head;
        while (print!=null){
            System.out.print(print.value);
            if(print.next != null)
            {
                System.out.print("->");
            }
            print = print.next;
        }
        System.out.println("");
    }

    public String[] toArray(){
        Item iterator;
        iterator = head;
        String[] LinkedListArray = new String[LinkedList.size];
        int i =0;
        while (iterator!=null){
            LinkedListArray[i] = iterator.value;
            iterator = iterator.next;
            i++;
        }
        return LinkedListArray;
    }

    public void removeValue(String search){
        Item iterator;
        iterator = head;
        int i =0;
        while (iterator != null){
            if(iterator.next.value == search){
                if(iterator.next.next != null)
                {
                    iterator.next = iterator.next.next;
                }else{
                    iterator.next = null;
                }
            }else{
                iterator = iterator.next;
            }
            i++;
        }
    }
}
