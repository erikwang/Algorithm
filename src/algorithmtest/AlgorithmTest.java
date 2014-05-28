/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithmtest;
import java.util.*;

/**
 *
 * @author Erik
 */
public class AlgorithmTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println(">>>Generated array to sort: ");
        int[] array = getListToSort();
        showArray(array);
        System.out.println("***Sorted array is");
        
        //The sorting algorithm is a tuned quicksort, by JDK
        //Arrays.sort(array);
        
        int[] array2 = array;
        
        new QuickSort().sort(array);
        showArray(array);
        
        System.out.println("###############");
        
        new QuickDemo().sort(array2);
        showArray(array2);
        
        //search target emelemt int 20 in the array
        //System.out.println("Target element is: 20");
        //System.out.println("Entering search... The result place is:"+sortByBinary(array,20)+1);
        
    }
    
    
    
    private static int sortByBinary(int[] ascent_array,int target){
        int min = 0;
        int max  = ascent_array.length - 1;
        int mid;
        
        if (max < min) {
            throw new RuntimeException("array size exception");
        }
        
        while(max >= min ){
            mid = (max-min)/2 + min;
            if (ascent_array[mid] == target){
                return mid;
            }
            if (ascent_array[mid] > target){
                max = mid - 1;
            }else{
                min = mid + 1;
            }
        }
        throw new RuntimeException("The search item not found in the input array");
    }
    
    
    private static int[] getListToSort(){
        Random randomGenerator = new Random();
        int newrandom;
        int randomInt = randomGenerator.nextInt(100);
        int listtosort[] = new int[randomInt];
        System.out.println("Size is "+randomInt);
        for(int t=0;t<randomInt;t++){
            newrandom = randomGenerator.nextInt(100);
            if(newrandom == 0){
                System.out.println("#"+newrandom);
            }
            
            while(!checkDuplicated(listtosort,newrandom)){
                newrandom = randomGenerator.nextInt(100);
            }
            listtosort[t] = newrandom;
        }
        return listtosort;
    }
    
    
    private static void showArray(int[] _array){
        for(int t=0;t<_array.length;t++){
            System.out.print(_array[t]+",");
        }
        System.out.print("EOA");
        System.out.println();
    }
    
    
   private static boolean checkDuplicated(int[] _array, int newnumber){
       if (newnumber == 0){
           return false;
       }
       for(int t=0;t<_array.length;t++)
           if(newnumber == _array[t]){
               return false;
           }
       return true;
   
   }
}


