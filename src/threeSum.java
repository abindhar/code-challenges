public class threeSum {
    public List<List<Integer>> solution(int[] nums) {
        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        for (int i=0; i<n-2; i++){
            if (i>0 && nums[i]==nums[i-1])
                // Avoid duplicates
                continue;
            int left = i+1, right = n-1;
            while (left<right) {
                if (nums[left]+nums[right]+nums[i] == 0){
                    ans.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    // Find next unique left and right
                    while (left<right && nums[left]==nums[left+1]) left+=1;
                    while (left<right && nums[right]==nums[right-1]) right-=1;
                    left+=1;
                    right-=1;
                } else if (nums[left]+nums[right]+nums[i] < 0) left += 1;
                else right -= 1;
            }
        }
        return ans;

    }
}
