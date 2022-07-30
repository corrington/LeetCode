public class RotateArray {
    // In this solution, I simply create a second array and then
    // copy the two sub-ranges into the new array, and then finally
    // copy the new array back into the source  array
    public void rotate1a(final int[] nums, final int k) {
        if ((nums == null) || (nums.length < 2)) return;

        // if k is larger than our array, wraparound
        int rotations = k % nums.length;
        if (rotations == 0) return;

        int[] newNums = new int[nums.length];

        // copy the first substring
        for (int i = 0, j = rotations; j < nums.length; i++, j++) {
            newNums[j] = nums[i];
        }

        // copy the second substring
        for (int i = nums.length - rotations, j = 0; i < nums.length; i++, j++) {
            newNums[j] = nums[i];
        }

        // copy everything back into nums
        System.arraycopy(newNums, 0, nums, 0, nums.length);

    } // rotate1a()


    // This solution is a variation on the first, Rotate1a()
    // In the previous solution I copied everything into a  new array,
    // then copied everything from the new array back to the original array.
    // In this solution, I copy only the elements I need to preserve that
    // would be overwritten.  In short, less memory required and fewer elements copied.
    public void rotate1b(final int[] nums, final int k) {
        if ((nums == null) || (nums.length < 2)) return;

        // if k is larger than our array, wraparound
        int rotations = k % nums.length;
        if (rotations == 0) return;

        int[] savedNums = new int[rotations];

        // copy only the elements we need to preserve
        for (int i = nums.length - rotations, j = 0; i < nums.length; i++, j++) {
            savedNums[j] = nums[i];
        } // for i

        // now copy the remaining elements into their correct locations (right-to-left)
        for (int i = nums.length - rotations - 1, j = nums.length - 1; i >= 0; i--, j--) {
            nums[j] = nums[i];
        } // for i

        // Finally, copy only the preserved elements back into the original array
        // for i
        System.arraycopy(savedNums, 0, nums, 0, savedNums.length);

    } // rotate1b()


    // Below is an "in-place" solution.
    // If k is less than half of the array length, it's faster to rotate
    // the array (one element at a time) to the right.
    // Otherwise, it's faster to rotate the elements to the left.
    // for example, let's assume {1,2,3,4,5,6} with k = 5.
    // To get the correct configuration, we would have to rotate the array
    // five times to the right OR simply rotate it one time to the left.
    // Using this bidirectional approach, the max number of rotations is k / 2.
    public void rotate2a(final int[] nums, final int k) {
        if ((nums == null) || (nums.length < 2)) return;

        // if k is larger than our array, wraparound
        int rotations = k % nums.length;
        if (rotations == 0) return;

        // if k is small, we can rotate to the right
        if (rotations < (nums.length / 2)) {
            // rotate the array k times to the right
            for (int r = 0; r < rotations; r++) {
                // save the last number
                int lastNum = nums[nums.length - 1];
                // copy the other numbers
                System.arraycopy(nums, 0, nums, 1, nums.length - 1);
                // put the previously last number at the start of the array
                nums[0] = lastNum;
            } // for rotations

        } else {
            // if k is big, it's more efficient to rotate to the left
            rotations = (nums.length - rotations);
            // rotate the array k times to the left
            for (int r = 0; r < rotations; r++) {
                // save the first number
                int firstNum = nums[0];
                // copy the other numbers
                System.arraycopy(nums, 1, nums, 0, nums.length - 1);
                // put the previously last number at the start of the array
                nums[nums.length - 1] = firstNum;
            } // for rotations
        } // if

    } // rotate2a()


    // Here's another "in-place solution" that does NOT require a second array.
    // Let's start with the following:
    //       {1, 2, 3, 4, 5, 6, 7, 8, 9} and k = 3
    // First we reverse the entire string:
    //       {9, 8, 7, 6, 5, 4, 3, 2, 1}
    // Then we reverse just the pre-k numbers (the first three numbers)
    //       {7, 8, 9, 6, 5, 4, 3, 2, 1}
    // Then we reverse just the post-k numbers (the last five numbers)
    //       {7, 8, 9, 1, 2, 3, 4, 5, 6}
    // and we're done.
    public void rotate3(final int[] nums, final int k) {
        if ((nums == null) || (nums.length < 2)) return;

        // if k is larger than our array, wraparound
        int rotations = k % nums.length;
        if (rotations == 0) return;
        //System.out.println(Arrays.toString(nums) + " initial");               // DEBUG

        // reverse the entire array
        int startingIndex = 0;
        int endingIndex = nums.length -1;
        reverseSubset(nums, startingIndex, endingIndex);
        //System.out.println(Arrays.toString(nums) + " after reverse all" );    // DEBUG

        // reverse just the pre-k numbers
        //startingIndex = 0;
        endingIndex = rotations - 1;
        reverseSubset(nums, startingIndex, endingIndex);
        //System.out.println(Arrays.toString(nums) + " after reverse pre-k");   // DEBUG

        // reverse just the post-k numbers
        startingIndex = rotations;
        endingIndex = nums.length - 1;
        reverseSubset(nums, startingIndex, endingIndex);
        //System.out.println(Arrays.toString(nums) + " after reverse post-k");  // DEBUG

    } // rotate3()

    // Reverses a subset of the elements in an array
    // Swap elements from each end, then advance towards the middle.
    // Continue swapping and advancing until we reach the middle.
    void reverseSubset(int[] nums, int startingIndex, int endingIndex) {
        int midPoint = ((startingIndex + endingIndex) / 2) + 1;
        for (int front = startingIndex, back = endingIndex; front < midPoint; front++, back--) {
            swapElements(nums, front, back);
        } // for
    } // reverseSubset()

    // Simply swaps two elements in an array
    void swapElements(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    } // swap()



    public static void main(String[] args) {
        var p = new RotateArray();

        int[] nums = {1,2,3,4,5,6,7};
        //System.out.println(Arrays.toString(nums));
        p.rotate3(nums,3);
        //System.out.println(Arrays.toString(nums));

    } // main()

} // class RotateArray
