package stand;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Shape;
import java.awt.event.KeyEvent;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

public class SnakeHead extends SnakePart{
	
	protected Shape bBody;
	protected int eyeSize = 12;
	protected int eyeOffset = 12;
	protected double dir = 0;
	protected double speed = 2;
	protected double rotateSpeed = 0.05;
	protected int score = 0;
	ArrayList<KeyEvent> keyPressed = new ArrayList<KeyEvent>();
	//KeyEvent keyPressed;
	
	public SnakeHead () {
		
		super();	
		bBody = new Ellipse2D.Double(25, 25, size.x, size.y);
		tag = "head";
		numer = 0;
	}
	@Override
	public void paint(Graphics my_picture) {
		super.paint(my_picture);
		
		//Graphics2D g2 = (Graphics2D) my_picture;
		
		//g2.draw(bBody);
		my_picture.setColor(Color.BLUE);
		
		my_picture.fillOval( 				
				(int)(body.getBounds2D().getCenterX() + (Math.cos(dir) * eyeOffset)-eyeSize/2),
				(int)(body.getBounds2D().getCenterY() + (Math.sin(dir) * eyeOffset)-eyeSize/2), 
				(int)(eyeSize),
				(int)(eyeSize));
		
		my_picture.setColor(Color.BLACK);
		Font font = new Font("Serif", Font.PLAIN, 48);
		my_picture.setFont(font);
		my_picture.drawString(String.valueOf(score), 40, 80);
	}

	@Override
	public void tick() {
		super.tick();
		// TODO Auto-generated method stub
		if (keyPressed.size() != 0) {
			if (keyPressed.get(0).getKeyCode() == KeyEvent.VK_A) {
				dir -= rotateSpeed;
			}
			else if (keyPressed.get(0).getKeyCode() == KeyEvent.VK_D) {
				dir += rotateSpeed;
			}
		}
		
		Rectangle2D f = body.getBounds2D();
		if (f.getMaxX() >= Window.size.x) Core.gameOver = true;
		if (f.getMinX() <= 0) Core.gameOver = true;
		if (f.getMaxY() >= Window.size.y) Core.gameOver = true;
		if (f.getMinY() <= 0) Core.gameOver = true;
		

		
		@SuppressWarnings("unchecked")
		ArrayList<GameObject> objects1 = (ArrayList<GameObject>)Core.objects.clone();

		
		for (GameObject item : objects1) {
			if (item.tag == "food") {
				Rectangle2D f1 = body.getBounds2D();
				Rectangle2D f2 = item.body.getBounds2D();
				
				double dist = Math.sqrt(
						Math.pow(f1.getCenterX() - f2.getCenterX(), 2) + 
						Math.pow(f1.getCenterY() - f2.getCenterY(), 2));
				
				double radSum = (f1.getMaxX() - f1.getCenterX()) + (f2.getMaxX() - f2.getCenterX());
				if (radSum > dist) {
					item.death();
					score++;
					addTail();
				}
				
			}
			if (item.tag == "part") {
				if (((SnakePart)item).numer > 5) {
					Rectangle2D f1 = body.getBounds2D();
					Rectangle2D f2 = item.body.getBounds2D();
					
					double dist = Math.sqrt(
							Math.pow(f1.getCenterX() - f2.getCenterX(), 2) + 
							Math.pow(f1.getCenterY() - f2.getCenterY(), 2));
					
					double radSum = (f1.getMaxX() - f1.getCenterX()) + (f2.getMaxX() - f2.getCenterX());
					
					if (radSum > dist) {
						Core.gameOver = true;
					}
				}
			}
		}
		
		
		body = new Ellipse2D.Double(
				body.getBounds2D().getX() + (Math.cos(dir) * speed),
				body.getBounds2D().getY() + (Math.sin(dir) * speed),
				size.x, size.y);
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		keyPressed.add(e);
		//keyPressed = e;
		/*
		if (e.getKeyCode() == KeyEvent.VK_A) {
			dir--;
		}
		else if (e.getKeyCode() == KeyEvent.VK_D) {
			dir++;
		}
		*/
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		//keyPressed.remove(e);
		for (int i = 0; i < keyPressed.size(); i++) {
			if (keyPressed.get(i).getKeyCode() == e.getKeyCode()) {
				keyPressed.remove(i);
				i--;
			}
		}
		//keyPressed = null;
	}
}
