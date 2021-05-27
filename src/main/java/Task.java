class Task {

    private int taskID;
    private int startTime;
    private int procTime;

    Task(int taskID, int startTime, int procTime) {
        this.setTaskID(taskID);
        this.setStartTime(startTime);
        this.setProcTime(procTime);
    } // Task() constructor

    int getTaskID() {
        return taskID;
    }

    void setTaskID(int taskID) {
        this.taskID = taskID;
    }

    int getStartTime() {
        return startTime;
    }

    void setStartTime(int startTime) {
        this.startTime = startTime;
    }

    int getProcTime() {
        return procTime;
    }

    void setProcTime(int procTime) {
        this.procTime = procTime;
    }

    public String toString() {
        String str = "{" + taskID + ", " + startTime + ", " + procTime + "}";
        return str;
    } // toString()

} // class Task
