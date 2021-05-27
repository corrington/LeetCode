import org.testng.annotations.Test;

import java.util.Arrays;

import static org.testng.Assert.assertTrue;

public class SingleThreadedCPU2Test {

    @Test
    public void testGetOrder() {

        var cpu = new SingleThreadedCPU2();

        // Test Case 1
        int[][] input1 = {{1,2}, {2,4}, {3,2}, {4,1}};
        int[] expectedOutput1 = {0,2,3,1};
        int[] actualOutput1;

        actualOutput1 =cpu.getOrder(input1);
        System.out.println("completed tasks order: " + Arrays.toString(actualOutput1) );
        assertTrue(Arrays.equals(actualOutput1, expectedOutput1));

        // Test Case 2
        int[][] input2 = {{7,10},{7,12},{7,5},{7,4},{7,2}};
        int[] expectedOutput2 = {4,3,2,0,1};
        int[] actualOutput2;

        actualOutput2 =cpu.getOrder(input2);
        System.out.println("completed tasks list is : " + Arrays.toString(actualOutput2) );
        assertTrue(Arrays.equals(actualOutput2, expectedOutput2));


    }
}