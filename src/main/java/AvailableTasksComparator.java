import java.util.Comparator;

class AvailableTasksComparator implements Comparator<Task> {

    @Override
    public int compare(Task t1, Task t2) {
        if (t1 == t2) return 0;
        int result;
        if (t1.getProcTime() != t2.getProcTime()) {
            result = Integer.compare(t1.getProcTime(),t2.getProcTime());
        } else {
            result = Integer.compare(t1.getTaskID(),t2.getTaskID());
        }
        return result;
    } // compare()

} //  class AvailableTasksComparator
