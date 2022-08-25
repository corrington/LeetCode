import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PendingTasksComparatorTest {

    @Test
    void testCompare() {
        PendingTasksComparator ptc = new PendingTasksComparator();
        Task t1, t2;
        int actualResult, expectedResult;

        // Test Case 1 - less than
        t1 = new Task(1,1,1);
        t2 = new Task(2,2,1);
        actualResult = ptc.compare(t1,t2);
        expectedResult = -1;
        assertEquals(actualResult,expectedResult);

        // Test Case 2 - equals
        t1 = new Task(1,1,1);
        t2 = new Task(2,1,1);
        actualResult = ptc.compare(t1,t2);
        expectedResult = 0;
        assertEquals(actualResult,expectedResult);

        // Test Case 3 - greater than
        t1 = new Task(1,2,1);
        t2 = new Task(2,1,1);
        actualResult = ptc.compare(t1,t2);
        expectedResult = 1;
        assertEquals(actualResult,expectedResult);

    } // testCompare()

} // class PendingTasksComparatorTest