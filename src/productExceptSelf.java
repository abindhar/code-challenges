public class productExceptSelf {
    //
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
        // Create two temp arrays such that the ans array is simply
        // ans[i] = left[i]*right[i]
        int n = nums.length;
        if (n==1) return nums;
        int[] left = new int[n];
        int[] right = new int[n];
        int[] ans = new int[n];
        left[0] = 1;
        for (int i=1; i<n; i++){
            // Accumulate product
            left[i] = nums[i-1] * left[i-1];
        }
        right[n-1] = 1;
        for (int j=n-2; j>=0; j--){
            right[j] = nums[j+1] * right[j+1];
        }
        for (int i=0; i<n; i++){
            ans[i] = left[i] * right[i];
        }
        return ans;
    }
}
