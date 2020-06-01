public class flatten2DVector {
    int[][] vector;
    int outer = 0, inner = 0; // index of outer and nested inner array
    public flatten2DVector(int[][] v) {
        vector = v;
    }

    public int next() {
        moveToNext();
        int ans = vector[outer][inner];
        inner++;
        return ans;

    }

    public boolean hasNext() {
        moveToNext();
        return outer < vector.length;
    }

    public void moveToNext(){
        /* If current outer and inner point to a bad location move it to an integer location
         */
        while (outer<vector.length && inner >= vector[outer].length){
            outer++;
            inner = 0;
        }
    }

    public void print(int[][] v){
        for (int[] x : v){
            System.out.println(Arrays.toString(x));
        }
    }
}

