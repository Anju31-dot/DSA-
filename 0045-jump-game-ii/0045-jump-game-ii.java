class Solution {
    public int jump(int[] nums) {
        int jumps =0;
        int farthestEnd =0;
        int currentEnd =0;
        for(int i =0;i<nums.length-1;i++){
            farthestEnd = Math.max(farthestEnd , i + nums[i]);
            if(i== currentEnd){
                jumps++;
                currentEnd = farthestEnd;
            }
        }
        return jumps;
    }
}