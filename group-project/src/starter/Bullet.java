package starter;

import acm.graphics.*;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import javax.swing.ImageIcon;

public abstract class Bullet implements Displayable {
    int xPosition, yPosition;
	
    public int getxPos() {
        return xPosition;
    }
    
    public int getyPos() {
        return yPosition;
    }
    
	/*
	 * @Override public void draw(Graphics g) { g.setColor(Color.RED);
	 * g.fillRect(this.getxPos(), this.getyPos(), 7, 15);
	 * 
	 * }
	 */
}