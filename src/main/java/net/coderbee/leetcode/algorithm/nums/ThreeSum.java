package net.coderbee.leetcode.algorithm.nums;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 15. 三数之和
 * 
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0
 * 且不重复的三元组。
 * 
 * 注意：答案中不可以包含重复的三元组。
 * 
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/3sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class ThreeSum {

	public static List<List<Integer>> threeSum(int[] nums) {
	    List<List<Integer>> rs = new LinkedList<>();
	    Arrays.sort(nums);

	    // 至少有三个元素、如果第一个元素就大于 0 则肯定没有满足条件的组合
	    for(int i = 0; i < nums.length - 2 && nums[i] <= 0; i++) {
	        // 两层循环，如果元素与前值相同，则要跳过以去重。
	        if (i == 0 || nums[i] != nums[i - 1]) {
	            for(int left = i + 1, right = nums.length - 1; left < right;) {
	                if (left == i + 1 || nums[left] != nums[left - 1]) {
	                    int sum = nums[i] + nums[left] + nums[right];
	                    if (sum == 0) {
	                        rs.add(Arrays.asList(nums[i], nums[left], nums[right]));
	                        // 找到目标组合，左右指针相向移动，去重由循环控制
	                        left--;
	                        right++;
	                    } else if (sum < 0) {
	                        left++; // 左侧元素太小，右移左指针
	                    } else {
	                        right++; // 右侧元素太多，左移右指针
	                    }
	                }
	            }
	        }
	    }

	    return rs;
	}

}
