package blatt10;
 
import java.awt.*;
import javax.swing.JFrame;

class Point2D
{
	private final int x, y;

	/** Konstruktor */
	Point2D(int x, int y){
		this.x=x; this.y = y;
	}
	
	int getX(){return this.x;}
	int getY(){return this.y;}
	
	/**  p2 von this abziehen */
	Point2D diff(Point2D p2){
		return new Point2D(this.getX() - p2.getX(),  this.getY() - p2.getY());
	}
	/** p2 zu this addieren */
	Point2D add(Point2D p2){
		return new Point2D(this.getX() + p2.getX(),  this.getY() + p2.getY());
	}
	/** Rotate 90 DEGs == pi/2 about origin */
	Point2D rotate90DEG(){
		return new Point2D(-this.y, this.x);
	}
}
class Line2D
{
	private final Point2D p1, p2;
	/** 
	 * Konstruktor
	 * @param p1 Anfangspunkt
	 * @param p2 Endpunkt
	 */
	Line2D(Point2D p1, Point2D p2)
	{
		this.p1 = p1; this.p2 = p2;
	}
	
	/** Mittelpunkt der Linie berechnen
	 * 
	 * @return Mittelpunkt
	 */
	protected Point2D getMidPoint() {
		return new Point2D( 
				(p1.getX() + p2.getX())/2, 
				(p1.getY() + p2.getY())/2 );
	}
	
	Point2D getP1(){ return this.p1; }
	Point2D getP2(){ return this.p2; }

	/** Linie um 90° um ihren Mittelpunkt drehen */
	Line2D rotate90Deg(){ 
		Point2D midPoint = getMidPoint();
		Line2D ret = new Line2D( 
				this.p1.diff(midPoint).rotate90DEG().add(midPoint),
				this.p2.diff(midPoint).rotate90DEG().add(midPoint)
				);
		return  ret;
	}
	/** Länge einer Linie berechnen
	 *  */
	double getEuclideanLength(){ 
		double dx = this.p2.getX() - this.p1.getX();
		double dy = this.p2.getY() - this.p1.getY();
		return  Math.sqrt(dx * dx + dy * dy);
	}
}
public class RecuOnCanvas extends JFrame {
	static long numLines = 0L;
	Graphics g = null;
	
	public RecuOnCanvas(){
        super();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(1024, 1024);
        this.setTitle("Ausgabe der Klasse " + this.getClass().getName()); 
        this.setVisible(true);
	}
	
    public static void main(String[] args) {
        new RecuOnCanvas();
    }
 
    public void paint(Graphics g){
    	this.g = g;
        int height = this.getHeight();
        int width = this.getWidth();
        
        /* Löschen des Fensterinhalts (wichtig bei erneutem Zeichnen): */
    	this.g.clearRect(0, 0, width, height);
    	RecuOnCanvas.numLines = 0;
    	
        this.drawRecursive(new Line2D(
        		new Point2D(width/4, height*3/4), new Point2D(width*3/4, height*3/4)
        		), 1);
        System.out.printf("Insgesamt %d Linien gezeichnet\n", RecuOnCanvas.numLines );
    } 

     protected void drawLine(Line2D line) {
    	RecuOnCanvas.numLines++;
    	this.g.drawLine( line.getP1().getX(), line.getP1().getY(), line.getP2().getX(), line.getP2().getY() );
    }
    
    /** Farbe und Strichstärke je nach Tiefe ändern, damit es besser aussieht
     * 
     * @param depth Tiefe der Rekursion
     */
	protected void beautify(int depth) {
		switch (depth % 6) {
		case 1: this.g.setColor(Color.BLACK); break;
		case 2: this.g.setColor(Color.BLUE); break;
		case 3: this.g.setColor(Color.MAGENTA); break;
		case 4: this.g.setColor(Color.RED); break;
		default: this.g.setColor(Color.PINK); break;
		}
	}

    protected void drawRecursive(Line2D line, int depth) { 
      		
    	this.beautify(depth);  // Je nach Tiefe kolorieren
      	
   		this.drawLine(line);
       
   		if (depth < 15)
    	{
        	Line2D lineRotated = line.rotate90Deg();
       		this.drawRecursive( new Line2D(line.getP1(), lineRotated.getP1()) , depth + 1);
       		this.drawRecursive( new Line2D(lineRotated.getP1(), line.getP2()) , depth + 1);
     	}
//   		else {
//   			System.out.println("base");
//   		}
    } 
}
