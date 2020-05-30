public class missingRanges {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> ans = new ArrayList<>();
        int n = nums.length;
        if (nums==null || n==0){
            ans.add(formRange(lower, upper));
            return ans;
        }
        // Case 1
        if (nums[0]>lower)
            ans.add(formRange(lower, nums[0]-1));

        // Case 2
        for (int i=0; i<n-1; i++){

            if (nums[i+1]!=nums[i] && nums[i+1]>nums[i]+1)
                ans.add(formRange(nums[i]+1, nums[i+1]-1));
        }

        // Case 3
        if (nums[n-1]<upper)
            ans.add(formRange(nums[n-1]+1, upper));

        return ans;

    }

    public String formRange(int x, int y){
        // x=1 y=1 returns "1"
        // x=1 y=3 returns "1->3"
        return x!=y ? (String.valueOf(x)+"->"+String.valueOf(y)) : String.valueOf(x);
    }
}
