public class MaxConsecutiveOnesIII {
    public static void main(String[] args){
        int nums [] ={1,1,1,0,0,0,1,1,1,1,0};
        int k = 2;
        System.out.println(longestOnes(nums,k));
    }
    
    static int longestOnes(int[] nums, int k) {
        int left =0;
        int right =0;
       int count =0;
        int maxCount= 0;
        int res = 0;
        while(right<nums.length){
            if(nums[right]==1){
                count++;
            }
            maxCount = Math.max(count,maxCount);
            int length = right - left+1;
            if(length - maxCount > k){
                if(nums[left]==1){
                    count--;
                }
                left++;
            }

            res = Math.max((right - left +1),res);
            right++;
        }
        return res;
    }

}
