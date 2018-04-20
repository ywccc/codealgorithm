class Solution {
    public int findDuplicate(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int fast = 0;
        int slow = 0;
        while(nums[slow] != nums[nums[fast]])
        {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        fast = nums[slow];
        slow = 0;
        while(nums[slow] != nums[fast])
        {
            slow = nums[slow];
            fast = nums[fast];
        }
        slow = nums[slow];
        return slow;
    }
}