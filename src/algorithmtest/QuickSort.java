/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithmtest;

/**
 *
 * @author Erik
 */
public class QuickSort {
    
    int[] array;
            
    public int[] sort(int[] _array){
        if(_array.length ==0 || _array == null){
            return null;
        }
        array = _array;
        OneQuickSort(0,array.length-1);
        return array;
        
    }
    
    public void OneQuickSort(int _start, int _end){
        System.out.println("Enter a quick sort process... Start with "+ _start+", ends with "+_end);
        int temp;
        int start = _start;
        int end = _end;
        int pivot = array[_start + (_end - _start)/2];
        
        while(start <= end){
            //while(array[start] < array[pivot2]){
            while(array[start] < pivot){
                start++;
            }
                
            //while(array[end] > array[pivot2]){
            while(array[end] > pivot){
                end--;
            }
                if(start <= end){
                    temp = array[start];
                    array[start] = array[end];
                    array[end] = temp;
                    start++;
                    end--;
                    System.out.print("L->R ");
                    showArray(array);
                }
        }        
        if(_start < end){
            OneQuickSort(_start,end);
        }
        
        if(start < _end){
            OneQuickSort(start,_end);
        }
    }
    
        private static void showArray(int[] _array){
        for(int t=0;t<_array.length;t++){
            System.out.print(_array[t]+",");
        }
        System.out.print("**");
        System.out.println();
    }
}
