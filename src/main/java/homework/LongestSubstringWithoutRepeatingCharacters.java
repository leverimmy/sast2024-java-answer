package homework;

import java.util.Arrays;
import java.util.Scanner;

public class LongestSubstringWithoutRepeatingCharacters {
    public static int lengthOfLongestSubstring(String s) {
        int n = s.length(), ans = 0;
        // TODO begin
        int[] last_occ = new int[Character.MAX_VALUE];

        Arrays.fill(last_occ, -1);

        int best_i = -1;
        for (int i = 0; i < n; i++) {
            best_i = Math.max(best_i, last_occ[s.charAt(i)]);
            last_occ[s.charAt(i)] = i;
            ans = Math.max(ans, i - best_i);
        }
        // TODO end
        return ans;
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the string: ");
        String s = input.nextLine();
        System.out.println(lengthOfLongestSubstring(s));
    }
}
