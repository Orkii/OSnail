package stand;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.geom.Ellipse2D;
import java.util.ArrayDeque;
import java.awt.event.KeyEvent;



public class SnakePart extends GameObject {
	
	protected Vector2D size = new Vector2D(50, 50);
	public SnakePart nextPart;
	public SnakePart prevPart;
	private ArrayDeque<Vector2DD> poss = new ArrayDeque<Vector2DD>();
	
	protected int numer;
	
	static int tickWindow = 15;
	
	public SnakePart(){
		super();
		body = new Ellipse2D.Double(100, 100, size.x, size.y);
		tag = "part";
	}
	public SnakePart(SnakePart nextPart_){
		super();
		nextPart = nextPart_;
		body = new Ellipse2D.Double(nextPart.body.getBounds2D().getX(), nextPart.body.getBounds2D().getY(), size.x, size.y);
		tag = "part";
	}
	
	@Override
	public void paint(Graphics my_picture) {
		//Graphics2D g2 = (Graphics2D) my_picture;
		// TODO Auto-generated method stub
		my_picture.setColor(Color.RED);
		//g2.draw(body);
		
		my_picture.fillOval( 				
				(int)(body.getBounds2D().getX()),
				(int)(body.getBounds2D().getY()), 
				(int)(size.x),
				(int)(size.y));
		

	}
	
	public void addTail(){
		if (prevPart != null) {
			prevPart.addTail();
			return;
		}
		SnakePart p = new SnakePart(this);
		p.numer = numer + 1;
		prevPart = p;
		//parts.add(p);
	
	}
	
	@Override
	public void tick() {
		// TODO Auto-generated method stub

		
		if (nextPart == null) return;
		poss.addLast(new Vector2DD(nextPart.body.getBounds2D().getX(), nextPart.body.getBounds2D().getY()));
		if (poss.size() >= tickWindow) {
			Vector2DD ns = poss.pop();
			body = new Ellipse2D.Double(ns.x , ns.y, size.x, size.y);
		}
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
	public void death() {
		// TODO Auto-generated method stub
		
	}

}
