public class SimplePoint {
    private int x;
    private int y;

    public SimplePoint() {
        this.x = 0;
        this.y = 0;
    }

    public SimplePoint(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    private double distance(int x1, int y1, int x2, int y2) {
        double result = Math.sqrt(Math.pow((x2 - x1), 2) + Math.pow((y2 - y1), 2));
        return result;
    }

    public double distance(int x, int y) {
        return distance(this.x, this.y, x, y);
    }

    public double distance() {
        return distance(0, 0);
    }

    public double distance(SimplePoint pt) {
        return distance(pt.x, pt.y);
    }

} // class SimplePoint
