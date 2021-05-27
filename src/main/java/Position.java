import java.util.Objects;

final class Position implements Comparable<Position> {
    // NOTE: this class is immutable so it can be used as a key in a hash table.
    private final int lane;
    private final int step;

    public int getLane() {
        return lane;
    }

    public int getStep() {
        return step;
    }

    Position(int lane, int step) {
        this.lane = lane;
        this.step = step;
    } // Position() constructor

    @Override
    public boolean equals(Object obj) {
        // do we have an object to examine?
        if (obj == null) return false;
        // is it the same object?
        if (this == obj) return true;
        // are the two objects of the same class?
        if (this.getClass() != obj.getClass()) return false;
        // perform a value comparison
        Position pos = (Position)obj;
        Boolean result = ((lane == pos.lane) && (step == pos.step));
        return result;
    }

    @Override
    public int hashCode() {
        return Objects.hash(lane, step);
    }

    @Override
    public String toString() {
        String str = new String("(" + lane + "," + step + ")");
        return str;
    } // toString

    @Override
    public int compareTo(Position pos) {
        // if it's the same object, they are obviously equal
        if (this == pos) return 0;
        // the position further down the road (e.g., the larger step) is bigger
        int result = (pos.getStep() - this.step);
        return result;
    }
} // class Position
