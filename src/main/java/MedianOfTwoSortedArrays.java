import java.util.Arrays;

public class MedianOfTwoSortedArrays {

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {

        if ((nums1 == null) || (nums2 == null)) return 0.0;

        int[] mergedNums = new int[nums1.length + nums2.length];

        int i1 = 0, i2 = 0, im = 0;

        boolean isMerging = true;
        while (isMerging) {
            // if both input arrays have values...
            if ((i1 < nums1.length) && (i2 < nums2.length)) {
                // add them to the merged array in ascending order
                if (nums1[i1] < nums2[i2]) {
                    mergedNums[im++] = nums1[i1++];
                } else {
                    mergedNums[im++] = nums2[i2++];
                }
                // if only the first list still has values, copy them
            } else if (i1 < nums1.length) {
                mergedNums[im++] = nums1[i1++];
                // if only the second list still has values, copy them
            } else if (i2 < nums2.length) {
                mergedNums[im++] = nums2[i2++];
            } else {
                // if both lists are empty, we are done.
                isMerging = false;
            }
        } // while

        System.out.println(Arrays.toString(nums1));
        System.out.println(Arrays.toString(nums2));
        System.out.println(Arrays.toString(mergedNums));


        if (mergedNums.length == 1)
            return mergedNums[0];

        double result;
        int mid = mergedNums.length / 2;
        if ((mergedNums.length % 2) == 1) {
            result = mergedNums[mid];
        } else {
            result = (mergedNums[mid-1] + mergedNums[mid]) / 2.0;
        }

        return result;

    } // findMedianSortedArrays()

    public static void main(String[] args) {

        //List<Integer> list = fixedSizeList(new int[] {1,2,3});
        System.out.printf("median is %f\n\n", findMedianSortedArrays(new int[] {1,3}, new int[] {2}));
        System.out.printf("median is %f\n\n", findMedianSortedArrays(new int[] {1,2}, new int[] {3,4}));
        System.out.printf("median is %f\n\n", findMedianSortedArrays(new int[] {0,0}, new int[] {0,0}));
        System.out.printf("median is %f\n\n", findMedianSortedArrays(new int[] {}, new int[] {1}));
        System.out.printf("median is %f\n\n", findMedianSortedArrays(new int[] {2}, new int[] {}));
        System.out.printf("median is %f\n\n", findMedianSortedArrays(new int[] {-4,-2,0,2,4,6,8}, new int[] {-5,-3,-1,1,3,5,7,9}));
        System.out.printf("median is %f\n\n", findMedianSortedArrays(new int[] {-4,-2,0,2,4,6,8}, new int[] {-5,-2,-1,2,3,5,8,9}));
        System.out.printf("median is %f\n\n", findMedianSortedArrays(new int[] {}, new int[] {2,3}));
    } // main()
} // class MedianOfTwoSortedArrays
