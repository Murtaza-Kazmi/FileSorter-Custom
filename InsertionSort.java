/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FileSorter;

import java.io.File;
import java.util.Comparator;

/**
 *
 * @author Murtaza Kazmi
 */
public class InsertionSort {
    private final File[] files;
    
    public InsertionSort(File[] f) {
        files = new File[f.length];
        for(int i = 0; i < f.length; i++){
            files[i] = f[i];
        }
    }

   
    public void sort(Object[] a, Comparator comparator){
        int N = a.length;
        for (int i = 0; i < N; i++)
            for (int j = i; j > 0 && comparator.compare(a[j], a[j-1]) < 0; j--)
                exch(a, j, j-1);
        }
        
        private void exch(Object[] a, int i, int j){
            Object swap = a[i];
            a[i] = a[j];
            a[j] = swap;
        }

     public File[] get(){
         return files;
     }
     
      class bydate implements Comparator<File>{

        @Override
        public int compare(File o1, File o2) {
            if (o1.lastModified() < o2.lastModified()) return -1;
            if(o1.lastModified() > o2.lastModified()) return +1;
            return 0;
        }
     }
        
         class bysize implements Comparator<File>{

        @Override
        public int compare(File o1, File o2) {
            if (o1.getTotalSpace() < o2.getTotalSpace()) return -1;
            if(o1.getTotalSpace() > o2.getTotalSpace()) return +1;
            return 0;
        }
         
     }

}
