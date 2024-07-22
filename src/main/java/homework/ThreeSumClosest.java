package homework;

import java.util.Scanner;

public class ThreeSumClosest {
    public static int threeSumClosest(int[] nums, int target) {
        int n = nums.length, min_diff = Integer.MAX_VALUE, ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    int sum = nums[i] + nums[j] + nums[k];
                    if (Math.abs(sum - target) < min_diff) {
                        min_diff = Math.abs(sum - target);
                        ans = sum;
                    }
                }
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int size;
        System.out.println("Enter the size of the array:");
        size = input.nextInt();
        int[] nums = new int[size];
        System.out.print("Enter the array, separated by a space:");
        for (int i = 0; i < nums.length; i++) {
            nums[i] = input.nextInt();
        }
        System.out.println("Enter the target:");
        int target = input.nextInt();
        System.out.println(threeSumClosest(nums, target));
    }
}
