/**
 * 17.16.打家劫舍问题
 */

package LeetcodeJava;

public class Massage{
	public int massage(int[] nums) {
		int n = nums.length;

		if (n == 0){
			return 0;
		}

		if (n == 1){
			return nums[0];
		}

		int a=0;
		int b=0;
		for (int i : nums){
			int c = Math.max(b,a+i);
			a = Math.max(a,b);
			b = c;
		}
		return Math.max(a,b);
    }

    public static void main(String[] args) {
    	// int[] nums = new int[]{2,1,4,5,3,1,1,3};
//    	 int[] nums = new int[]{2,1,1,2};
    	int[] nums = new int[]{1,2,3,4,0,2,6,9};

    	Massage m = new Massage();
    	int ans = m.massage(nums);
    	System.out.println(ans);
    }
}