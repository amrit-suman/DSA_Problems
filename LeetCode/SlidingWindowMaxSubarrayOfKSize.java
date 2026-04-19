package LeetCode;

public class SlidingWindowMaxSubarrayOfKSize {

    public static void main(String[] args) {
        // Test case: find maximum sum of subarray with size k=2 from [8819, 6177, 2113,
        // 1992]
        System.out.println(maxSubarraySum(new int[] { 8819, 6177, 2113, 1992 }, 2)); // Expected output: 14996
                                                                                     // (8819+6177)
    }

    public static int maxSubarraySum(int[] arr, int k) {
        // Use sliding window with fixed size k to find maximum sum subarray

        int low = 0; // Left boundary of sliding window, starts at beginning of array
        int high = low + k - 1; // Right boundary of sliding window, initially set to window size k
        int len = arr.length; // Store array length to avoid repeated method calls
        int max = 0; // Track maximum sum found across all windows
        int sum = 0; // Track cumulative sum of current window

        for (int i = 0; i <= high; i++) { // Calculate sum of first window by iterating from 0 to high (first k
                                          // elements)
            sum += arr[i]; // Add each element of initial window to sum
        }
        max = sum; // Initialize max with sum of first window

        while (high < len) { // Slide window: continue until right boundary reaches end of array

            max = Math.max(sum, max); // Update max if current window sum is larger than previous maximum
            low++; // Move left boundary right to slide window forward
            high++; // Move right boundary right to slide window forward

            if (high >= len) { // Check if right boundary has gone beyond array length
                break; // Exit loop to avoid out of bounds access
            }
            sum = sum - arr[low - 1] + arr[high]; // Remove leftmost element and add new rightmost element to maintain
                                                  // window sum
        }
        return max; // Return maximum sum found among all k
    }
}
