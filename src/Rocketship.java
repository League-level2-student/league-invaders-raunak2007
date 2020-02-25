import java.awt.Color;
import java.awt.Graphics;

class Rocketship extends GameObject {

	Rocketship(int x, int y, int width, int height) {
		super(x, y, width, height);
		speed=10;
		// TODO Auto-generated constructor stub
	} 
	void draw(Graphics g) {
		g.setColor(Color.BLUE);
        g.fillRect(x, y, width, height);
	}
	public void right(int s) {
        x+=s;
    }
	public void left(int s) {
        x-=s;
    }
	public void down(int s) {
        y-=s;
    }
	public void up(int s) {
        y+=s;
    }

}
