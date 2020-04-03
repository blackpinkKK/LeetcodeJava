/**
 * 198.打家劫舍问题
 * */

package LeetcodeJava;

public class Rob{
	public int rob(int[] nums) {
		int n = nums.length;

		if (n == 0){
			return 0;
		}

		if (n == 1){
			return nums[0];
		}

	    int prevMax = 0;
	    int currMax = 0;
	    for (int x : nums) {
	        int temp = currMax;
	        currMax = Math.max(prevMax + x, currMax);
	        prevMax = temp;
	    	}
	    return currMax;
	}

    public static void main(String[] args) {
    	// int[] nums = new int[]{2,1,4,5,3,1,1,3};
    	int[] nums = new int[]{2,1,1,2};
    	// int[] nums = new int[]{1,2,3,4,0,2,6,9};

    	Rob r = new Rob();
    	int ans = r.rob(nums);
    	System.out.println(ans);
    }
}

