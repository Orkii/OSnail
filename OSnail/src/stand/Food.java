package stand;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.geom.Ellipse2D;
import java.util.Random;

public class Food extends GameObject{
	
	static Vector2D size = new Vector2D(25,25);
	
	public Food() {
		super();
		
		Random rnd = new Random();
	    int x = rnd.nextInt(Window.size.x-200) + 100;
	    int y = rnd.nextInt(Window.size.y-200) + 100;
	    body = new Ellipse2D.Double(x, y, size.x, size.y);
	    
		tag = "food";
	}
	
	public Food(int x, int y) {
		super();
		
		body = new Ellipse2D.Double(x, y, size.x, size.y);
		
		tag = "food";
	}
	
	@Override
	public void paint(Graphics my_picture) {
		// TODO Auto-generated method stub
		//System.out.println("Hello World!");
		my_picture.setColor(Color.GREEN);
		//Graphics2D g2 = (Graphics2D) my_picture;
		//g2.draw(body);
		my_picture.fillOval( 				
				(int)(body.getBounds2D().getX()),
				(int)(body.getBounds2D().getY()), 
				(int)(size.x),
				(int)(size.y));
	}
	
	@Override
	public void death() {
		// TODO Auto-generated method stub
		//Random rnd = new Random();
	    //int x = rnd.nextInt(Core.window.size.x);
	    //int y = rnd.nextInt(Core.window.size.y);
	    new Food();
	    Core.objects.remove(this);
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void tick() {
		// TODO Auto-generated method stub
		
	}


	
}
