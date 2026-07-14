class Solution {
    public int maxArea(int[] height) {
        int res = 0;
        int left = 0;
        int right = height.length - 1;

        while(left < right){
            int l = height[left];
            int r = height[right];

            int area = Math.min(l,r) * (right - left);
            res = Math.max(res,area);

            if(l < r){
                left++;
            }else{
                right--;
            }
       }
       return res;
    }
}