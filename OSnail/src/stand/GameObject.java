package stand;

import java.awt.Graphics;
import java.awt.Shape;


abstract public class GameObject implements KeyListener {
	protected Shape body;
	public abstract void paint(Graphics my_picture);
	String tag;
	public GameObject() {
		Core.addGameObject(this);
		Core.keyListeners.add(this);
	}
	
	public abstract void death();
	
	public abstract void tick();
	
}
