/**
 * 213.打家劫舍问题
 * */

package LeetcodeJava;

public class Rob2{
	public int rob(int[] nums) {
		int n = nums.length;

		if (n == 0){
			return 0;
		}

		if (n == 1){
			return nums[0];
		}

		//双向：[0:n-1]，[1,:n]，再比较大小
	    int prevMax = 0;
	    int currMax = 0;
	    int temp;
	    for (int i=0; i < nums.length-1; i++) {
	        temp = currMax;
	        currMax = Math.max(prevMax + nums[i], currMax);
	        prevMax = temp;
	    	}
	    int queMax=currMax;

	    prevMax = 0;
	    currMax = 0;
	    for (int i=1; i < nums.length; i++) {
	        temp = currMax;
	        currMax = Math.max(prevMax + nums[i], currMax);
	        prevMax = temp;
	    	}

	    return Math.max(currMax,queMax);
	}

    public static void main(String[] args) {
    	// int[] nums = new int[]{2,1,4,5,3,1,1,3};
    	int[] nums = new int[]{2,1,1,2};
    	// int[] nums = new int[]{1,2,3,4,0,2,6,9};

    	Rob2 r = new Rob2();
    	int ans = r.rob(nums);
    	System.out.println(ans);
    }
}

