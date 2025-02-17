import javax.swing.JPanel;
import java.awt.*;
import java.awt.geom.*;

public class Cat {
	// drawing constants are private - noone needs to know what we're doing
	// pick a head dimension
	private static final int HEAD_DIMENSION = 100;
	// eyes will be about 1/4 from top of head and 1/4 from left
	private static final int EYE_Y = HEAD_DIMENSION/4;
	private static final int EYE_X = HEAD_DIMENSION/4;
	private static final int EYE_SEPARATION = HEAD_DIMENSION/3;
	// pick eye dimensions
	private static final int EYE_HEIGHT = 20;
	private static final int EYE_WIDTH = 10;
	// pick mouth height, width is based on head dimension
	private static final int MOUTH_HEIGHT = 10;
	private static final int MOUTH_WIDTH = HEAD_DIMENSION/4;
	// mouth starts about 40% from left edge of head
	private static final int MOUTH_X = HEAD_DIMENSION/5 * 2;
	private static final int MOUTH_Y = HEAD_DIMENSION/5 * 3;
	
	// pick nose dimensions and position
	private static final int NOSE_WIDTH = 10;
    private static final int NOSE_HEIGHT = 10;
    private static final int NOSE_X = HEAD_DIMENSION / 2 - NOSE_WIDTH / 2;
    private static final int NOSE_Y = HEAD_DIMENSION / 2 - NOSE_HEIGHT / 2;
	
	// draw will render the Cat on the Graphics object
	public void draw(Graphics g, int catX, int catY)
	{
		Graphics2D g2 = (Graphics2D) g;
		int x=catX;
		int y=catY;
		// Draw the head
		g2.setColor(Color.black);
		g2.fillOval(x, y, HEAD_DIMENSION, HEAD_DIMENSION);
		// Draw the eyes
		g2.setColor(Color.green);
		x = catX + EYE_X; 
		y = catY + EYE_Y;
		g2.fillOval(x, y, EYE_WIDTH, EYE_HEIGHT);
		x += EYE_SEPARATION;
		g2.fillOval(x, y, EYE_WIDTH, EYE_HEIGHT);
		// Draw the mouth
		g2.setColor(Color.pink);
		x = catX + MOUTH_X - 5;
		y = catY + MOUTH_Y + 10;
		g2.fillOval(x, y, MOUTH_WIDTH, MOUTH_HEIGHT);
		g2.setColor(Color.black);
		// Meow text appears below cat head, +10 places below 
		// so it doesn't overlap the drawing
		g2.drawString("Meow", catX, catY+HEAD_DIMENSION+10);
		
		// Draw the left 
		g2.setColor(Color.black);
		Polygon leftEar = new Polygon();
        leftEar.addPoint(catX , catY + 40);   
        leftEar.addPoint(catX + 20, catY - 20); 
        leftEar.addPoint(catX + 40, catY + 10);
        g2.fillPolygon(leftEar);

        // Draw the right ear
        // Still using black
        Polygon rightEar = new Polygon();
        rightEar.addPoint(catX + HEAD_DIMENSION - 40, catY + 10);
        rightEar.addPoint(catX + HEAD_DIMENSION - 30, catY - 20); 
        rightEar.addPoint(catX + HEAD_DIMENSION, catY + 40); 
        g2.fillPolygon(rightEar);
        
        // Draw nose
        g2.setColor(Color.pink);
        Polygon nose = new Polygon();
        nose.addPoint(catX + HEAD_DIMENSION / 2 - 5, catY + HEAD_DIMENSION / 2 + 10);
        nose.addPoint(catX + HEAD_DIMENSION / 2 - 10, catY + HEAD_DIMENSION / 2 + 5);
        nose.addPoint(catX + HEAD_DIMENSION / 2, catY + HEAD_DIMENSION / 2 + 5);
        g2.fillPolygon(nose);
        
        // Tings for Thombas to maybe add: update coordinates for things, Add whiskers, Add teeth;
        
	}
}
