import java.util.ArrayList;
import java.util.PriorityQueue;

public class SingleThreadedCPU {
/*
You are given n tasks labeled from 0 to n - 1 represented by a 2D integer array
tasks, where tasks[i] = [enqueueTime, processingTime] means that the ith task
will be available to process at enqueueTime and will take processingTime to finish processing.

You have a single-threaded CPU that can process at most one task at a time and
will act in the following way:

* If the CPU is idle and there are no available tasks to process, the CPU remains idle.
* If the CPU is idle and there are available tasks, the CPU will choose the one
  with the shortest processing time. If multiple tasks have the same shortest
  processing time, it will choose the task with the smallest index.
* Once a task is started, the CPU will process the entire task without stopping.
* The CPU can finish a task then start a new one instantly.

Return the order in which the CPU will process the tasks.

 */

    public int[] getOrder(int[][] tasks) {
        int cpuTime = 1;
        int numOfTasks = tasks.length;
        int[] completedTasks = new int[numOfTasks];
        int numOfCompletedTasks = 0;

        // Copy the task info into objects and add the objects to a pending list.
        // "Pending" tasks are tasks that will start in the future.
        // NOTE: I tried a PriorityQueue, but the performance was bad.
        ArrayList<Task> pendingTasks = new ArrayList<>(numOfTasks);
        for (int i = 0; i < tasks.length; ++i) {
            var task = new Task(i, tasks[i][0], tasks[i][1]);
            pendingTasks.add(task);
        } // for i

        // sort the pending task list by start time
        pendingTasks.sort(new PendingTasksComparator());

        // use this index to walk thru the pending tasks list
        int pendingTasksIndex = 0;

        // "Available" tasks are those tasks that can be run right now but the CPU.
        // This list is sorted by processing time (shortest first), then by task ID (smallest first).
        // NOTE: PriorityQueue's toString() function does NOT print the items in the corrected sorted order.
        PriorityQueue<Task> availableTasks = new PriorityQueue<>(numOfTasks, new AvailableTasksComparator());

        while ((pendingTasksIndex < pendingTasks.size()) || (availableTasks.size() > 0)) {
            // If a task can be run (aka, if the task's starting time is less than or equal to the current cpu time),
            // then move the task  from the pending queue to the available queue
            while ((pendingTasksIndex < pendingTasks.size()) && pendingTasks.get(pendingTasksIndex).getStartTime() <= cpuTime) {
                availableTasks.add(pendingTasks.get(pendingTasksIndex));
                pendingTasksIndex++;
            } // while

            if (availableTasks.size() > 0) {
                Task task = availableTasks.poll();
                cpuTime += task.getProcTime();
                completedTasks[numOfCompletedTasks++] = task.getTaskID();
            } else {
                if (pendingTasksIndex < pendingTasks.size()) {
                    cpuTime = pendingTasks.get(pendingTasksIndex).getStartTime();
                }
            } // if
        } // while


        return completedTasks;

    } // getOrder()

} // class SingleThreadedCPU
