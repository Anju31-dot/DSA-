class NumArray {
    int [] seg ;
    int n;

    public NumArray(int[] nums) {
        n= nums.length;
        seg = new int[4*n];
        build(0,0,n-1,nums);   
    }
    public void build (int index , int start , int end , int[] nums){
        if(start == end ){
            seg[index]= nums[start];
            return;
        }
        int mid = (start + end)/2;
        build(2*index +1,start, mid , nums);
        build(2*index +2 , mid+1 , end, nums);
        seg [index] = seg[2*index +1] + seg[2*index +2];
    }
    
    public void update(int index, int val) {
        updatehelper(0,0,n-1,index,val);
        
    }
    public void updatehelper(int i , int start , int end , int index, int val){
        if(start == end){
            seg [i]= val;
            return;
        }
        int mid = (start +end)/2;
        if(index <= mid){
            updatehelper(2*i+1, start , mid , index, val);
        }
        else updatehelper(2*i+2 , mid +1, end , index , val);
        seg[i] = seg[2*i+1] + seg[2*i +2];
    }
    
    public int sumRange(int left, int right) {
        return query(0,0,n-1, left , right);
    }
    public int query(int index , int start , int end , int left , int right){
        if(right < start || left > end) return 0;
        if(left <= start && right >= end) return seg[index];
        int mid = (start + end)/2;
        int leftsum = query(2*index+1,start , mid , left , right);
        int rightsum = query(2*index +2, mid +1, end , left , right);
        return leftsum + rightsum;
        
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */