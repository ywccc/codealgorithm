class Solution {
    public int findUnsortedSubarray(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        if(nums.length == 1) return 0;
        int max = nums[0];
        int min = nums[nums.length-1];
        int e = 0;
        int s = nums.length-1;
        int n = nums.length;
        for(int i = 1; i < nums.length; ++i)
        {
            max = Math.max(nums[i],max);
            min = Math.min(nums[n-i-1],min);
            if(max > nums[i]) e = i;
            if(min < nums[n-i-1]) s = n-i-1;
        }
        return (e>s)?e-s+1:0;
    }
}
