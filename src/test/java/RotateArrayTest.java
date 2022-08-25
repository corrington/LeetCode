import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class RotateArrayTest {

    @Test
    void testRotate1a() {
        var p = new RotateArray();

        int[] nums1 = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] numsExp1 = {9, 1, 2, 3, 4, 5, 6, 7, 8};
        p.rotate1a(nums1, 1);
        assertArrayEquals(numsExp1, nums1);

        int[] nums2 = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] numsExp2 = {8, 9, 1, 2, 3, 4, 5, 6, 7};
        p.rotate1a(nums2, 2);
        assertArrayEquals(numsExp2, nums2);

        int[] nums3 = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] numsExp3 = {7, 8, 9, 1, 2, 3, 4, 5, 6};
        p.rotate1a(nums3, 3);
        assertArrayEquals(numsExp3, nums3);

        int[] nums4 = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] numsExp4 = {6, 7, 8, 9, 1, 2, 3, 4, 5};
        p.rotate1a(nums4, 4);
        assertArrayEquals(numsExp4, nums4);

        int[] nums5 = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] numsExp5 = {5, 6, 7, 8, 9, 1, 2, 3, 4};
        p.rotate1a(nums5, 5);
        assertArrayEquals(numsExp5, nums5);

        int[] nums6 = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] numsExp6 = {4, 5, 6, 7, 8, 9, 1, 2, 3,};
        p.rotate1a(nums6, 6);
        assertArrayEquals(numsExp6, nums6);

        int[] nums7 = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] numsExp7 = {3, 4, 5, 6, 7, 8, 9, 1, 2};
        p.rotate1a(nums7, 7);
        assertArrayEquals(numsExp7, nums7);

        int[] nums8 = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] numsExp8 = {2, 3, 4, 5, 6, 7, 8, 9, 1};
        p.rotate1a(nums8, 8);
        assertArrayEquals(numsExp8, nums8);

        int[] nums9 = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] numsExp9 = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        p.rotate1a(nums9, 9);
        assertArrayEquals(numsExp9, nums9);

        int[] nums10 = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] numsExp10 = {9, 1, 2, 3, 4, 5, 6, 7, 8};
        p.rotate1a(nums10, 10);
        assertArrayEquals(numsExp10, nums10);

        int[] nums11 = {};
        int[] numsExp11 = {};
        p.rotate1a(nums11, 10);
        assertArrayEquals(numsExp11, nums11);

        int[] nums12 = {1};
        int[] numsExp12 = {1};
        p.rotate1a(nums12, 10);
        assertArrayEquals(numsExp12, nums12);

        int[] nums13 = {1};
        int[] numsExp13 = {1};
        p.rotate1a(nums13, 0);
        assertArrayEquals(numsExp13, nums13);

        int[] nums14 = {1, 2};
        int[] numsExp14 = {2, 1};
        p.rotate1a(nums14, 3);
        assertArrayEquals(numsExp14, nums14);

    } // testRotate1a()

    @Test
    void testRotate1b() {
        var p = new RotateArray();

        int[] nums1 = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] numsExp1 = {9, 1, 2, 3, 4, 5, 6, 7, 8};
        p.rotate1b(nums1, 1);
        assertArrayEquals(numsExp1, nums1);

        int[] nums2 = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] numsExp2 = {8, 9, 1, 2, 3, 4, 5, 6, 7};
        p.rotate1b(nums2, 2);
        assertArrayEquals(numsExp2, nums2);

        int[] nums3 = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] numsExp3 = {7, 8, 9, 1, 2, 3, 4, 5, 6};
        p.rotate1b(nums3, 3);
        assertArrayEquals(numsExp3, nums3);

        int[] nums4 = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] numsExp4 = {6, 7, 8, 9, 1, 2, 3, 4, 5};
        p.rotate1b(nums4, 4);
        assertArrayEquals(numsExp4, nums4);

        int[] nums5 = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] numsExp5 = {5, 6, 7, 8, 9, 1, 2, 3, 4};
        p.rotate1b(nums5, 5);
        assertArrayEquals(numsExp5, nums5);

        int[] nums6 = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] numsExp6 = {4, 5, 6, 7, 8, 9, 1, 2, 3,};
        p.rotate1b(nums6, 6);
        assertArrayEquals(numsExp6, nums6);

        int[] nums7 = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] numsExp7 = {3, 4, 5, 6, 7, 8, 9, 1, 2};
        p.rotate1b(nums7, 7);
        assertArrayEquals(numsExp7, nums7);

        int[] nums8 = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] numsExp8 = {2, 3, 4, 5, 6, 7, 8, 9, 1};
        p.rotate1b(nums8, 8);
        assertArrayEquals(numsExp8, nums8);

        int[] nums9 = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] numsExp9 = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        p.rotate1b(nums9, 9);
        assertArrayEquals(numsExp9, nums9);

        int[] nums10 = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] numsExp10 = {9, 1, 2, 3, 4, 5, 6, 7, 8};
        p.rotate1b(nums10, 10);
        assertArrayEquals(numsExp10, nums10);

        int[] nums11 = {};
        int[] numsExp11 = {};
        p.rotate1b(nums11, 10);
        assertArrayEquals(numsExp11, nums11);

        int[] nums12 = {1};
        int[] numsExp12 = {1};
        p.rotate1b(nums12, 10);
        assertArrayEquals(numsExp12, nums12);

        int[] nums13 = {1};
        int[] numsExp13 = {1};
        p.rotate1b(nums13, 0);
        assertArrayEquals(numsExp13, nums13);

        int[] nums14 = {1, 2};
        int[] numsExp14 = {2, 1};
        p.rotate1b(nums14, 3);
        assertArrayEquals(numsExp14, nums14);

    } // testRotate1b()

    @Test
    void testRotate2a() {
        var p = new RotateArray();

        int[] nums1 = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] numsExp1 = {9, 1, 2, 3, 4, 5, 6, 7, 8};
        p.rotate2a(nums1, 1);
        assertArrayEquals(numsExp1, nums1);

        int[] nums2 = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] numsExp2 = {8, 9, 1, 2, 3, 4, 5, 6, 7};
        p.rotate2a(nums2, 2);
        assertArrayEquals(numsExp2, nums2);

        int[] nums3 = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] numsExp3 = {7, 8, 9, 1, 2, 3, 4, 5, 6};
        p.rotate2a(nums3, 3);
        assertArrayEquals(numsExp3, nums3);

        int[] nums4 = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] numsExp4 = {6, 7, 8, 9, 1, 2, 3, 4, 5};
        p.rotate2a(nums4, 4);
        assertArrayEquals(numsExp4, nums4);

        int[] nums5 = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] numsExp5 = {5, 6, 7, 8, 9, 1, 2, 3, 4};
        p.rotate2a(nums5, 5);
        assertArrayEquals(numsExp5, nums5);

        int[] nums6 = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] numsExp6 = {4, 5, 6, 7, 8, 9, 1, 2, 3,};
        p.rotate2a(nums6, 6);
        assertArrayEquals(numsExp6, nums6);

        int[] nums7 = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] numsExp7 = {3, 4, 5, 6, 7, 8, 9, 1, 2};
        p.rotate2a(nums7, 7);
        assertArrayEquals(numsExp7, nums7);

        int[] nums8 = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] numsExp8 = {2, 3, 4, 5, 6, 7, 8, 9, 1};
        p.rotate2a(nums8, 8);
        assertArrayEquals(numsExp8, nums8);

        int[] nums9 = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] numsExp9 = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        p.rotate2a(nums9, 9);
        assertArrayEquals(numsExp9, nums9);

        int[] nums10 = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] numsExp10 = {9, 1, 2, 3, 4, 5, 6, 7, 8};
        p.rotate2a(nums10, 10);
        assertArrayEquals(numsExp10, nums10);

        int[] nums11 = {};
        int[] numsExp11 = {};
        p.rotate2a(nums11, 10);
        assertArrayEquals(numsExp11, nums11);

        int[] nums12 = {1};
        int[] numsExp12 = {1};
        p.rotate2a(nums12, 10);
        assertArrayEquals(numsExp12, nums12);

        int[] nums13 = {1};
        int[] numsExp13 = {1};
        p.rotate2a(nums13, 0);
        assertArrayEquals(numsExp13, nums13);

        int[] nums14 = {1, 2};
        int[] numsExp14 = {2, 1};
        p.rotate2a(nums14, 3);
        assertArrayEquals(numsExp14, nums14);

    } // testRotate2a()

    @Test
    void testRotate3() {
        var p = new RotateArray();

        int[] nums1 = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] numsExp1 = {9, 1, 2, 3, 4, 5, 6, 7, 8};
        p.rotate3(nums1, 1);
        assertArrayEquals(numsExp1, nums1);

        int[] nums2 = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] numsExp2 = {8, 9, 1, 2, 3, 4, 5, 6, 7};
        p.rotate3(nums2, 2);
        assertArrayEquals(numsExp2, nums2);

        int[] nums3 = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] numsExp3 = {7, 8, 9, 1, 2, 3, 4, 5, 6};
        p.rotate3(nums3, 3);
        assertArrayEquals(numsExp3, nums3);

        int[] nums4 = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] numsExp4 = {6, 7, 8, 9, 1, 2, 3, 4, 5};
        p.rotate3(nums4, 4);
        assertArrayEquals(numsExp4, nums4);

        int[] nums5 = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] numsExp5 = {5, 6, 7, 8, 9, 1, 2, 3, 4};
        p.rotate3(nums5, 5);
        assertArrayEquals(numsExp5, nums5);

        int[] nums6 = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] numsExp6 = {4, 5, 6, 7, 8, 9, 1, 2, 3,};
        p.rotate3(nums6, 6);
        assertArrayEquals(numsExp6, nums6);

        int[] nums7 = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] numsExp7 = {3, 4, 5, 6, 7, 8, 9, 1, 2};
        p.rotate3(nums7, 7);
        assertArrayEquals(numsExp7, nums7);

        int[] nums8 = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] numsExp8 = {2, 3, 4, 5, 6, 7, 8, 9, 1};
        p.rotate3(nums8, 8);
        assertArrayEquals(numsExp8, nums8);

        int[] nums9 = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] numsExp9 = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        p.rotate3(nums9, 9);
        assertArrayEquals(numsExp9, nums9);

        int[] nums10 = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] numsExp10 = {9, 1, 2, 3, 4, 5, 6, 7, 8};
        p.rotate3(nums10, 10);
        assertArrayEquals(numsExp10, nums10);

        int[] nums11 = {};
        int[] numsExp11 = {};
        p.rotate3(nums11, 10);
        assertArrayEquals(numsExp11, nums11);

        int[] nums12 = {1};
        int[] numsExp12 = {1};
        p.rotate3(nums12, 10);
        assertArrayEquals(numsExp12, nums12);

        int[] nums13 = {1};
        int[] numsExp13 = {1};
        p.rotate3(nums13, 0);
        assertArrayEquals(numsExp13, nums13);

        int[] nums14 = {1, 2};
        int[] numsExp14 = {2, 1};
        p.rotate3(nums14, 3);
        assertArrayEquals(numsExp14, nums14);

        int[] nums15 = {1, 2, 3, 4, 5, 6, 7, 8};
        int[] numsExp15 = {6, 7, 8, 1, 2, 3, 4, 5};
        p.rotate3(nums15, 3);
        assertArrayEquals(numsExp15, nums15);

        int[] nums16 = {1, 2, 3, 4, 5, 6, 7, 8};
        int[] numsExp16 = {5, 6, 7, 8, 1, 2, 3, 4};
        p.rotate3(nums16, 4);
        assertArrayEquals(numsExp16, nums16);

    } // testRotate3()


} // class RotateArrayTest