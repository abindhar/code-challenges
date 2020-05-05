import java.util.*;

public class threeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        //return hashSol(nums);
        /*Two pointers sol, O(n^2) time O(1) extra space
        */
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
                    List<Integer> tmp = Arrays.asList(nums[i], nums[left], nums[right]);
                    ans.add(tmp);
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

    public List<List<Integer>> hashSol(int[] nums){
        /* HashMap/Dictionary based solution
        [-2,0,0,1,1,2,2]
        0 -> target = -0 so, find x+y st x+y==0
        Use a set to compare the duplicate triplets
        */
        int n = nums.length;
        Set<List<Integer>> seen = new HashSet<>();
        List<List<Integer>> ans = new ArrayList<>();
        for (int i=0; i<n-2; i++){
            // nums[i] is fixed and you search from i+1 to end
            int target = -1 * nums[i];
            // Search
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int j=i+1; j<n; j++){
                if (map.containsKey(nums[j])){
                    // Found the triplet
                    // nums[j], map.get(nums[j]), -1*target
                    // Sort the triplet, make list and check not present in seen
                    List<Integer> triplet = new ArrayList<>(
                            Arrays.asList(nums[j], map.get(nums[j]), -1*target));
                    Collections.sort(triplet);
                    if (!seen.contains(triplet)){
                        //Unique triplet found, store in ans and add to seen set
                        ans.add(triplet);
                        seen.add(triplet);
                    }
                }
                else {
                    map.put(target-nums[j], nums[j]);
                }
            }
        }
        return ans;
    }
}
