public class productExceptSelf {
    public int[] solution(int[] nums) {
        //return nonOptimal(nums);

        /* The output array does not count as extra space!!
        Algo: Run through input array left->right, then right->left
        Collecting whatever product needs to go in
        Time: O(n) Space: O(1)
        */
        int n = nums.length;
        int[] ans = new int[n];
        for (int i=0; i<n; i++) {ans[i]=1;}
        int prod = 1;
        for (int j=0; j<n-1; j++){
            prod *= nums[j];
            ans[j+1] *= prod;
        }
        //System.out.println(Arrays.toString(ans));
        prod = 1;
        for (int j=n-1; j>0; j--){
            prod *= nums[j];
            ans[j-1] *= prod;
        }
        return ans;

    }
    public int[] nonOptimal(int[] nums) {
        // Create two tmp arrays to hold left accumulate and right accumulated products
        int n = nums.length;
        if (n==1) return nums;
        int[] left = new int[n];
        int[] right = new int[n];
        int[] ans = new int[n];
        int prod = 1;
        for (int i=0; i<n; i++){
            prod *= nums[i];
            left[i] = prod;
        }
        prod = 1;
        for (int j=n-1; j>=0; j--){
            prod *= nums[j];
            right[j] = prod;
        }
        ans[0] = right[1];
        for (int i=1; i<n-1; i++){
            ans[i] = left[i-1] * right[i+1];
        }
        ans[n-1] = left[n-2];
        return ans;
    }
}
