package homework;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ThreeSumClosestTest {

    @Test
    void testThreeSumClosest() {
        // Test case 1: Example 1 from the problem statement
        assertEquals(2, ThreeSumClosest.threeSumClosest(new int[]{-1, 2, 1, -4}, 1), "Test case 1 failed");

        // Test case 2: Example 2 from the problem statement
        assertEquals(0, ThreeSumClosest.threeSumClosest(new int[]{0, 0, 0}, 1), "Test case 2 failed");

        // Test case 3: Array with negative numbers
        assertEquals(-15, ThreeSumClosest.threeSumClosest(new int[]{-7, -6, -5, -4}, -11), "Test case 3 failed");

        // Test case 4: Array with positive numbers
        assertEquals(12, ThreeSumClosest.threeSumClosest(new int[]{3, 4, 5, 6, 7}, 9), "Test case 4 failed");

        // Test case 5: Array with a mix of negative and positive numbers
        assertEquals(3, ThreeSumClosest.threeSumClosest(new int[]{1, 2, -3, 4, -5}, 4), "Test case 5 failed");

        // Test case 6: Array with zeros
        assertEquals(6, ThreeSumClosest.threeSumClosest(new int[]{0, 0, 0, 6}, 6), "Test case 6 failed");

        // Test case 7: Array with all numbers equal
        assertEquals(9, ThreeSumClosest.threeSumClosest(new int[]{3, 3, 3, 3, 3}, 9), "Test case 7 failed");

        // Test case 8: Array with large numbers
        assertEquals(2103, ThreeSumClosest.threeSumClosest(new int[]{700, 701, 702, 703, 704}, 1406), "Test case 8 failed");

        // Test case 9: Array with small numbers close to the target
        assertEquals(7, ThreeSumClosest.threeSumClosest(new int[]{1, 2, 3, 4, 5, 6}, 7), "Test case 9 failed");

        // Test case 10: Array with one number far from others
        assertEquals(7, ThreeSumClosest.threeSumClosest(new int[]{1, 2, 3, 4, 100}, 7), "Test case 10 failed");
    }
}
