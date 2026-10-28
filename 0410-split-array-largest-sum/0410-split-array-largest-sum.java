class Solution {
    public int splitArray(int[] nums, int k){
        int ans =0;
        int max =nums[0];
        int total =0;
        for(int i =0;i<nums.length;i++){
            if(nums[i]> max){
                max = nums[i];
            }
            total +=nums[i];
        }
        int low = max;
        int high = total;
        while(low <= high){
            int mid = low + (high - low )/2;
            int currentsum =0;
            int count =1;
            for(int num : nums){
                if(currentsum + num <=mid){
                    currentsum += num;
                }
                else{
                    count++;
                    currentsum = num;

                }
            }
            if(count <= k){
                ans = mid;
                high = mid-1;

            }
            else{
                low = mid +1;
            }
        }
        return ans;
    }
}