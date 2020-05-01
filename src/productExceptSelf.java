public class productExceptSelf {
    public int[] prodExceptSelf(int[] nums) {
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
}
