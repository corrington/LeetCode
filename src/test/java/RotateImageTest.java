import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;


 class RotateImageTest {

    // a little helper method
    private boolean areEqual(int[][] a, int[][] b) {

        // a few quick sanity checks
        if ((a == null) && (b == null)) return true;
        if (a.length != b.length) return false;
        if (a.length == 0) return true;
        if (a[0].length != b[0].length) return false;

        // compare element against element
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                if (a[i][j] != b[i][j]) return false;
            } // for j
        } // for i
        return true;
    }

    @Test
    void testRotate() {
        var p = new RotateImage();

        int[][] matrix1 = {{1,2,3}, {4,5,6}, {7,8,9}};
        p.rotate(matrix1); // performs in-place rotation
        int[][] exp1 = {{7,4,1,}, {8,5,2}, {9,6,3}};
        assertTrue(areEqual(matrix1, exp1));

        int[][] matrix2 = {{5,1,9,11},{2,4,8,10},{13,3,6,7},{15,14,12,16}};
        p.rotate(matrix2); // performs in-place rotation
        int[][] exp2 = {{15,13,2,5},{14,3,4,1},{12,6,8,9},{16,7,10,11}};
        assertTrue(areEqual(matrix2, exp2));

    } // testRotate()
} // class RotateImageTest