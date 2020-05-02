public class threeSumSmaller {
    // Leet 259
    public int solution(int[] nums, int target) {
        // Major hint is O(n^2) runtime O(1) space
        // Sort + Two pointer + Special Trick to count number of triplets
        // [-2,-1,0,1,2,3] target=0
        // [-2,0,1,3] target=4
        int n = nums.length;
        Arrays.sort(nums);
        int ans = 0, sum = 0;
        for (int i=0; i<n-2; i++){
            int lo = i+1, hi = n-1;
            while (lo<hi) {
                sum = nums[i]+nums[lo]+nums[hi];
                if (sum < target){
                    // If nums[i]+nums[lo]+nums[hi]<target, then there are hi-lo
                    // number of triplets
                    ans += hi-lo;
                    // Increase lo and recheck if nums[i]+nums[lo]+nums[hi]<target
                    lo++;
                } else hi--;
            }
        }
        return ans;
    }
}
}
