import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class absoluteSort {
    /*Sort based on absolute value
    [-4,2,-2,3] => [-2,2,3,4]
    */
    class AbsSort implements Comparator<Integer> {
        public int compare(Integer a, Integer b){
            if (Math.abs(a) == Math.abs(b)){
                // -2, 2
                return a-b;
            } else{
                return Math.abs(a) - Math.abs(b);
            }
        }
    }
    public Integer[] sortAbs(int[] arr){
        // Convert primitive array to array of object refs
        Integer[] arrObjs = new Integer[arr.length];
        for (int i=0; i<arr.length; i++){
            arrObjs[i] = Integer.valueOf(arr[i]);
        }
        // Create a custom Sorting object
        AbsSort cmp = new AbsSort();
        // Sort based on custom comparator
        Arrays.sort(arrObjs, cmp);
        // Reverse order based on your comparator
        // Arrays.sort(arrObjs, Collections.reverseOrder(cmp));
        return arrObjs;
    }
    public static void main(String[] args){
        int[] arr = {-7,1,0,-1,-2,1,-2,4,20,-100,2};
        absoluteSort sol = new absoluteSort();
        Integer[] arrObjs = sol.sortAbs(arr);
        for(Integer x : arrObjs) System.out.print(x+" ");
    }
}
