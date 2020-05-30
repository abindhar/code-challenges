import java.util.ArrayList;
import java.util.List;

public class summaryRanges {
    public List<String> getSummaryRanges(int[] nums) {
        List<String> ans = new ArrayList<>();
        if (nums == null || nums.length==0)
            return ans;
        int left = 0; // pointer to start of current range
        for (int i=0; i<nums.length-1; i++){
            if (! (nums[i+1]==nums[i]+1)){
                ans.add(formRange(nums[left], nums[i]));
                left = i+1;
            }
        }
        // Last element check
        ans.add(formRange(nums[left], nums[nums.length-1]));
        return ans;
    }
    public String formRange(int x, int y){
        return x!=y ? String.valueOf(x)+"->"+String.valueOf(y) : String.valueOf(x);
    }
}
