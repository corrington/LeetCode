import java.util.Comparator;

class PendingTasksComparator implements Comparator<Task> {

    @Override
    public int compare(Task t1, Task t2) {
        int result = Integer.compare(t1.getStartTime(), t2.getStartTime());
        return result;
    } // compare()

} // class PendingTasksComparator
