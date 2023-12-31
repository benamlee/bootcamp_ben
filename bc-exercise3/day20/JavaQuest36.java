// Given an integer array nums of 2n integers, 
// group these integers into n pairs (a1, b1), (a2, b2), ..., (an, bn)
// such that the sum of min(ai, bi) for all i is maximized. 
// Return the maximized sum.

// Example 1:
// Input: nums = [1,4,3,2]
// Output: 4
// Explanation: All possible pairings (ignoring the ordering of elements) are:
// 1. (1, 4), (2, 3) -> min(1, 4) + min(2, 3) = 1 + 2 = 3
// 2. (1, 3), (2, 4) -> min(1, 3) + min(2, 4) = 1 + 2 = 3
// 3. (1, 2), (3, 4) -> min(1, 2) + min(3, 4) = 1 + 3 = 4
// So the maximum possible sum is 4.

// Example 2:
// Input: nums = [6,2,6,5,1,2]
// Output: 9
// Explanation: The optimal pairing is (2, 1), (2, 5), (6, 6). min(2, 1) + min(2, 5) + min(6, 6) = 1 + 2 + 6 = 9.
 
// Constraints:
// 1 <= n <= 104
// nums.length == 2 * n
// -104 <= nums[i] <= 104 

import java.util.Arrays;

public class JavaQuest36 {
  public static void main(String[] args) {
    System.out.println(arrayPairSum(new int[] { 1, 4, 3, 2 }));// output : 4
    System.out.println(arrayPairSum(new int[] { 6, 2, 6, 5, 1, 2 }));// output : 9
    System.out.println(arrayPairSum(new int[] { 5, 100, 200, 600, 999, 1 }));// output : 701

  }

  public static int arrayPairSum(int[] nums) {
    // code here
    int sum = 0;
    int j, temp;
    int[] arr = Arrays.copyOf(nums, nums.length); // keep original array not change
    for (int i = 1; i < arr.length; i++) {
      j = i;
      while (j > 0 && arr[j] < arr[j - 1]) {
        temp = arr[j];
        arr[j] = arr[j - 1];
        arr[j-- - 1] = temp;
      }
    }
    for (int i = 0; i < arr.length; i++) {
      sum += i % 2 == 0 ? arr[i] : 0;
    }
    return sum;
  }
}
