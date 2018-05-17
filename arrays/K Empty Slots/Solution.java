class Solution {
    public int kEmptySlots(int[] flowers, int k) {
        int[] nums = new int[flowers.length];
        for(int i = 0; i < flowers.length; ++i)
        {
            nums[flowers[i]-1] = i+1;
        }
        
        int left = 0;
        int right = k+1;
        int res = Integer.MAX_VALUE;
        for(int i = 1; right <= nums.length-1; ++i)
        {
            if(nums[i] > nums[left] && nums[i] > nums[right]) continue;
            
            if(i == right)
            {
                res = Math.min(res,Math.max(nums[left],nums[right]));
            }
            
            left = i;
            right = i+k+1;
        }
        return (res == Integer.MAX_VALUE)?-1:res;
    }
}
