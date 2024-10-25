package stand;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class Core {
	
	static boolean gameOver = false;
	
	static int TPS = 60;
	
	static Window window;
	
	static ArrayList<GameObject> objects = new ArrayList<GameObject>();
	
	static public ArrayList<KeyListener> keyListeners = new ArrayList<KeyListener>();
	
	
	public static void addGameObject(GameObject gobj) {
		objects.add(gobj);
	}
	public static void removeGameObject(GameObject gobj) {
		objects.remove(gobj);
	}
	
	public static void main() {

		Timer myTimer;
		myTimer = new Timer();

		myTimer.schedule(new TimerTask() {
			public void run() {
				timerTick();
			}
		}, 0, 17);  // 60 FPS
		
	}
	public static void timerTick() {
		if (gameOver == true) {
			return;
		}
		@SuppressWarnings("unchecked")
		ArrayList<GameObject> temp = (ArrayList<GameObject>)objects.clone();
		
		for (GameObject item : temp) {
			item.tick();
		}
		window.repaint();
	}
}
