package blatt10;

public class SirpinskiOnCanvas extends RecuOnCanvas{
    @Override
    protected void drawRecursive(Line2D line, int depth) {
        drawLine(line);
        Point2D mid = line.getMidPoint();

       int factor = (int)(line.getEuclideanLength() * Math.sqrt(3) / 2);

        Point2D point = new Point2D(mid.getX(), mid.getY() - factor);



        Line2D line1 = new Line2D(line.getP1(), point);
        Line2D line2 = new Line2D(line.getP2(), point);
        drawLine(line1);
        drawLine(line2);
        if(depth < 9) {
            drawRecursive(new Line2D(line.getP1(), mid), depth + 1);
            drawRecursive(new Line2D(line.getP2(), mid), depth + 1);
            drawRecursive(new Line2D(line1.getMidPoint(), line2.getMidPoint()), depth + 1);

        }
    }

    public static void main(String[] args) {
        new SirpinskiOnCanvas();
    }

}
