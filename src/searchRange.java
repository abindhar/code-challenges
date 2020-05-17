public class searchRange {
    // #34 : Find First and Last Position of Element in Sorted Array
    public int[] Solution(int[] nums, int target) {
        int[] ans = new int[2];
        int lo = 0, hi = nums.length - 1;
        ans[0] = searchFirst(nums, target, lo, hi);
        ans[1] = searchLast(nums, target, lo, hi);
        return ans;
    }
    public int searchFirst(int[] nums, int target, int lo, int hi){
        // Returns the idx of first occurance of target if found
        // or -1 if target is not found
        // Based on bisect_left
        while (lo<=hi){
            int mid = lo + (hi-lo)/2;
            if (nums[mid]>=target)
                hi = mid-1;
            else
                lo = mid+1;
        }
        return (lo<nums.length && nums[lo]==target) ? lo : -1;
    }
    public int searchLast(int[] nums, int target, int lo, int hi){
        // Returns the idx of last occurance of target if found
        // or -1 if not found
        // Based on bisect_right algo
        while (lo<=hi){
            int mid = lo + (hi-lo)/2;
            if (nums[mid]<=target)
                lo = mid+1;
            else
                hi = mid-1;
        }
        return (hi>=0 && nums[hi]==target) ? hi : -1;
    }

}
