package stand;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;

public class Window extends JFrame implements KeyListener  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//ArrayList<GameObject> objects = new ArrayList<GameObject>();
    private JTextArea textArea;
	
	static Vector2D size = new Vector2D(800, 800);
	
	public Window(String s){
		super(s);
		setLayout(null);
		setSize(size.x, size.y);
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
        textArea = new JTextArea();
        textArea.addKeyListener(this);
        add(textArea);
        
        
        
		Core.objects.add(new Snake());
		
        setVisible(true);
        

		
	}
	public void paint(Graphics my_picture){
		
		Image offImg = createImage(size.x, size.y);
		Graphics offGr = offImg.getGraphics();
		offGr.setColor(Color.LIGHT_GRAY);
		offGr.fillRect(0, 0, size.x, size.y);

		for(GameObject item : Core.objects ) {
			item.paint(offGr);
		}
		my_picture.drawImage(offImg, 0, 0, this);
		

	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
        for (stand.KeyListener kl : Core.keyListeners) {
            kl.keyTyped(e);
        }
	}
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
        for (stand.KeyListener kl : Core.keyListeners) {
            kl.keyPressed(e);
        }
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
        for (stand.KeyListener kl : Core.keyListeners) {
            kl.keyReleased(e);
        }
        
	}
}


