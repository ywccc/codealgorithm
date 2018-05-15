class Solution {
    public void sortColors(int[] nums) {
        if(nums == null || nums.length <= 1) return;
        int i = 0;
        int j = nums.length-1;
        for(int k = 0; k <= j; ++k)
        {
            if(nums[k] == 0)
            {
                int tmp = nums[i];
                nums[i] = 0;
                nums[k] = tmp;
                ++i;
            }
            else if(nums[k] == 2)
            {
                int tmp = nums[j];
                nums[j] = 2;
                nums[k] = tmp;
                --j;
                --k;
            }
        }
    }
}
