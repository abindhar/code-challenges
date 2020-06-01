import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class flatten2DList {
    Iterator<List<Integer>> outer;
    Iterator<Integer> inner;
    List<List<Integer>> vector;
    public flatten2DList(int[][] v){
        for (int i=0; i<v.length; i++){
            Integer[] row = new Integer[v[i].length];
            for (int j=0; j<v[i].length; j++)
                row[j] = v[i][j];
            vector.add(Arrays.asList(row));
        }
        if (vector == null || vector.size()==0)
            return;
        outer = vector.iterator();
        inner = outer.next().iterator();
    }

    public int next(){
        moveToValidIndex();
        int ans = inner.next();
        return ans;
    }
    public boolean hasNext(){
        moveToValidIndex();
        return inner.hasNext();
    }
    public void moveToValidIndex(){
        // Move the iterators to next integer
        while (!inner.hasNext() && outer.hasNext())
            inner = outer.next().iterator();
    }
    public static void main(String[] args){
        int[][] arr = {{1,2,3}, {4}, {},{},{},{5}};
        System.out.println(Arrays.toString(arr));
        flatten2DList it = new flatten2DList(arr);
        while (it.hasNext()){
            System.out.println(it.next());
        }
    }
}