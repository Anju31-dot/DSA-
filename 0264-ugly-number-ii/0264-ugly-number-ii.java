class Solution {
    public int nthUglyNumber(int n) {
        int[]arr = new int[n];
        arr[0]=1;
        int i2=0, i3=0, i5=0;
        for(int u =1;u<n;u++){
            int next2 = arr[i2]*2;
            int next3 = arr[i3]*3;
            int next5 = arr[i5]*5;
            int nextugly = Math.min(next2,Math.min(next3,next5));
            arr[u] = nextugly;
            if(nextugly == next2)i2++;
            if(nextugly == next3)i3++;
            if(nextugly == next5)i5++;

        }
        return arr[n-1];

    }
}
