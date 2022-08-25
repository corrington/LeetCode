import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AvailableTasksComparatorTest {

    @Test
    void testCompare() {
        AvailableTasksComparator atc = new AvailableTasksComparator();
        Task t1, t2;
        int actualResult, expectedResult;

        // Test Case 1
        t1 = new Task(1,0,3);
        t2 = new Task(2,0,5);
        actualResult = atc.compare(t1,t2);
        expectedResult = -1;
        assertEquals(actualResult,expectedResult);

        // Test Case 2
        t1 = new Task(1,0,3);
        t2 = new Task(2,0,3);
        actualResult = atc.compare(t1,t2);
        expectedResult = -1;
        assertEquals(actualResult,expectedResult);

        // Test Case 3
        t1 = new Task(1,0,5);
        t2 = new Task(2,0,3);
        actualResult = atc.compare(t1,t2);
        expectedResult = 1;
        assertEquals(actualResult,expectedResult);

        // Test Case 4
        t1 = new Task(2,0,5);
        t2 = new Task(1,0,5);
        actualResult = atc.compare(t1,t2);
        expectedResult = 1;
        assertEquals(actualResult,expectedResult);

        // Note, two tasks can NEVER be equal because task ID is unique
        // if this happens, an IllegalArgumentException is thrown

    } // testCompare()
} // TaskComparatorTest