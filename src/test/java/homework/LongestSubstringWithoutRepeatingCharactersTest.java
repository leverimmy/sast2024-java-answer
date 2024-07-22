package homework;

import org.junit.jupiter.api.Test;

import static homework.LongestSubstringWithoutRepeatingCharacters.lengthOfLongestSubstring;
import static org.junit.jupiter.api.Assertions.*;

class LongestSubstringWithoutRepeatingCharactersTest {

    @Test
    void testLengthOfLongestSubstring() {
        // Test case 1: Normal string with repeating characters
        assertEquals(3, lengthOfLongestSubstring("ABCABCBB"), "Test case 1 failed");

        // Test case 2: Empty string
        assertEquals(0, lengthOfLongestSubstring(""), "Test case 2 failed");

        // Test case 3: String with all unique characters
        assertEquals(5, lengthOfLongestSubstring("ABCDE"), "Test case 3 failed");

        // Test case 4: String with all the same character
        assertEquals(1, lengthOfLongestSubstring("aaaaa"), "Test case 4 failed");

        // Test case 5: String with special characters
        assertEquals(5, lengthOfLongestSubstring("!@#$%"), "Test case 5 failed");

        // Test case 6: String with numbers
        assertEquals(10, lengthOfLongestSubstring("12345678901"), "Test case 6 failed");

        // Test case 7: String with mixed characters and numbers
        assertEquals(9, lengthOfLongestSubstring("abc123xyz"), "Test case 7 failed");

        // Test case 8: Long string with no repeating characters
        assertEquals(6, lengthOfLongestSubstring("abcdef".repeat(100) + "a"), "Test case 8 failed");

        // Test case 9: Long string with all characters repeating
        assertEquals(1, lengthOfLongestSubstring("aaa".repeat(1000)), "Test case 9 failed");

        // Test case 10: String with a space
        assertEquals(1, lengthOfLongestSubstring(" "), "Test case 10 failed");
    }
}
