import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.Timer;

class GamePanel extends JPanel implements ActionListener, KeyListener{
	Font titleFont = new Font("Arial", Font.PLAIN, 24);
	static final int MENU = 0;
    static final int GAME = 1;
    static final int END = 2;
    static int currentState = MENU;
    Timer frameDraw;
    Rocketship r=new Rocketship(250,700,50,50);
    GamePanel(){
    	this.frameDraw=new Timer(1000/60,this);
    	frameDraw.start();
    }
	@Override
	public void paintComponent(Graphics g){
		if(currentState == MENU){
		    drawMenuState(g);
		}else if(currentState == GAME){
		    drawGameState(g);
		}else if(currentState == END){
		    drawEndState(g);
		}
	}
	void updateMenuState() { 
		
	}
	void updateGameState() { 
		
	}
	void updateEndState()  { 
		
	}
	void drawMenuState(Graphics g) { 
		g.setColor(Color.BLUE);
		g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
		g.setFont(titleFont);
		g.setColor(Color.YELLOW);
		g.drawString("LEAGUE INVADERS", 100, 200);
		g.drawString("Press ENTER to start", 100, 400);
		g.drawString("Press SPACE for instructions", 100, 600);
	}
	void drawGameState(Graphics g) { 
		r.draw(g);
		System.out.println("game");
	}
	void drawEndState(Graphics g)  { 
		g.drawString("Game Over", 250, 400);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		System.out.println("game");
		if(currentState == MENU){
		    updateMenuState();
		}else if(currentState == GAME){
		    updateGameState();
		}else if(currentState == END){
		    updateEndState();
		}
		repaint();
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if (e.getKeyCode()==KeyEvent.VK_ENTER) {
		    if (currentState == END) {
		        currentState = MENU;
		    } else {
		        currentState++;
		    }
		}
		if (e.getKeyCode()==KeyEvent.VK_UP) {
		    r.up(speed);
		}
		if (e.getKeyCode()==KeyEvent.VK_DOWN) {
		    r.down(speed);
		}
		if (e.getKeyCode()==KeyEvent.VK_RIGHT) {
		    r.right(speed);
		}
		if (e.getKeyCode()==KeyEvent.VK_LEFT) {
		    r.left(speed);
		}
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
