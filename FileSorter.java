/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FileSorter;

import FileSorter.InsertionSort.bydate;
import java.io.File;
import java.util.Comparator;
import java.util.Scanner;

/**
 *
 * @author Murtaza Kazmi
 */
public class FileSorter {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String filename = args[0] + " " + args[1];
        System.out.println(filename);
        
        //Task 1
        //sorting by name
        File input = new File(filename);
        File[] files = input.listFiles();
        insertionSort(files);
        
        System.out.println("Sorting file by name:");
        System.out.println("");
        for(int i = 0 ; i < files.length; i++){
            System.out.println(files[i]);
        }
        
        files = input.listFiles();
        //Self 1: task 1 completed, wow I'm genius haha
        //Self 2: ah, easy peasy beta, do Task 2!
        //Self 1: bring it on!
        
        //Task 2 begins   tadaaaa!
        //sorting by size and most recent modification (date)
        //easy peasy, we'll use comparator
        //insertions sort or mergesort can be used bcs only they are stable
        //Will use insertion sort then mergesort
        
        System.out.println();
        
        Scanner scan = new Scanner(System.in);
        String in = scan.next();
        
        switch (in){
            case "-t":
                //sort by time
                //first using insertion sort
                System.out.println("Sorting file by date:");
                System.out.println();
                InsertionSort a = new InsertionSort(files);
                long startTime = System.nanoTime();
                a.sort(files, a.new bydate());
                long elapsedTime = System.nanoTime() - startTime;
        
                long insertiontime = elapsedTime/1000;
                
                
                files = a.get();
                
                System.out.println("Date sorting from InsertionSort:");
                System.out.println();
                for(int j = 0 ; j < files.length; j++){
                System.out.println(files[j]);}
        
                
                //insertion sort end wrt time
                //using mergesort
                
                files = input.listFiles();
                MergeSort b = new MergeSort(files);
                
                startTime = System.nanoTime();
                
                b.sort(files, b.new bydate());
                elapsedTime = System.nanoTime() - startTime;
                
                files = b.get();
                
                System.out.println("");
                System.out.println("Date sorting from MergeSort:");
                System.out.println("");
                for(int k = 0 ; k < files.length; k++){
                    System.out.println(files[k]);}
                
                System.out.println("");
                System.out.println("Insertionsort = " +  insertiontime + " microseconds.");
                System.out.println("Mergesort = " +  elapsedTime/1000 + " microseconds.");
                break;
                
            case "-s":
                System.out.println("Sorting file by size:");
                System.out.println();
                a = new InsertionSort(files);
                long startTim = System.nanoTime();
                a.sort(files, a.new bysize());
                long elapsedTim = System.nanoTime() - startTim;
        
                long insertiontim = elapsedTim/1000;
                
                
                files = a.get();
                
                System.out.println("Size sorting from InsertionSort:");
                System.out.println("");
                
                for(int j = 0 ; j < files.length; j++){
                System.out.println(files[j]);}
        
                //insertion sort end wrt time
                //using mergesort
                
                files = input.listFiles();
                b = new MergeSort(files);
                
                startTim = System.nanoTime();
                b.sort(files, b.new bysize());
                elapsedTim = System.nanoTime() - startTim;
                
                
                files = b.get();
                
                System.out.println("");
                System.out.println("Size sorting from MergeSort:");
                System.out.println("");
                
                for(int k = 0 ; k < files.length; k++){
                    System.out.println(files[k]);}
                
                System.out.println("");
                System.out.println("Insertionsort = " +  insertiontim + " microseconds.");
                System.out.println("Mergesort = " +  elapsedTim/1000 + " microseconds.");
                
                break;           
        }
    }
        

    private static void insertionSort(File[] files) {
        
        int N = files.length;
        for (int i = 0; i < N; i++)
            for (int j = i; j > 0; j--)
                if (files[j].compareTo(files[j-1]) < 0)
                    exch(files, j, j-1);
                else break;
    }
    
    private static void exch(Comparable[] a, int i, int j){
        Comparable swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }
    
    
    
}
