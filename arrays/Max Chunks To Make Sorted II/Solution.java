class Solution {
    public int maxChunksToSorted(int[] arr) {
        if(arr == null || arr.length == 0) return 0;
        if(arr.length == 1) return 1;
        int[] left = new int[arr.length];
        int[] right = new int[arr.length];
        
        left[0] = arr[0];
        for(int i = 1; i < arr.length; ++i)
        {
            left[i] = Math.max(arr[i],left[i-1]);
        }
        
        right[arr.length-1] = arr[arr.length-1];
        for(int i = arr.length-2; i >= 0; --i)
        {
            right[i] = Math.min(arr[i],right[i+1]);
        }
        int res = 0;
        for(int i = 0; i < arr.length-1; ++i)
        {
            if(left[i] <= right[i+1]) ++res;
        }
        return res+1;
    }
}
