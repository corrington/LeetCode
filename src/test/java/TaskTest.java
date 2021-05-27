import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class TaskTest {

    @Test
    public void testGetTaskID() {
        int expectedTaskID = 34;
        Task t = new Task(expectedTaskID,0,0);
        int actualTaskID = t.getTaskID();
        assertEquals(actualTaskID,expectedTaskID);
    } // testGetTaskID()

    @Test
    public void testSetTaskID() {
        Task t = new Task(0,0,0);
        int expectedTaskID = 34;
        t.setTaskID(expectedTaskID);
        int actualTaskID = t.getTaskID();
        assertEquals(actualTaskID,expectedTaskID);
    } // testSetTaskID()

    @Test
    public void testGetStartTime() {
        int expectedStartTime = 34;
        Task t = new Task(0,expectedStartTime,0);
        int actualStartTime = t.getStartTime();
        assertEquals(actualStartTime,expectedStartTime);
    } // testGetStartTime()

    @Test
    public void testSetStartTime() {
        Task t = new Task(0,0,0);
        int expectedStartTime = 34;
        t.setStartTime(expectedStartTime);
        int actualStartTime = t.getStartTime();
        assertEquals(actualStartTime,expectedStartTime);
    } // testSetStartTime()

    @Test
    public void testGetProcTime() {
        int expectedProcTime = 34;
        Task t = new Task(0,0,expectedProcTime);
        int actualProcTime = t.getProcTime();
        assertEquals(actualProcTime,expectedProcTime);
    } // testGetProcTime()

    @Test
    public void testSetProcTime() {
        Task t = new Task(0,0,0);
        int expectedProcTime = 34;
        t.setProcTime(expectedProcTime);
        int actualProcTime = t.getProcTime();
        assertEquals(actualProcTime,expectedProcTime);
    } // testSetProcTime() 
} // class TaskTest