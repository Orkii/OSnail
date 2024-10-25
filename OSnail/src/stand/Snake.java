package stand;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class Snake extends GameObject {
	
	
	ArrayList<SnakePart> parts = new ArrayList<SnakePart>();
	SnakeHead head;
	

	
	public Snake(){
		//parts.add(new SnakePart());
		head = new SnakeHead();
		SnakePart p = new SnakePart(head);
		p.numer = 1;
		head.prevPart = p;
		parts.add(p);
	}
	
	@Override
	public void paint(Graphics my_picture) {
		// TODO Auto-generated method stub
		//my_picture.setColor(Color.RED);
		//my_picture.drawOval(90, 50, 200, 200);
		
		//for (SnakePart item : parts) {
		//	item.paint(my_picture);
		//}
		//head.paint(my_picture);
		
	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub
		
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
