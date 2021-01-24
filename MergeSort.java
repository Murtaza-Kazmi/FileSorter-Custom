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
public class MergeSort {
private final File[] files;

    public MergeSort(File[] f) {
        files = new File[f.length];
        for(int i = 0; i < f.length; i++){
            files[i] = f[i];
        }
    }

    File[] get() {
        return files;
    }

    
    private static void merge(Object[] a, Object[] aux, Comparator comp,int lo, int mid, int hi){
            for (int k = lo; k <= hi; k++)
            aux[k] = a[k];
            int i = lo, j = mid+1;
            for (int k = lo; k <= hi; k++){
            if (i > mid) a[k] = aux[j++];
            else if (j > hi) a[k] = aux[i++];
            else if (comp.compare(aux[j], aux[i])<0) a[k] = aux[j++];
            else a[k] = aux[i++];
            }
    }
    
    private static void sort(Object[] a, Object[] aux, Comparator comp, int lo, int hi){
            if (hi <= lo) return;
            int mid = lo + (hi - lo) / 2;
            sort(a, aux, comp, lo, mid);
            sort(a, aux,comp, mid+1, hi);
            merge(a, aux, comp, lo, mid, hi);
    }
    
    public void sort(File[] a, Comparator comp){
        
        File[] aux = new File[a.length];
        sort(a, aux, comp, 0, a.length - 1);
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

