package stand;

import java.awt.event.KeyEvent;

interface KeyListener {
    void keyPressed(KeyEvent e);
    void keyTyped(KeyEvent e);
    void keyReleased(KeyEvent e);
}
